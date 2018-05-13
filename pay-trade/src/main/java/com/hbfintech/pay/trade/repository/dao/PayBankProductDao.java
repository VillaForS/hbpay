package com.hbfintech.pay.trade.repository.dao;

import java.util.List;

import com.hbfintech.pay.trade.repository.entity.PayBankProduct;

public interface PayBankProductDao {
    int deleteByPrimaryKey(Long bankProdId);

    int insert(PayBankProduct record);

    int insertSelective(PayBankProduct record);

    PayBankProduct selectByPrimaryKey(Long bankProdId);

    int updateByPrimaryKeySelective(PayBankProduct record);

    int updateByPrimaryKey(PayBankProduct record);
    
    List<PayBankProduct> getProdOpenBanks(String prodCode);
    
    PayBankProduct getByProdAndBankCode(String prodCode,String bankCode);
}