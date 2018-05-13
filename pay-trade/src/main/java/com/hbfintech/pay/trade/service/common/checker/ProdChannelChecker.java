package com.hbfintech.pay.trade.service.common.checker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.hbfintech.pay.common.enumm.RespCodeEnum;
import com.hbfintech.pay.trade.domain.channel.PayChannelBo;
import com.hbfintech.pay.trade.kernal.checker.CheckContext;
import com.hbfintech.pay.trade.kernal.checker.CheckResult;

@Component
@Order(5)
public class ProdChannelChecker implements ComnChecker
{

    @Autowired
    PayChannelBo payChannelBo;
    
    @Override
    public CheckResult check(CheckContext checkContext)
    {
        String prodCode = (String)checkContext.get("prodCode");
        if(CollectionUtils.isEmpty(payChannelBo.getChannelsByProdCode(prodCode))) {
            return new CheckResult(false,RespCodeEnum.BIZ_CHANNEL_NOTOPEN);
        }
        return new CheckResult(true,null);
    }

    @Override
    public Boolean support(CheckContext checkContext)
    {
        return checkContext.containsKey("prodCode");
    }

}
