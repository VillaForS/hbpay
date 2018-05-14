package com.hbfintech.pay.trade.domain.channel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hbfintech.pay.trade.dict.PayConstants;
import com.hbfintech.pay.trade.domain.channel.cache.ChannelWorker;
import com.hbfintech.pay.trade.repository.entity.PayChannel;

@Component
public class PayChannelBo 
{

    @Autowired
    ChannelWorker payChannelCacheWorker ;
    
    
    public Boolean isChannelOpen(String channelCode)
    {
        PayChannel channel = payChannelCacheWorker.find(channelCode);
        if(null!=channel&&PayConstants.OPEN ==channel.getStatus()) {
            return true;
        }
        return false;
    }
    
}
