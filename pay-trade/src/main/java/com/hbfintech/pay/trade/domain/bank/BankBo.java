package com.hbfintech.pay.trade.domain.bank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbfintech.pay.trade.domain.bank.cache.BankOpenChannelsWeightWorker;
import com.hbfintech.pay.trade.domain.bank.cache.BankOpenChannelsWorker;
import com.hbfintech.pay.trade.repository.entity.PayChannelBank;

@Service
public class BankBo 
{

    @Autowired
    BankOpenChannelsWorker bankOpenChannelsWorker;
    
    @Autowired
    BankOpenChannelsWeightWorker bankOpenChannelsWeightWorker;
    
    
    public List<PayChannelBank> getBankOpenChannels(String bankCode){
        return bankOpenChannelsWorker.find(bankCode);
    }

    public List<String> getBankChannelWeightList(String bankCode){
        return bankOpenChannelsWeightWorker.find(bankCode);
    }
    
    public PayChannelBank getByCode(String bankCode ,String channelCode) {
        List<PayChannelBank> banks = bankOpenChannelsWorker.find(bankCode);
        for(PayChannelBank channelBank : banks ) {
            if(channelCode.equals(channelBank.getChannelCode())){
                return channelBank;
            }
        }
        return null;
    }

}
