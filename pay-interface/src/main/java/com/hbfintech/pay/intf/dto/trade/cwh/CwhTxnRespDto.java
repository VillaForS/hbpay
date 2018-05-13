package com.hbfintech.pay.intf.dto.trade.cwh;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class CwhTxnRespDto {
	 //渠道编号
    private String channelCode;
    //支付中心标准返回码
    private String respCode;
    //支付中心标准返回描述
    private String respMsg;
    //渠道支付错误码
    private String channelRespCode;
    //渠道支付错误描述
    private String channelRespMsg;
}
