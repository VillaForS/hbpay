package com.hbfintech.pay.trade.repository.dao;

import com.hbfintech.pay.trade.repository.entity.PayMerchant;

public interface PayMerchantDao {
    int deleteByPrimaryKey(Long mchId);

    int insert(PayMerchant record);

    int insertSelective(PayMerchant record);

    PayMerchant selectByPrimaryKey(Long mchId);

    int updateByPrimaryKeySelective(PayMerchant record);

    int updateByPrimaryKey(PayMerchant record);
    
    PayMerchant getMchByCode(String prodCode);
}