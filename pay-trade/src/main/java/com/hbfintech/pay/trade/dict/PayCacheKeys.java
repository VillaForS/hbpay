package com.hbfintech.pay.trade.dict;

public interface PayCacheKeys
{

    /**
     * 银行缓存
     */
    //系统里注册的银行
    public static final String BANK_VALID= PayCacheNS.BANK+"validBanks";
    public static final String BANK_PROD_OPEN = PayCacheNS.BANK+"prodBanks";

    /**
     * 支付产品缓存
     */
    //系统里注册的支付产品
    public static final String PROD_VALID_PRODS = PayCacheNS.PROD+"validProds";
    
    
    /**
     * channel缓存
     */
    //系统里注册的支付渠道
    public static final String CHANNEL_VALID_CHANNELS=PayCacheNS.CHANNEL+"validChannels";
    //产品开通的渠道
    public static final String CHANNEL_PROD_OPEN=PayCacheNS.CHANNEL+"prodChannels";
    //渠道开通的银行
    public static final String CHANNEL_BANK_OPEN=PayCacheNS.CHANNEL+"openBanks";
    //渠道权重
    public static final String CHANNEL_BANK_OPEN_WEIGHT=PayCacheNS.CHANNEL+"weight";
    
    /**
     * 商户缓存
     */
    //系统里注册的商户
    public static final String MCH_VALIDMCHS = PayCacheNS.MCH+"validMchs";
    //系统商户产品开通能力
    public static final String MCH_PROD = PayCacheNS.MCH+"mchProd";
    
    /**
     * 交易缓存
     */
    //协议代扣缓存
    public static final String TXN_CDK = PayCacheNS.TXN+"cdk";
    
    
    /**
     * 字典
     */
    public static final String DICT = PayCacheNS.DICT+"map";
    
    

    
    
    
}
