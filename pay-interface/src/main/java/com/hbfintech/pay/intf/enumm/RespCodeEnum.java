package com.hbfintech.pay.intf.enumm;

public enum RespCodeEnum {

    // 0000: 成功
    SUCCESS("000000", ""),

    // 失败(00开始标示通讯层相关错误码)
    REMOTE_UNUSABLE("CONN_0001", "服务不可用"),
    REMOTE_INVALID("CONN_0002", "客户端非法调用"),
    REMOTE_CHECK_SIGN_FAIL("CONN_0003", "签名验证失败"),


    // 失败(01开始标示参数校验相关错误码)
    PARAM_WRONG("PAM_0001", "参数有误"),
   

    // 业务相关
    BIZ_MCH_NOTOPEN("BIZ_0001", "商户未开通"),
    BIZ_MCHPROD_NOTOPEN("BIZ_0002", "商户未开通此支付产品"),
    BIZ_PROD_NOTOPEN("BIZ_0003","该支付产品未开通"),
    BIZ_CHANNEL_NOTOPEN("BIZ_0004","该支付产品未开通支付渠道"),
    BIZ_BANK_NOTOPEN("BIZ_0004","该银行未开通"),
    BIZ_CHANNEL_NOAVAL("BIZ_0005","没有可用的渠道"),
    

    // 未知错误
    SYSTEM_ERROR("SYS_9999", "系统异常");

    private String code;
    private String msg;

    private RespCodeEnum(String code, String message) { this.code = code;
        this.msg = message; }

    public String getCode()
    {
        return this.code;
    }

    public String getMessage() {
        return this.msg;
    }

    public static RespCodeEnum getRetEnum(String code) {
        if (code == null) {
            return null;
        }

        RespCodeEnum[] values = RespCodeEnum.values();
        for (RespCodeEnum e : values) {
            if (e.getCode().equals(code)) {
                return e;
            }
        }
        return null;
    }
    
    public Boolean equals(String code) {
        return this.getCode().equals(code);
    }
}
