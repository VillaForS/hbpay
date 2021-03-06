package com.hbfintech.pay.trade.domain.channel.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hbfintech.pay.trade.dict.PayCacheKeys;
import com.hbfintech.pay.trade.repository.dao.PayChannelDao;
import com.hbfintech.pay.trade.repository.entity.PayChannel;
import com.hbfintech.redis.utils.RedisCacheUtil;
import com.hbfintech.redis.utils.SyncCacheWorker;

@Component
public class ChannelWorker extends SyncCacheWorker<PayChannel,String>{
    
    @Autowired
    RedisCacheUtil  redisCacheUtil;
    
    @Autowired
    PayChannelDao payChannelDao; 
    
    protected PayChannel read(String channelCode) {
        return  redisCacheUtil.hgetBin(PayCacheKeys.CHANNEL_VALID_CHANNELS, channelCode, PayChannel.class);
    }
    
    protected PayChannel write(String channelCode) { 
        
         PayChannel channel = payChannelDao.getChannelByCode(channelCode);
         if(null!=channel) {
             redisCacheUtil.hsetBin(PayCacheKeys.CHANNEL_VALID_CHANNELS, channelCode, channel);
         }
         return channel;
    }

    @Override
    protected void clearCache()
    {
        redisCacheUtil.del(PayCacheKeys.CHANNEL_VALID_CHANNELS);
    }
}
