package com.hbfintech.pay.intf.dto.trade;


import com.hbfintech.pay.intf.enumm.RespCodeEnum;

import lombok.Data;

@Data
public class ResponseDto {

    protected String code;
    protected String msg;
    
    public void setResp(RespCodeEnum respEnum) {
        this.code=respEnum.getCode();
        this.msg=respEnum.getMessage();
    }
    public ResponseDto(){
    	
    }
    public  ResponseDto(RespCodeEnum respEnum) {
        this.code=respEnum.getCode();
        this.msg=respEnum.getMessage();
    }
}
