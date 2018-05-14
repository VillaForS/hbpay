package com.hbfintech.pay.trade.domain.dict.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hbfintech.pay.trade.dict.PayCacheKeys;
import com.hbfintech.pay.trade.repository.dao.PayDictDao;
import com.hbfintech.redis.utils.RedisCacheUtil;
import com.hbfintech.redis.utils.SyncCacheWorker;

/**
 * 
 * 字典缓存
 * <功能详细描述>
 *
 * @author zhush
 * @since 1.0
 */
@Component
public class DictCacheWorker extends SyncCacheWorker<String,String>{
    
    @Autowired
    RedisCacheUtil  redisCacheUtil;
    
    @Autowired
    PayDictDao payDictDao; 
    
    protected String read(String key) {
        return  redisCacheUtil.hgetBin(PayCacheKeys.DICT, key, String.class);
    }
    
    protected String write(String key) { 
         String value = payDictDao.getValueByKey(key);
         if(null==value) {
             value="";
         }
         redisCacheUtil.hsetBin(PayCacheKeys.DICT, key, value);
         return value;
    }

    @Override
    protected void clearCache()
    {
        redisCacheUtil.del(PayCacheKeys.DICT);
    }
}
