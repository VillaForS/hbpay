package com.hbfintech.pay.intf.dto.adapter;

import com.hbfintech.pay.intf.dto.trade.ResponseDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class AdptCwhSignRespDto extends ResponseDto
{
    //支付中心标准返回码
    private String respCode;
    //支付中心标准返回描述
    private String respMsg;
    //渠道支付错误码
    private String channelRespCode;
    //渠道支付错误描述
    private String channelRespMsg;
}