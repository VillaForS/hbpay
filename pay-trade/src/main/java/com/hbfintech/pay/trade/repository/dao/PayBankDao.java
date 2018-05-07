package com.hbfintech.pay.trade.repository.dao;

import com.hbfintech.pay.trade.repository.po.PayBank;

public interface PayBankDao {
    int deleteByPrimaryKey(Long bankId);

    int insert(PayBank record);

    int insertSelective(PayBank record);

    PayBank selectByPrimaryKey(Long bankId);

    int updateByPrimaryKeySelective(PayBank record);

    int updateByPrimaryKey(PayBank record);
}