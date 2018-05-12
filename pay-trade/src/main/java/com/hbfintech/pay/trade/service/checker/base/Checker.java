package com.hbfintech.pay.trade.service.checker.base;

public interface Checker
{
    public Boolean support(CheckContext checkContext);
    
    public CheckResult check(CheckContext checkContext);
}
