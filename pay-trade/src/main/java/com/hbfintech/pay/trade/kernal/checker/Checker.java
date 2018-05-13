package com.hbfintech.pay.trade.kernal.checker;

public interface Checker
{
    public Boolean support(CheckContext checkContext);
    
    public CheckResult check(CheckContext checkContext);
}
