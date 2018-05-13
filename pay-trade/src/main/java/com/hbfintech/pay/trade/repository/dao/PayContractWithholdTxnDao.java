package com.hbfintech.pay.trade.repository.dao;

import com.hbfintech.pay.trade.repository.entity.PayContractWithholdTxn;

public interface PayContractWithholdTxnDao {
    int deleteByPrimaryKey(Long withholdTxnId);

    int insert(PayContractWithholdTxn record);

    int insertSelective(PayContractWithholdTxn record);

    PayContractWithholdTxn selectByPrimaryKey(Long withholdTxnId);

    int updateByPrimaryKeySelective(PayContractWithholdTxn record);

    int updateByPrimaryKey(PayContractWithholdTxn record);
    
    int processing(Long id);
    
    int fail(PayContractWithholdTxn record);
}