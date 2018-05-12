package com.hbfintech.pay.trade.service.checker.base;

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
}
