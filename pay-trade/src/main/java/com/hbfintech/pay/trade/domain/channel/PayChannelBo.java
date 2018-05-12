package com.hbfintech.pay.trade.domain.channel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbfintech.pay.trade.dict.PayConstants;
import com.hbfintech.pay.trade.domain.channel.cache.ChannelWorker;
import com.hbfintech.pay.trade.domain.channel.cache.ProdOpenChannelsWorker;
import com.hbfintech.pay.trade.repository.po.PayChannel;

@Service
public class PayChannelBo 
{

    @Autowired
    ChannelWorker payChannelCacheWorker ;
    
    @Autowired
    ProdOpenChannelsWorker payProdChannelCacheWorker;
    
    public Boolean isChannelOpen(String bankCode)
    {
        PayChannel channel = payChannelCacheWorker.find(bankCode);
        if(null!=channel&&PayConstants.OPEN ==channel.getStatus()) {
            return true;
        }
        return false;
    }
    
    public List<PayChannel> getChannelsByProdCode(String prodCode){
        List<PayChannel> list = payProdChannelCacheWorker.find(prodCode);
        return list;
    }

}
