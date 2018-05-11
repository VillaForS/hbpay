package com.hbfintech.pay.trade.domain.merchant;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Maps;
import com.hbfintech.pay.trade.dict.PayConstants;
import com.hbfintech.pay.trade.domain.merchant.cache.MchCacheWorker;
import com.hbfintech.pay.trade.domain.merchant.cache.MchProdCacheWorker;
import com.hbfintech.pay.trade.repository.po.PayMerchant;
import com.hbfintech.pay.trade.repository.po.PayMerchantProduct;

public class MerchantBo
{
    
    @Autowired
    MchCacheWorker  productCacheWorker;
    
    @Autowired
    MchProdCacheWorker mchProdCacheWorker;

    public Boolean isMchOpen(String mchCode)
    {
        PayMerchant payMerchant = productCacheWorker.find(mchCode);
        if(null!=payMerchant&&payMerchant.getStatus()==PayConstants.OPEN) {
            return true;
        }
        return false;
    }
    
    public Boolean isMchProdOpen(String mchCode,String prodCode) {
        Map<String,String> map = Maps.newHashMap();
        map.put("mchCode", mchCode);
        map.put("prodCode", prodCode);
        PayMerchantProduct payMerchantProduct = mchProdCacheWorker.find(map);
        if(null!=payMerchantProduct&&payMerchantProduct.getStatus()==PayConstants.OPEN) {
            return true;
        }
        return false;
    }
    
}
