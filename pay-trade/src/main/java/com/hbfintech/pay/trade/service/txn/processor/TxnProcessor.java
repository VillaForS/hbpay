package com.hbfintech.pay.trade.service.txn.processor;

import com.hbfintech.pay.common.dto.RequestDto;
import com.hbfintech.pay.common.dto.ResponseDto;

public interface TxnProcessor
{
       public ResponseDto preProcess(RequestDto t);
       
       public ResponseDto process(RequestDto t);
       
       public ResponseDto postProcess(RequestDto t ,ResponseDto v);
}
