package com.hbfintech.pay.trade.domain.merchant.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hbfintech.pay.trade.dict.PayCacheKeys;
import com.hbfintech.pay.trade.repository.dao.PayMerchantDao;
import com.hbfintech.pay.trade.repository.entity.PayMerchant;
import com.hbfintech.redis.utils.RedisCacheUtil;
import com.hbfintech.redis.utils.SyncCacheWorker;

@Component 
public class MchCacheWorker extends SyncCacheWorker<PayMerchant,String>{
    
    @Autowired
    RedisCacheUtil  redisCacheUtil;
    
    @Autowired
    PayMerchantDao payMerchantDao; 
    
    protected PayMerchant read(String mchCode) {
        return redisCacheUtil.hgetBin(PayCacheKeys.MCH_VALIDMCHS, mchCode, PayMerchant.class);
    }
    
    protected PayMerchant write(String mchCode) { 
        PayMerchant prod = payMerchantDao.getMchByCode(mchCode);
         if(null!=prod) {
             redisCacheUtil.hsetBin(PayCacheKeys.MCH_VALIDMCHS, mchCode, mchCode);
         }
         return prod;
    }
    
    @Override
    protected void clearCache()
    {
        redisCacheUtil.del(PayCacheKeys.MCH_VALIDMCHS);
    }
}
