package com.hbfintech.pay.trade.repository.dao;

import com.hbfintech.pay.trade.repository.po.PayChannel;

public interface PayChannelDao {
    int deleteByPrimaryKey(Long channelId);

    int insert(PayChannel record);

    int insertSelective(PayChannel record);

    PayChannel selectByPrimaryKey(Long channelId);

    int updateByPrimaryKeySelective(PayChannel record);

    int updateByPrimaryKey(PayChannel record);
}