package com.hbfintech.pay.trade.repository.dao;

import java.util.List;

import com.hbfintech.pay.trade.repository.entity.PayChannel;

public interface PayChannelDao {
    int deleteByPrimaryKey(Long channelId);

    int insert(PayChannel record);

    int insertSelective(PayChannel record);

    PayChannel selectByPrimaryKey(Long channelId);

    int updateByPrimaryKeySelective(PayChannel record);

    int updateByPrimaryKey(PayChannel record);
    
    PayChannel getChannelByCode(String channelCode);
    
    List<PayChannel> getProdOpenChannels(String prodCode);
}