package com.hbfintech.pay.trade.domain.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbfintech.pay.trade.dict.PayConstants;
import com.hbfintech.pay.trade.repository.po.PayBank;

@Service
public class BankBo 
{

    @Autowired
    BankCacheWorker bankCacheWorker ;
    
    public Boolean isBankOpen(String bankCode)
    {
        PayBank bank = bankCacheWorker.find(bankCode);
        if(null!=bank&&bank.getBankStatus()==PayConstants.OPEN) {
            return true;
        }
        return false;
    }


}
