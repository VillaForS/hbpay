package com.hbfintech.pay.trade.dict;

public class PayConstants
{
    
    //关闭
    public static final int CLOSED =0;
    //开通
    public static final int OPEN = 1;
    //身份证
    public static final Byte CERT_TYPE_ID = 1;
    //借记卡
    public static final String CARD_TYPE_DEBIT = "D";
    //签约状态码
    public static final Byte SIGN_CREATED = 0;
    public static final Byte SIGN_WAIT_CONFIRM = 10;
    public static final Byte SIGN_PROCESSING = 20;
    public static final Byte SIGN_SUCCESS = 30;
    public static final Byte SIGN_FAIL = 40;
}
