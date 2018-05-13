package com.hbfintech.pay.common.exception;

import com.hbfintech.pay.intf.enumm.RespCodeEnum;

public abstract class BizException extends RuntimeException
{
    private static final long serialVersionUID = 2895464961740660192L;
    
    RespCodeEnum respCodeEnum;
    

    public BizException(String message)
    {
        super(message);
    }

    public BizException(String message,RespCodeEnum respCodeEnum)
    {
    	super(message);
    	this.respCodeEnum = respCodeEnum;
    }


	public RespCodeEnum getRespCodeEnum() {
		return respCodeEnum;
	}

	public void setRespCodeEnum(RespCodeEnum respCodeEnum) {
		this.respCodeEnum = respCodeEnum;
	}

}
