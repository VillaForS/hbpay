package com.hbfintech.pay.common.constant;

/**
 * Created by zhushuang on 2018/4/30.
 */
public class Constant {

    // 协议支付流水号前缀
    public static final String TRANS_BIZ_SEQUENCE_NO_PREFIX = "PP";
    
    // 随机通讯码不重复的时间间隔(ms)
    public static final long RPC_SEQ_NO_NOT_REPEAT_INTERVAL = 5 * 1000;
    
    // 服务端返回map中业务数据结果对应的key名称
    public static final String BIZ_RESULT_KEY = "bizResult";

}
