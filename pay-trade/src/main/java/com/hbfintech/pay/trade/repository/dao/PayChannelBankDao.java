package com.hbfintech.pay.trade.repository.dao;

import java.util.List;

import com.hbfintech.pay.trade.repository.po.PayChannelBank;

public interface PayChannelBankDao {
    int deleteByPrimaryKey(Long channelBankId);

    int insert(PayChannelBank record);

    int insertSelective(PayChannelBank record);

    PayChannelBank selectByPrimaryKey(Long channelBankId);

    int updateByPrimaryKeySelective(PayChannelBank record);

    int updateByPrimaryKey(PayChannelBank record);
    
    List<PayChannelBank> getChannelOpenBanks(String channelCode);
}