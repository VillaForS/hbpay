package com.hbfintech.pay.trade.kernal.service;

import com.hbfintech.pay.common.dto.RequestDto;
import com.hbfintech.pay.common.dto.ResponseDto;
import com.hbfintech.pay.common.enumm.RespCodeEnum;
import com.hbfintech.pay.trade.kernal.processor.TxnProcessor;

/**
 * 抽象的服务流程
 * 采用模板模式
 *
 * @author zhush
 * @since 1.0
 */
public  abstract class AbstractPayService implements PayService
{

     TxnProcessor processor;
     
     public ResponseDto doTxn(RequestDto req) {
         ResponseDto resp = processor.preProcess(req);
         if(RespCodeEnum.SUCCESS.equals(resp.getCode())) {
             resp = processor.process(req);
         }
         return  processor.postProcess(req, resp);
     }
}
