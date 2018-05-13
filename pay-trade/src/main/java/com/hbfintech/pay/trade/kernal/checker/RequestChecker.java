package com.hbfintech.pay.trade.kernal.checker;

import com.hbfintech.pay.common.dto.RequestDto;

public interface RequestChecker
{
      public CheckResult checkRequest(RequestDto requestDto);
}
