package com.hbfintech.pay.trade.domain.prod;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Maps;
import com.hbfintech.pay.trade.dict.PayConstants;
import com.hbfintech.pay.trade.domain.prod.cache.ProdBankCacheWorker;
import com.hbfintech.pay.trade.domain.prod.cache.ProdOpenChannelsWorker;
import com.hbfintech.pay.trade.domain.prod.cache.ProductCacheWorker;
import com.hbfintech.pay.trade.repository.entity.PayBankProduct;
import com.hbfintech.pay.trade.repository.entity.PayChannel;
import com.hbfintech.pay.trade.repository.entity.PayProduct;

public class ProductBo
{
    
    @Autowired
    ProductCacheWorker  productCacheWorker;
    
    @Autowired
    ProdOpenChannelsWorker prodOpenChannelsWorker;
    
    @Autowired
    ProdBankCacheWorker  prodBankCacheWorker;

    public Boolean isProdOpen(String prodCode)
    {
        PayProduct payProduct = productCacheWorker.find(prodCode);
        if(null!=payProduct&&payProduct.getStatus()==PayConstants.OPEN) {
            return true;
        }
        return false;
    }
    
    public Boolean isProdBankOpen(String prodCode ,String bankCode)
    {
        HashMap<String,String> map = Maps.newHashMap();
        map.put("prodCode", prodCode);
        map.put("bankCode", bankCode);
        PayBankProduct payBankProduct = prodBankCacheWorker.find(map);
        if(null!=payBankProduct&&PayConstants.OPEN==payBankProduct.getStatus()) {
           return true;
        }
        return false;
    }
    
    public List<PayChannel> getProdOpenChannels(String prodCode){
        List<PayChannel> list = prodOpenChannelsWorker.find(prodCode);
        return list;
    }


}
