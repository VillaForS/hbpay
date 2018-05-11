package com.hbfintech.pay.trade.dict;

public interface PayCacheKeys
{

    //系统里注册的银行
    public static final String BANK_VALIDBANKS = PayCacheNS.BANK+"validBanks";

    //系统里注册的支付产品
    public static final String PROD_VALIDPRODS = PayCacheNS.PROD+"validProds";
    
    //系统里注册的支付渠道
    public static final String CHANNEL_VALIDCHANNELS=PayCacheNS.CHANNEL+"validChannels";
    public static final String CHANNEL_PROD_OPEN=PayCacheNS.CHANNEL+"prod";
    
    //系统里注册的商户
    public static final String MCH_VALIDMCHS = PayCacheNS.MCH+"validMchs";
    
    //系统商户产品开通能力
    public static final String MCH_PROD = PayCacheNS.MCH+"mchProd";
    

    
    
    
}
