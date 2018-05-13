package com.hbfintech.pay.trade.kernal.checker;

import com.hbfintech.pay.common.enumm.RespCodeEnum;

import lombok.Data;

@Data
public class CheckResult
{
      private Boolean passCheck;
      
      private RespCodeEnum respCode;
      
      public CheckResult(Boolean passCheck, RespCodeEnum respCode) {
          this.passCheck = passCheck;
          this.respCode = respCode;
      }
      
      public Boolean isPass(){
    	  return passCheck;
      }
}
