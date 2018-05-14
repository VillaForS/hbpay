package com.hbfintech.pay.trade.domain.bank;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.hbfintech.pay.trade.dict.PayConstants;
import com.hbfintech.pay.trade.domain.bank.cache.BankOpenChannelsWorker;
import com.hbfintech.pay.trade.domain.prod.cache.ProdBankCacheWorker;
import com.hbfintech.pay.trade.repository.entity.PayBankProduct;
import com.hbfintech.pay.trade.repository.entity.PayChannelBank;

@Service
public class BankBo 
{

    @Autowired
    ProdBankCacheWorker prodOpenBankCacheWorker ;
    
    @Autowired
    BankOpenChannelsWorker bankOpenChannelsWorker;
    
    
    public List<PayChannelBank> getBankOpenChannels(String bankCode){
        List<PayChannelBank> list = bankOpenChannelsWorker.find(bankCode);
        return list;
    }


}
