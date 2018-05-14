package com.hbfintech.pay.trade.domain.bank.cache;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.hbfintech.pay.trade.dict.PayCacheKeys;
import com.hbfintech.pay.trade.repository.dao.PayChannelBankDao;
import com.hbfintech.pay.trade.repository.entity.PayChannelBank;
import com.hbfintech.redis.utils.RedisCacheUtil;
import com.hbfintech.redis.utils.SyncCacheWorker;

@Component
public class BankOpenChannelsWorker extends SyncCacheWorker<List<PayChannelBank>,String>{
    
    @Autowired
    RedisCacheUtil  redisCacheUtil;
    
    @Autowired
    PayChannelBankDao payChannelBankDao; 
    
    protected List<PayChannelBank> read(String bankCode) {
         String banks=  redisCacheUtil.hgetBin(PayCacheKeys.CHANNEL_BANK_OPEN, bankCode, String.class);
         return  JSON.parseArray(banks, PayChannelBank.class);
    }
    
    protected List<PayChannelBank> write(String bankCode) { 
        
         List<PayChannelBank> banks = payChannelBankDao.getChannelOpenBanks(bankCode);
         redisCacheUtil.hsetBin(PayCacheKeys.CHANNEL_BANK_OPEN, bankCode, banks);
         return banks;
    }

}
