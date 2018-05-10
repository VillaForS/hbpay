package com.hbfintech.pay.trade.domain.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hbfintech.pay.trade.dict.PayCacheKeys;
import com.hbfintech.pay.trade.repository.dao.PayBankDao;
import com.hbfintech.pay.trade.repository.po.PayBank;
import com.hbfintech.redis.utils.RedisCacheUtil;
import com.hbfintech.redis.utils.SyncCacheWorker;

@Component
public class BankCacheWorker extends SyncCacheWorker<PayBank,String>{
    
    @Autowired
    RedisCacheUtil  redisCacheUtil;
    
    @Autowired
    PayBankDao payBankDao; 
    
    protected PayBank read(String bankCode) {
        return redisCacheUtil.hgetBin(PayCacheKeys.BANK_VALIDBANKS, bankCode, PayBank.class);
    }
    
    protected PayBank write(String bankCode) { 
        
         PayBank bank = payBankDao.getBankByCode(bankCode);
         if(null!=bank) {
             redisCacheUtil.hsetBin(PayCacheKeys.BANK_VALIDBANKS, bankCode, bank);
         }
         return bank;
    }

}
