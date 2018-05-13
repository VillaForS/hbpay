package com.hbfintech.pay.intf.dto.adapter;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import com.hbfintech.pay.intf.dto.trade.RequestDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class AdptCwhSignReqDto extends RequestDto
{
    //签约卡号
    @NotEmpty
    private String cardNo;
    //银行编码
    @NotEmpty
    private String bankCode;
    //卡类型
    private String cardType;
    //银行预留手机号
    @NotEmpty
    private String mobile;
    //证件名称
    @NotEmpty
    private String certName;
    //证件号码
    @NotEmpty
    private String certNo;
    //证件类型
    private Byte certType;
    //渠道编号
    private String channelCode;
    //渠道编号
    private String channelReqNo;
}
