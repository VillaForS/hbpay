package com.hbfintech.pay.intf.dto.adapter;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class AdptCwhTxnReqDto {

    //渠道编码
    private String channelCode;
    //交易金额
    private BigDecimal amount;
    //卡号
    private String cardNo;
    //协议号
    private String protocolNo;
    // 扩展参数（风控参数、辅助路由参数等）：json 字符串
    private String extraParams;
    // 渠道请求流水号
    private String channelReqNo;
}
