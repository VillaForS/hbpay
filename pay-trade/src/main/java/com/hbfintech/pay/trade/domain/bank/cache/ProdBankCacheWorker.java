package com.hbfintech.pay.trade.domain.bank.cache;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hbfintech.pay.trade.dict.PayCacheKeys;
import com.hbfintech.pay.trade.repository.dao.PayBankProductDao;
import com.hbfintech.pay.trade.repository.po.PayBankProduct;
import com.hbfintech.redis.utils.RedisCacheUtil;
import com.hbfintech.redis.utils.SyncCacheWorker;

@Component
public class ProdBankCacheWorker extends SyncCacheWorker<PayBankProduct,Map<String,String>>{
    
    @Autowired
    RedisCacheUtil  redisCacheUtil;
    
    @Autowired  
    PayBankProductDao payBankProductDao; 
    
    protected PayBankProduct read(Map<String,String> map) {
        return redisCacheUtil.hgetBin(PayCacheKeys.BANK_PROD_OPEN, map.get("prodCode")+map.get("bankCode"), PayBankProduct.class);
    }
    
    protected PayBankProduct write(Map<String,String> map) { 
         PayBankProduct bank = payBankProductDao.getByProdAndBankCode(map.get("prodCode"),map.get("bankCode"));
         redisCacheUtil.hsetBin(PayCacheKeys.BANK_PROD_OPEN, map.get("prodCode")+map.get("bankCode"), bank);
         return bank;
    }

}
