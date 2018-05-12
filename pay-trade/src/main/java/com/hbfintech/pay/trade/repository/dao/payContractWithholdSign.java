package com.hbfintech.pay.trade.repository.dao;

import com.hbfintech.pay.trade.repository.po.PayContractWithholdSign;

public interface payContractWithholdSign {
    int deleteByPrimaryKey(Long withholdSignId);

    int insert(PayContractWithholdSign record);

    int insertSelective(PayContractWithholdSign record);

    PayContractWithholdSign selectByPrimaryKey(Long withholdSignId);

    int updateByPrimaryKeySelective(PayContractWithholdSign record);

    int updateByPrimaryKey(PayContractWithholdSign record);
}