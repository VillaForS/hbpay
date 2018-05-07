package com.hbfintech.pay.common.exception;


/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author Scott
 * @since 1.0
 */
public abstract class BaseException extends RuntimeException
{
    private static final long serialVersionUID = 2895464961740660192L;

    public BaseException(String message)
    {
        super(message);
    }

    public BaseException()
    {
    }
}
