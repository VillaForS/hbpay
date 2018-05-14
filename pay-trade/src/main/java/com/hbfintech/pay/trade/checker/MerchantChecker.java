package com.hbfintech.pay.trade.checker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.hbfintech.pay.intf.enumm.RespCodeEnum;
import com.hbfintech.pay.trade.domain.merchant.MerchantBo;

/**
 * 
 * 商户开通检查
 *
 * @author zhush
 * @since 1.0
 */
@Component
@Order(3)
public class MerchantChecker implements ComnChecker
{

    @Autowired
    MerchantBo merchantBo;
    
    @Override
    public CheckResult check(CheckContext checkContext)
    {
        String mchCode = (String)checkContext.get("mchCode");
        if(!merchantBo.isMchOpen(mchCode)) {
            return  new CheckResult(false,RespCodeEnum.BIZ_MCH_NOTOPEN);
        }
        return new CheckResult(true,null);
    }

    @Override
    public Boolean support(CheckContext checkContext)
    {
        return checkContext.containsKey("mchCode");
    }

}
