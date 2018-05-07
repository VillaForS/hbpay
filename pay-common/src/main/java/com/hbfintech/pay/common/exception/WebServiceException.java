package com.hbfintech.pay.common.exception;


/**
 * 
 * 用于和外部系统对接时封装产生的异常 <功能详细描述>
 *
 * @author Scott
 * @since 1.0
 */
public class WebServiceException extends BaseException
{
    private static final long serialVersionUID = 8777418975536985661L;

    public WebServiceException(String message)
    {
        super(message);
    }
}
