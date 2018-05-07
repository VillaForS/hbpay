package com.hbfintech.pay.common.exception;


/**
 * 签名异常类
 * <功能详细描述>
 *
 * @author kaylves
 * @since 1.0
 */
public class SignatureException extends BaseException
{
    /**
     * serialVersionUID:(用一句话描述这个变量表示什么).
     */
    private static final long serialVersionUID = 1L;

    public SignatureException()
    {
        super("数字签名失败");
    }

    public SignatureException(String message)
    {
        super(message);
    }


}
