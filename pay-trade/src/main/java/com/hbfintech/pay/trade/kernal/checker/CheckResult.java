package com.hbfintech.pay.trade.kernal.checker;


import com.hbfintech.pay.intf.enumm.RespCodeEnum;

import lombok.Data;

@Data
public class CheckResult
{
      private Boolean passCheck;
      
      private RespCodeEnum respEnum;
      
      public CheckResult(Boolean passCheck, RespCodeEnum respCode) {
          this.passCheck = passCheck;
          this.respEnum = respCode;
      }
      
      public Boolean isPass(){
    	  return passCheck;
      }
}
