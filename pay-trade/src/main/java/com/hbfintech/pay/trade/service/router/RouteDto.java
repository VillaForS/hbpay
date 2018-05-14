package com.hbfintech.pay.trade.service.router;

import java.math.BigDecimal;
import java.util.List;

import com.google.common.collect.Lists;
import com.hbfintech.pay.intf.enumm.RespCodeEnum;
import com.hbfintech.pay.trade.repository.entity.PayChannelBank;

import lombok.Data;

@Data
public class RouteDto
{
     private BigDecimal amount; 
     private String prodCode;
     private String bankCode;
     private List<PayChannelBank> waitFilterBanks = Lists.newArrayList();
     private RespCodeEnum resp;
}
