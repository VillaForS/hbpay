package com.hbfintech.pay.common.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseJsonModel extends ResponseModel {

	private Integer code;

    private String msg;
    
    private Object data;
    
	public final static int SUCCESS_CODE = 0;
	public final static int ERROR_CODE = 1;
}
