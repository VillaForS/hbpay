package com.hbfintech.pay.trade.service.common.checker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.hbfintech.pay.intf.enumm.RespCodeEnum;
import com.hbfintech.pay.trade.domain.merchant.MerchantBo;
import com.hbfintech.pay.trade.kernal.checker.CheckContext;
import com.hbfintech.pay.trade.kernal.checker.CheckResult;

/**
 * 
 * 商户产品开通检查
 *
 * @author zhush
 * @since 1.0
 */
@Component
@Order(4)
public class MerchantProdChecker implements ComnChecker
{

    @Autowired
    MerchantBo merchantBo;
    
    @Override
    public CheckResult check(CheckContext checkContext)
    {
        
        String mchCode = (String)checkContext.get("mchCode");
        if(!merchantBo.isMchOpen(mchCode)) {
            return new CheckResult(false,RespCodeEnum.BIZ_MCH_NOTOPEN);
        }
        
        String prodCode = (String)checkContext.get("prodCode");
        if(!merchantBo.isMchProdOpen(mchCode, prodCode)) {
            return new CheckResult(false,RespCodeEnum.BIZ_MCHPROD_NOTOPEN);
        }
        return  new CheckResult(true,null);
    }

    @Override
    public Boolean support(CheckContext checkContext)
    {
        return checkContext.containsKey("mchCode")&&checkContext.containsKey("prodCode");
    }

}
