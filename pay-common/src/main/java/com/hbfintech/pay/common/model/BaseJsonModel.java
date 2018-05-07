package com.hbfintech.pay.common.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseJsonModel extends ResponseModel {
    private boolean isJsonp;
    
    private Integer code;

    private String msg;
    
	public final static int SUCCESS_CODE = 0;
	public final static int ERROR_CODE = 1;
}
