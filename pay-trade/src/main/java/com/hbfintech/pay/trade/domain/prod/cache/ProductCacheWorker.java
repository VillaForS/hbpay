package com.hbfintech.pay.trade.domain.prod.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hbfintech.pay.trade.dict.PayCacheKeys;
import com.hbfintech.pay.trade.repository.dao.PayProductDao;
import com.hbfintech.pay.trade.repository.po.PayProduct;
import com.hbfintech.redis.utils.RedisCacheUtil;
import com.hbfintech.redis.utils.SyncCacheWorker;

@Component 
public class ProductCacheWorker extends SyncCacheWorker<PayProduct,String>{
    
    @Autowired
    RedisCacheUtil  redisCacheUtil;
    
    @Autowired
    PayProductDao payProductDao; 
    
    protected PayProduct read(String prodCode) {
        return redisCacheUtil.hgetBin(PayCacheKeys.PROD_VALID_PRODS, prodCode, PayProduct.class);
    }
    
    protected PayProduct write(String prodCode) { 
        PayProduct prod = payProductDao.getProdByCode(prodCode);
         if(null!=prod) {
             redisCacheUtil.hsetBin(PayCacheKeys.PROD_VALID_PRODS+"validProds", prodCode, prodCode);
         }
         return prod;
    }
}
