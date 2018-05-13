package com.hbfintech.pay.trade.domain.merchant.cache;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hbfintech.pay.trade.dict.PayCacheKeys;
import com.hbfintech.pay.trade.repository.dao.PayMerchantProductDao;
import com.hbfintech.pay.trade.repository.entity.PayMerchantProduct;
import com.hbfintech.redis.utils.RedisCacheUtil;
import com.hbfintech.redis.utils.SyncCacheWorker;

/**
 * 
 * 商户产品Worker
 * <功能详细描述>
 *
 * @author zhush
 * @since 1.0
 */
@Component 
public class MchProdCacheWorker extends SyncCacheWorker<PayMerchantProduct,Map<String,String>>{
    
    @Autowired
    RedisCacheUtil  redisCacheUtil;
    
    @Autowired
    PayMerchantProductDao payMerchantProductDao; 
    
    protected PayMerchantProduct read(Map<String,String> map) {
        return redisCacheUtil.hgetBin(PayCacheKeys.MCH_PROD, map.get("mchCode")+map.get("prodCode"), PayMerchantProduct.class);
    }
    
    protected PayMerchantProduct write(Map<String,String> map) { 
        PayMerchantProduct mchProd = payMerchantProductDao.getMchProd(map.get("mchCode"), map.get("prodCode"));
         if(null!=mchProd) {
             redisCacheUtil.hsetBin(PayCacheKeys.MCH_PROD, map.get("mchCode")+map.get("prodCode"), mchProd);
         }
         return mchProd;
    }
}
