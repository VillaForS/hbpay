package com.hbfintech.pay.trade.repository.dao;

import com.hbfintech.pay.trade.repository.po.PayMerchantProduct;

public interface PayMerchantProductDao {
    int deleteByPrimaryKey(Long mchProdId);

    int insert(PayMerchantProduct record);

    int insertSelective(PayMerchantProduct record);

    PayMerchantProduct selectByPrimaryKey(Long mchProdId);

    int updateByPrimaryKeySelective(PayMerchantProduct record);

    int updateByPrimaryKey(PayMerchantProduct record);
    
    PayMerchantProduct getMchProd(String mchCode,String prodCode);
}