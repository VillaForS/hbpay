package com.hbfintech.pay.trade.service.cwh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hbfintech.pay.common.util.BeanConvertUtils;
import com.hbfintech.pay.intf.dto.adapter.AdptCwhSignReqDto;
import com.hbfintech.pay.intf.dto.adapter.AdptCwhSignRespDto;
import com.hbfintech.pay.intf.dto.trade.cwh.CwhSignReqDto;
import com.hbfintech.pay.intf.enumm.CwhSignStatusEnum;
import com.hbfintech.pay.intf.enumm.RespCodeEnum;
import com.hbfintech.pay.trade.dict.SeqEnum;
import com.hbfintech.pay.trade.repository.dao.PayContractWithholdSignDao;
import com.hbfintech.pay.trade.repository.entity.PayContractWithholdSign;
import com.hbfintech.redis.sequence.utils.SequenceNoService;

@Service
public class CwhSignService {

    @Autowired
	SequenceNoService sequenceNoService;
    @Autowired
    PayContractWithholdSignDao payContractWithholdSignDao;
    @Autowired
    RestTemplate restTemplate;
    @Value("txn.cwh.sign.url")
    String signUrl;
    
    
    
public PayContractWithholdSign createSignRecord(CwhSignReqDto cdkSignReqDto) {
	    PayContractWithholdSign payContractWithholdSign = new PayContractWithholdSign();
		BeanConvertUtils.copyProperties(cdkSignReqDto, payContractWithholdSign);
		payContractWithholdSign.setWithholdSignNo(sequenceNoService.getSequenceNo(SeqEnum.PAY_CONTRACT_WITHHOLD_SIGN.getCode(), SeqEnum.PAY_CONTRACT_WITHHOLD_SIGN.getPrefix()));
		payContractWithholdSign.setStatus(CwhSignStatusEnum.CREATED.getCode());
		payContractWithholdSignDao.insertSelective(payContractWithholdSign);
		return payContractWithholdSign;
	}

	public AdptCwhSignRespDto postToChannel(CwhSignReqDto cdkSignReqDto,PayContractWithholdSign payContractWithholdSign) {
		AdptCwhSignReqDto reqDto = new AdptCwhSignReqDto();
		BeanConvertUtils.copyProperties(cdkSignReqDto, reqDto);
		AdptCwhSignRespDto respDto = restTemplate.postForObject(signUrl, payContractWithholdSign, AdptCwhSignRespDto.class);
		if(RespCodeEnum.SUCCESS.equals(respDto.getCode())){
			payContractWithholdSignDao.waitConfirm(payContractWithholdSign.getWithholdSignId());
		}else{
			payContractWithholdSign.setRespCode(respDto.getRespCode());
			payContractWithholdSign.setRespMsg(respDto.getRespMsg());
			payContractWithholdSign.setChannelRespCode(respDto.getChannelRespCode());
			payContractWithholdSign.setChannelRespMsg(respDto.getChannelRespMsg());
			payContractWithholdSignDao.fail(payContractWithholdSign);
		}
		return respDto;
	}
}
