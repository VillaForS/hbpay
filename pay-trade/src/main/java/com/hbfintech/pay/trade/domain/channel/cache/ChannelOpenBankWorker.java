package com.hbfintech.pay.trade.domain.channel.cache;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.hbfintech.pay.trade.dict.PayCacheKeys;
import com.hbfintech.pay.trade.repository.dao.PayChannelBankDao;
import com.hbfintech.pay.trade.repository.entity.PayChannelBank;
import com.hbfintech.redis.utils.RedisCacheUtil;
import com.hbfintech.redis.utils.SyncCacheWorker;

@Component
public class ChannelOpenBankWorker extends SyncCacheWorker<List<PayChannelBank>,String>{
    
    @Autowired
    RedisCacheUtil  redisCacheUtil;
    
    @Autowired
    PayChannelBankDao payChannelBankDao; 
    
    protected List<PayChannelBank> read(String channelCode) {
         String banks=  redisCacheUtil.hgetBin(PayCacheKeys.CHANNEL_BANK_OPEN, channelCode, String.class);
         return  JSON.parseArray(banks, PayChannelBank.class);
    }
    
    protected List<PayChannelBank> write(String channelCode) { 
        
         List<PayChannelBank> banks = payChannelBankDao.getChannelOpenBanks(channelCode);
         redisCacheUtil.hsetBin(PayCacheKeys.CHANNEL_BANK_OPEN, channelCode, banks);
         return banks;
    }

}
