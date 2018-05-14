package com.hbfintech.pay.trade.domain.prod.cache;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.hbfintech.pay.trade.dict.PayCacheKeys;
import com.hbfintech.pay.trade.repository.dao.PayChannelDao;
import com.hbfintech.pay.trade.repository.entity.PayChannel;
import com.hbfintech.redis.utils.RedisCacheUtil;
import com.hbfintech.redis.utils.SyncCacheWorker;

@Component
public class ProdOpenChannelsWorker extends SyncCacheWorker<List<PayChannel>,String>{
    
    @Autowired
    RedisCacheUtil  redisCacheUtil;
    
    @Autowired
    PayChannelDao payChannelDao; 
    
    protected List<PayChannel> read(String prodCode) {
         String channels= redisCacheUtil.hgetBin(PayCacheKeys.CHANNEL_VALID_CHANNELS, prodCode, String.class);
         return JSON.parseArray(channels, PayChannel.class);
    }
    
    protected List<PayChannel> write(String prodCode) { 
        
         List<PayChannel> channels = payChannelDao.getProdOpenChannels(prodCode);
         redisCacheUtil.hsetBin(PayCacheKeys.CHANNEL_VALID_CHANNELS, prodCode, JSON.toJSONString(channels));
         return channels;
    }

}
