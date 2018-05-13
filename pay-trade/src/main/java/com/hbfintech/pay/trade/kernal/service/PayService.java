package com.hbfintech.pay.trade.kernal.service;

import com.hbfintech.pay.common.dto.RequestDto;
import com.hbfintech.pay.common.dto.ResponseDto;

public interface PayService {

	  public ResponseDto doTxn(RequestDto req);
}
