package com.hbfintech.pay.trade.service.common.checker;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hbfintech.pay.common.util.BeanConvertUtils;
import com.hbfintech.pay.intf.dto.RequestDto;
import com.hbfintech.pay.trade.kernal.checker.CheckContext;
import com.hbfintech.pay.trade.kernal.checker.CheckResult;
import com.hbfintech.pay.trade.kernal.checker.Checker;
import com.hbfintech.pay.trade.kernal.checker.RequestChecker;

@Component("comnReqCheckerChain")
public class ComnReqCheckerChain implements RequestChecker{

	@Autowired
	List<ComnChecker> checkerChain;

	@Override
	public CheckResult checkRequest(RequestDto requestDto) {
		CheckContext checkContext = new CheckContext();
		checkContext.putAll(BeanConvertUtils.bean2Map(requestDto));
		
		Iterator<ComnChecker> it =checkerChain.iterator() ;
		while(it.hasNext() ){
			Checker checker = it.next();
			if(checker.support(checkContext)){
				CheckResult checkResult = checker.check(checkContext);
				if(!checkResult.isPass()){
					return checkResult;
				}
			}
		}
		return new CheckResult(true,null);
	}
	
	
}
