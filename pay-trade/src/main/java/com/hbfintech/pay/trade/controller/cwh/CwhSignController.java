package com.hbfintech.pay.trade.controller.cwh;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hbfintech.pay.common.util.BeanConvertUtils;
import com.hbfintech.pay.intf.dto.adapter.AdptCwhSignRespDto;
import com.hbfintech.pay.intf.dto.trade.cwh.CwhSignReqDto;
import com.hbfintech.pay.intf.dto.trade.cwh.CwhSignRespDto;
import com.hbfintech.pay.trade.checker.CheckContext;
import com.hbfintech.pay.trade.checker.CheckResult;
import com.hbfintech.pay.trade.checker.Checker;
import com.hbfintech.pay.trade.dict.PayConstants;
import com.hbfintech.pay.trade.repository.dao.PayContractWithholdSignDao;
import com.hbfintech.pay.trade.repository.entity.PayContractWithholdSign;
import com.hbfintech.pay.trade.service.cwh.CwhSignService;
import com.hbfintech.redis.sequence.utils.SequenceNoService;

@RestController("/cwhSign")
public class CwhSignController {
	
	@Autowired
	@Qualifier("comnReqCheckerChain")
	Checker requestChecker;

	@Autowired
	CwhSignService cwhSignService;
	
    @Autowired
	SequenceNoService sequenceNoService;
    
    @Autowired
    PayContractWithholdSignDao payContractWithholdSignDao;
    
    @Autowired
    RestTemplate restTemplate;
    @Value("txn.cwh.sign.url")
    String signUrl;
	
	@RequestMapping("/sign")
	public CwhSignRespDto sign(CwhSignReqDto reqDto){
		CwhSignRespDto respDto = new CwhSignRespDto();
		
		CheckResult checkResult = check(reqDto);
		if(!checkResult.isPass()){
			respDto.setRespCode(checkResult.getRespEnum().getCode());
			respDto.setRespMsg(checkResult.getRespEnum().getMessage());
			return respDto;
		}
		
		PayContractWithholdSign payContractWithholdSign = cwhSignService.createSignRecord(reqDto);
		
		AdptCwhSignRespDto adptCwhSignRespDto =cwhSignService.postToChannel(reqDto, payContractWithholdSign);
		
		BeanConvertUtils.copyProperties(adptCwhSignRespDto, respDto);
		return respDto;
	}
	
	public CheckResult check(CwhSignReqDto cdkSignReqDto){
		if(StringUtils.isEmpty(cdkSignReqDto.getCardType())){
			cdkSignReqDto.setCardType(PayConstants.CARD_TYPE_DEBIT);
		}
		if(null==cdkSignReqDto.getCertType()){
			cdkSignReqDto.setCertType(PayConstants.CERT_TYPE_ID);
		}
		
		CheckContext checkContext = new CheckContext();
		checkContext.putAll(BeanConvertUtils.bean2Map(cdkSignReqDto));
		return requestChecker.check(checkContext);
	}
	
}
