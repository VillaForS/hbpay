package com.hbfintech.pay.common.enumm;

public enum RespCodeEnum {

    // 0000: 成功
    SUCCESS("000000", ""),

    // 失败(00开始标示通讯层相关错误码)
    REMOTE_UNUSABLE("CONN_0001", "服务不可用"),
    REMOTE_INVALID("CONN_0002", "客户端非法调用"),
    REMOTE_CHECK_SIGN_FAIL("CONN_0003", "签名验证失败"),


    // 失败(01开始标示参数校验相关错误码)
    PARAM_NOT_FOUND("PAM_0101", "参数非法"),


    // 业务相关
    BIZ_WX_PAY_CREATE_FAIL("1003", "微信支付下单失败"),


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
}
