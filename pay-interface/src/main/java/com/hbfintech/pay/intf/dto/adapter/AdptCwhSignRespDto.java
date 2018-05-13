package com.hbfintech.pay.intf.dto.adapter;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import com.hbfintech.pay.intf.dto.trade.ResponseDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class AdptCwhSignRespDto extends ResponseDto
{
    //商户编码
    @NotEmpty
    private String mchCode;
    //商户请求流水号
    @NotEmpty
    private String mchReqNo;
    //商户请求时间
    @NotEmpty
    private Date mchReqTime;
    //签约卡号
    @NotEmpty
    private String cardNo;
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
    //支付中心标准返回码
    private String respCode;
    //支付中心标准返回描述
    private String respMsg;
    //渠道支付错误码
    private String channelRespCode;
    //渠道支付错误描述
    private String channelRespMsg;
}