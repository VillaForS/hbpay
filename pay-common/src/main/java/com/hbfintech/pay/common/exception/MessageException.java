package com.hbfintech.pay.common.exception;


/**
 * 消息发送异常
 * <功能详细描述>
 *
 * @author kaylves
 * @since 1.0
 */
public class MessageException extends BaseException
{

    /**
     * serialVersionUID:(用一句话描述这个变量表示什么).
     */
    private static final long serialVersionUID = 2717266550505018826L;

    public MessageException()
    {
        this("消息网关异常");
    }


    public MessageException(String message)
    {
        super(message);
    }

}
