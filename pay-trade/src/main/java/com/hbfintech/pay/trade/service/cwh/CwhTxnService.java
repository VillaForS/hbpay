package com.hbfintech.pay.trade.service.cwh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import com.hbfintech.pay.common.util.BeanConvertUtils;
import com.hbfintech.pay.intf.dto.adapter.AdptCwhSignRespDto;
import com.hbfintech.pay.intf.dto.adapter.AdptCwhTxnReqDto;
import com.hbfintech.pay.intf.dto.trade.cwh.CwhTxnReqDto;
import com.hbfintech.pay.intf.enumm.CwhTxnStatusEnum;
import com.hbfintech.pay.intf.enumm.RespCodeEnum;
import com.hbfintech.pay.trade.dict.SeqEnum;
import com.hbfintech.pay.trade.repository.dao.PayContractWithholdTxnDao;
import com.hbfintech.pay.trade.repository.entity.PayContractWithholdTxn;
import com.hbfintech.redis.sequence.utils.SequenceNoService;

public class CwhTxnService {

    @Autowired
	SequenceNoService sequenceNoService;
    @Autowired
    PayContractWithholdTxnDao payContractWithholdTxnDao;
    @Autowired
    RestTemplate restTemplate;
    @Value("txn.cwh.sign.url")
    String signUrl;
	
	public PayContractWithholdTxn createTxnRecord(CwhTxnReqDto cwhTxnReqDto) {
	    PayContractWithholdTxn PayContractWithholdTxn = new PayContractWithholdTxn();
		BeanConvertUtils.copyProperties(cwhTxnReqDto, PayContractWithholdTxn);
		PayContractWithholdTxn.setWithholdTxnNo(sequenceNoService.getSequenceNo(SeqEnum.PAY_CONTRACT_WITHHOLD_SIGN.getCode(), SeqEnum.PAY_CONTRACT_WITHHOLD_SIGN.getPrefix()));
		PayContractWithholdTxn.setStatus(CwhTxnStatusEnum.CREATED.getCode());
		payContractWithholdTxnDao.insertSelective(PayContractWithholdTxn);
		return PayContractWithholdTxn;
	}
	
	public AdptCwhSignRespDto postToChannel(CwhTxnReqDto cwhTxnReqDto,PayContractWithholdTxn payContractWithholdTxn) {
		AdptCwhTxnReqDto reqDto = new AdptCwhTxnReqDto();
		BeanConvertUtils.copyProperties(cwhTxnReqDto, reqDto);
		AdptCwhSignRespDto respDto = restTemplate.postForObject(signUrl, payContractWithholdTxn, AdptCwhSignRespDto.class);
		if(RespCodeEnum.SUCCESS.equals(respDto.getCode())){
			payContractWithholdTxnDao.processing(payContractWithholdTxn.getWithholdTxnId());
		}else{
			payContractWithholdTxn.setRespCode(respDto.getRespCode());
			payContractWithholdTxn.setRespMsg(respDto.getRespMsg());
			payContractWithholdTxn.setChannelRespCode(respDto.getChannelRespCode());
			payContractWithholdTxn.setChannelRespMsg(respDto.getChannelRespMsg());
			payContractWithholdTxnDao.fail(payContractWithholdTxn);
		}
		return respDto;
	}
}
