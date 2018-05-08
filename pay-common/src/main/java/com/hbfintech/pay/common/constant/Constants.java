package com.hbfintech.pay.common.constant;

/**
 * Created by zhushuang on 2018/4/30.
 */
public class Constants {

    // 随机通讯码不重复的时间间隔(ms)
    public static final long RPC_SEQ_NO_NOT_REPEAT_INTERVAL = 5 * 1000;
    
    // 服务端返回map中业务数据结果对应的key名称
    public static final String BIZ_RESULT_KEY = "bizResult";
    
    //一天
    public static final long DAY_MILL_SECONDS = 24 * 60 * 60 * 1000L;
    
    //money格式
    public static final String MONEY_FORMART = "##,##0.00";

    public static final int NUM_1 = 1;

    public static final int NUM_2 = 2;

    public static final int NUM_3 = 3;

    public static final int NUM_4 = 4;

    public static final int NUM_5 = 5;

    public static final int NUM_8 = 8;

    public static final int NUM_9 = 9;

    public static final int NUM_10 = 10;
}
