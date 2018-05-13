package com.hbfintech.pay.trade.service.txn.cdk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hbfintech.pay.common.dto.RequestDto;
import com.hbfintech.pay.common.dto.ResponseDto;
import com.hbfintech.pay.trade.kernal.checker.CheckResult;
import com.hbfintech.pay.trade.kernal.checker.RequestChecker;
import com.hbfintech.pay.trade.kernal.processor.TxnProcessor;

@Component
public class CdkReqSignProcessor implements TxnProcessor{

	@Autowired
	@Qualifier("comnReqCheckerChain")
	RequestChecker requestChecker;

	@Override
	public ResponseDto preProcess(RequestDto requestDto) {
		CheckResult checkResult = requestChecker.checkRequest(requestDto);
		if(!checkResult.isPass()){
			return new ResponseDto(checkResult.getRespCode());
		}
		return null;
	}

	@Override
	public ResponseDto process(RequestDto reqDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseDto postProcess(RequestDto reqDto, ResponseDto respDto) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
