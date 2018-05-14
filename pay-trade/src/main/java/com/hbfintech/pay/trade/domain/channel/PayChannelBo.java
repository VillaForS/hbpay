package com.hbfintech.pay.trade.domain.channel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbfintech.pay.trade.dict.PayConstants;
import com.hbfintech.pay.trade.domain.bank.cache.BankOpenChannelsWorker;
import com.hbfintech.pay.trade.domain.channel.cache.ChannelWorker;
import com.hbfintech.pay.trade.domain.prod.cache.ProdOpenChannelsWorker;
import com.hbfintech.pay.trade.repository.entity.PayChannel;
import com.hbfintech.pay.trade.repository.entity.PayChannelBank;

@Service
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
