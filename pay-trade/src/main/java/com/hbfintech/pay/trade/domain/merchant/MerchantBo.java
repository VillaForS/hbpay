package com.hbfintech.pay.trade.domain.merchant;

import org.springframework.beans.factory.annotation.Autowired;

import com.hbfintech.pay.trade.dict.PayConstants;
import com.hbfintech.pay.trade.repository.po.PayMerchant;

public class MerchantBo
{
    
    @Autowired
    MchCacheWorker  productCacheWorker;

    public Boolean isMchOpen(String mchCode)
    {
        PayMerchant payMerchant = productCacheWorker.find(mchCode);
        if(null!=payMerchant&&payMerchant.getStatus()==PayConstants.OPEN) {
            return true;
        }
        return false;
    }

    
}
