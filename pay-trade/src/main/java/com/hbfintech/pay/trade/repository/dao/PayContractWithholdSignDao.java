package com.hbfintech.pay.trade.repository.dao;

import com.hbfintech.pay.trade.repository.entity.PayContractWithholdSign;

public interface PayContractWithholdSignDao {
    int deleteByPrimaryKey(Long withholdSignId);

    int insert(PayContractWithholdSign record);

    int insertSelective(PayContractWithholdSign record);

    PayContractWithholdSign selectByPrimaryKey(Long withholdSignId);

    int updateByPrimaryKeySelective(PayContractWithholdSign record);

    int updateByPrimaryKey(PayContractWithholdSign record);
    
    int waitConfirm(Long withholdSignId);
    
    int fail(PayContractWithholdSign record);
}