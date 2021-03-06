package com.hbfintech.pay.trade.repository.dao;

import java.util.List;

import com.hbfintech.pay.trade.repository.entity.PayChannel;
import com.hbfintech.pay.trade.repository.entity.PayChannelBank;

public interface PayChannelBankDao {
    int deleteByPrimaryKey(Long channelBankId);

    int insert(PayChannelBank record);

    int insertSelective(PayChannelBank record);

    PayChannelBank selectByPrimaryKey(Long channelBankId);

    int updateByPrimaryKeySelective(PayChannelBank record);

    int updateByPrimaryKey(PayChannelBank record);
    
    List<PayChannelBank> getBankOpenChannels(String channelCode);

}