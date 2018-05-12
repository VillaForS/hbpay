package com.hbfintech.pay.trade.service.checker.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.hbfintech.pay.common.enumm.RespCodeEnum;
import com.hbfintech.pay.trade.domain.prod.ProductBo;

@Component
@Order(1)
public class ProdChecker implements Checker
{

    @Autowired
    ProductBo  productBo;

    @Override
    public CheckResult check(CheckContext checkContext)
    {
        String prodCode = (String)checkContext.get("prodCode");
        if(!productBo.isProdOpen(prodCode)) {
            return new CheckResult(false, RespCodeEnum.BIZ_PROD_NOTOPEN);
        }
        return new CheckResult(true,null);
    }

    @Override
    public Boolean support(CheckContext checkContext)
    {
        return checkContext.containsKey("prodCode");
    }
}