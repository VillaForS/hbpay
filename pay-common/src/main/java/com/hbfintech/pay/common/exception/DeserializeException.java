package com.hbfintech.pay.common.exception;



/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author Scott
 * @since 1.0
 */
public class DeserializeException extends BaseException
{

    public DeserializeException()
    {
        super("解析报文错误");
    }

    /**
     * serialVersionUID:(用一句话描述这个变量表示什么).
     */
    private static final long serialVersionUID = 106976149158029417L;

    public DeserializeException(String msg)
    {
        super(msg);
    }
}
