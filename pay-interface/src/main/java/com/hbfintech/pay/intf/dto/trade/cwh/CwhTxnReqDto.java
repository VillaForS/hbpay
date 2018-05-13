package com.hbfintech.pay.intf.dto.trade.cwh;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class CwhTxnReqDto {

	//商户编码
    @NotEmpty
    private String mchCode;
    //商户请求流水号
    @NotEmpty
    private String mchReqNo;
    //商户请求时间
    @NotEmpty
    private Date mchReqTime;
    //交易金额
    private BigDecimal amount;
    //卡号
    private String cardNo;
    // 扩展参数（风控参数、辅助路由参数等）：json 字符串
    private String extraParams;
}
