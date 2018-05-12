package com.hbfintech.pay.trade.domain.prod;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hbfintech.pay.trade.dict.PayConstants;
import com.hbfintech.pay.trade.domain.prod.cache.ProductCacheWorker;
import com.hbfintech.pay.trade.repository.po.PayChannel;
import com.hbfintech.pay.trade.repository.po.PayProduct;

public class ProductBo
{
    
    @Autowired
    ProductCacheWorker  productCacheWorker;

    public Boolean isProdOpen(String prodCode)
    {
        PayProduct payProduct = productCacheWorker.find(prodCode);
        if(null!=payProduct&&payProduct.getStatus()==PayConstants.OPEN) {
            return true;
        }
        return false;
    }
    


}
