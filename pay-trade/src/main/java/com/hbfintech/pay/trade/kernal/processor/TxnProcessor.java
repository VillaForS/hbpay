package com.hbfintech.pay.trade.kernal.processor;

import com.hbfintech.pay.common.dto.RequestDto;
import com.hbfintech.pay.common.dto.ResponseDto;

public interface TxnProcessor
{
       public ResponseDto preProcess(RequestDto requestDto);
       
       public ResponseDto process(RequestDto requestDto);
       
       public ResponseDto postProcess(RequestDto requestDto ,ResponseDto responseDto);
}
