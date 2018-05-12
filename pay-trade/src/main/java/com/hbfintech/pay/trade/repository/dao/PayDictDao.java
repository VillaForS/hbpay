package com.hbfintech.pay.trade.repository.dao;

import com.hbfintech.pay.trade.repository.po.PayDict;

public interface PayDictDao {
    int deleteByPrimaryKey(Long dictId);

    int insert(PayDict record);

    int insertSelective(PayDict record);

    PayDict selectByPrimaryKey(Long dictId);

    int updateByPrimaryKeySelective(PayDict record);

    int updateByPrimaryKey(PayDict record);
    
    String getValueByKey(String key);
}