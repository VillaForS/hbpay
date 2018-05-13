package com.hbfintech.pay.trade.service.cwh;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.hbfintech.pay.common.util.BeanConvertUtils;
import com.hbfintech.pay.intf.dto.adapter.AdptCwhSignReqDto;
import com.hbfintech.pay.intf.dto.adapter.AdptCwhSignRespDto;
import com.hbfintech.pay.intf.dto.trade.cwh.CwhSignReqDto;
import com.hbfintech.pay.intf.dto.trade.cwh.CwhSignRespDto;
import com.hbfintech.pay.intf.enumm.RespCodeEnum;
import com.hbfintech.pay.trade.dict.PayConstants;
import com.hbfintech.pay.trade.dict.SeqEnum;
import com.hbfintech.pay.trade.dict.SignStatusEnum;
import com.hbfintech.pay.trade.kernal.checker.CheckContext;
import com.hbfintech.pay.trade.kernal.checker.CheckResult;
import com.hbfintech.pay.trade.kernal.checker.Checker;
import com.hbfintech.pay.trade.repository.dao.PayContractWithholdSignDao;
import com.hbfintech.pay.trade.repository.entity.PayContractWithholdSign;
import com.hbfintech.redis.sequence.utils.SequenceNoService;

@Component
public class CwhReqSignProcessor {

	@Autowired
	@Qualifier("comnReqCheckerChain")
	Checker requestChecker;
    @Autowired
	SequenceNoService sequenceNoService;
    @Autowired
    PayContractWithholdSignDao payContractWithholdSignDao;
    @Autowired
    RestTemplate restTemplate;
    @Value("txn.cwh.sign.url")
    String signUrl;
    
	public PayContractWithholdSign preProcess(CwhSignReqDto cdkSignReqDto) {
		
		PayContractWithholdSign payContractWithholdSign = new PayContractWithholdSign();
		
		if(StringUtils.isEmpty(cdkSignReqDto.getCardType())){
			cdkSignReqDto.setCardType(PayConstants.CARD_TYPE_DEBIT);
		}
		if(null==cdkSignReqDto.getCertType()){
			cdkSignReqDto.setCertType(PayConstants.CERT_TYPE_ID);
		}
		
		CheckContext checkContext = new CheckContext();
		checkContext.putAll(BeanConvertUtils.bean2Map(cdkSignReqDto));
		CheckResult checkResult = requestChecker.check(checkContext);
		if(!checkResult.isPass()){
			payContractWithholdSign.setRespCode(checkResult.getRespEnum().getCode());
			payContractWithholdSign.setRespMsg(checkResult.getRespEnum().getMessage());
			return payContractWithholdSign;
		}
		BeanConvertUtils.copyProperties(cdkSignReqDto, payContractWithholdSign);
		payContractWithholdSign.setWithholdSignNo(sequenceNoService.getSequenceNo(SeqEnum.PAY_CONTRSCT_WITHHOLD_SIGN.getCode(), SeqEnum.PAY_CONTRSCT_WITHHOLD_SIGN.getPrefix()));
		payContractWithholdSign.setStatus(SignStatusEnum.CREATED.getCode());
		payContractWithholdSignDao.insertSelective(payContractWithholdSign);
		return payContractWithholdSign;
	}

	public PayContractWithholdSign process(CwhSignReqDto cdkSignReqDto,PayContractWithholdSign payContractWithholdSign) {
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
		return payContractWithholdSign;
	}


	
	
}
