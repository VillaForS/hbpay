package com.hbfintech.pay.trade.service.common.checker;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hbfintech.pay.trade.kernal.checker.CheckContext;
import com.hbfintech.pay.trade.kernal.checker.CheckResult;
import com.hbfintech.pay.trade.kernal.checker.Checker;

@Component("comnReqCheckerChain")
public class ComnReqCheckerChain implements Checker{

	@Autowired
	List<ComnChecker> checkerChain;

	@Override
	public CheckResult check(CheckContext checkContext) {
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

	@Override
	public Boolean support(CheckContext checkContext) {
		return true;
	}
	
	
}
