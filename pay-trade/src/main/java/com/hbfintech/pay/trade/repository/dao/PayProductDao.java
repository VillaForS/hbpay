package com.hbfintech.pay.trade.repository.dao;

import com.hbfintech.pay.trade.repository.po.PayProduct;

public interface PayProductDao {
    int deleteByPrimaryKey(Long prodId);

    int insert(PayProduct record);

    int insertSelective(PayProduct record);

    PayProduct selectByPrimaryKey(Long prodId);

    int updateByPrimaryKeySelective(PayProduct record);

    int updateByPrimaryKey(PayProduct record);
    
    PayProduct getProdByCode(String prodCode);
}