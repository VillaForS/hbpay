package com.hbfintech.pay.common.dto;


import com.hbfintech.pay.common.enumm.RespCodeEnum;

import lombok.Data;

@Data
public class ResponseDto {

    private String code;
    private String msg;
    private Object data;
    
    public void setResp(RespCodeEnum respEnum) {
        this.code=respEnum.getCode();
        this.msg=respEnum.getMessage();
    }
    
    
}
