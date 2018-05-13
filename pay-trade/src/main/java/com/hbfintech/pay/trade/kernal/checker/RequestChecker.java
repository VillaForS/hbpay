package com.hbfintech.pay.trade.kernal.checker;

import com.hbfintech.pay.intf.dto.RequestDto;

public interface RequestChecker
{
      public CheckResult checkRequest(RequestDto requestDto);
}
