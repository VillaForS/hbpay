package com.hbfintech.pay.trade.domain.bank.cache;

import java.util.List;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.hbfintech.pay.trade.dict.PayCacheKeys;
import com.hbfintech.pay.trade.repository.dao.PayChannelBankDao;
import com.hbfintech.pay.trade.repository.entity.PayChannelBank;
import com.hbfintech.redis.utils.RedisCacheUtil;
import com.hbfintech.redis.utils.SyncCacheWorker;

@Component
public class BankOpenChannelsWeightWorker extends SyncCacheWorker<List<String>,String>{
    
    @Autowired
    RedisCacheUtil  redisCacheUtil;
    
    @Autowired
    PayChannelBankDao payChannelBankDao; 
    
    protected List<String> read(String bankCode) {
         String banks=  redisCacheUtil.hgetBin(PayCacheKeys.CHANNEL_BANK_OPEN, bankCode, String.class);
         return  JSON.parseArray(banks, String.class);
    }
    
    protected List<String> write(String bankCode) { 
        
         List<PayChannelBank> banks = payChannelBankDao.getBankOpenChannels(bankCode);
         //权重缓存
         List<String> weightList = Lists.newArrayList();
         for(PayChannelBank bank : banks) {
             if(bank.getWeight()>0) {
                 for(int i=0; i<bank.getWeight();i++) {
                   weightList.add(bank.getChannelCode());
                 }
             }
         }
         redisCacheUtil.hsetBin(PayCacheKeys.CHANNEL_BANK_OPEN_WEIGHT, bankCode, weightList);
         return weightList;
    }

    @Override
    protected void clearCache()
    {
        redisCacheUtil.del(PayCacheKeys.CHANNEL_BANK_OPEN_WEIGHT);
    }

}
