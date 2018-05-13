package com.hbfintech.pay.trade.controller.cwh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hbfintech.pay.common.util.BeanConvertUtils;
import com.hbfintech.pay.intf.dto.adapter.AdptCwhSignRespDto;
import com.hbfintech.pay.intf.dto.trade.cwh.CwhTxnReqDto;
import com.hbfintech.pay.intf.dto.trade.cwh.CwhTxnRespDto;
import com.hbfintech.pay.trade.kernal.checker.CheckContext;
import com.hbfintech.pay.trade.kernal.checker.CheckResult;
import com.hbfintech.pay.trade.kernal.checker.Checker;
import com.hbfintech.pay.trade.repository.entity.PayContractWithholdTxn;
import com.hbfintech.pay.trade.service.cwh.CwhTxnService;

@RestController("/cwh")
public class CwhTxnController {
	
	@Autowired
	@Qualifier("comnReqCheckerChain")
	Checker requestChecker;
    @Autowired
	CwhTxnService cwhTxnService;
	
	@RequestMapping("/txn")
	public CwhTxnRespDto txnRequest(CwhTxnReqDto reqDto){
		
		CwhTxnRespDto respDto = new CwhTxnRespDto();
		
		CheckResult checkResult = check(reqDto);
		if(!checkResult.isPass()){
			respDto.setRespCode(checkResult.getRespEnum().getCode());
			respDto.setRespMsg(checkResult.getRespEnum().getMessage());
			return respDto;
		}
		
		PayContractWithholdTxn payContractWithholdTxn = cwhTxnService.createTxnRecord(reqDto);
		
		AdptCwhSignRespDto adptCwhSignRespDto =cwhTxnService.postToChannel(reqDto, payContractWithholdTxn);
		
		BeanConvertUtils.copyProperties(adptCwhSignRespDto, respDto);
		
		return respDto;
	}
	
	public CheckResult check(CwhTxnReqDto reqDto){
		CheckContext checkContext = new CheckContext();
		checkContext.putAll(BeanConvertUtils.bean2Map(reqDto));
		return requestChecker.check(checkContext);
	}
}
