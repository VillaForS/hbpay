package com.hbfintech.pay.trade.checker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.hbfintech.pay.intf.enumm.RespCodeEnum;
import com.hbfintech.pay.trade.domain.prod.ProductBo;

@Component
@Order(2)
public class ProdBankChecker implements ComnChecker
{

    @Autowired
    ProductBo  productBo;

    @Override
    public CheckResult check(CheckContext checkContext)
    {
        String bankCode = (String)checkContext.get("bankCode");
        String prodCode = (String)checkContext.get("bankCode");
        if(!productBo.isProdBankOpen(prodCode, bankCode)) {
            return new CheckResult(false, RespCodeEnum.BIZ_PROD_NOTOPEN);
        }
        return new CheckResult(true,null) ;
    }

    @Override
    public Boolean support(CheckContext checkContext)
    {
        return checkContext.containsKey("bankCode")&&checkContext.containsKey("prodCode");
    }
}
