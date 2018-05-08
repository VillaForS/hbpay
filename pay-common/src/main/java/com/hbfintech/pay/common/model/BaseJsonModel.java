package com.hbfintech.pay.common.model;

import com.hbfintech.pay.common.enumm.RespCodeEnum;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseJsonModel extends ResponseModel {

	private String code;

    private String msg;
    
    private Object data;
    
    public void setRespInfo(RespCodeEnum info) {
    	this.code= info.getCode();
    	this.msg=info.getMessage();
    }
    
}
