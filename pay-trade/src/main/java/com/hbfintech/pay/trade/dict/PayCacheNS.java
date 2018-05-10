package com.hbfintech.pay.trade.dict;

public interface PayCacheNS
{
    //命名空间前缀
    public static final String PAY_NS_PREFIX= "data:pay:";
    
    //银行
    public static final String BANK=PAY_NS_PREFIX+"bank:";
    
    //支付产品
    public static final String PROD=PAY_NS_PREFIX+"prod:";
    
    //商户
    public static final String MCH=PAY_NS_PREFIX+"mch:";
    
    //交易
    public static final String TXN=PAY_NS_PREFIX+"txn:";
    
}
