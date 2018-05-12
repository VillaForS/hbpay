package com.hbfintech.pay.trade.domain.bank;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.hbfintech.pay.trade.dict.PayConstants;
import com.hbfintech.pay.trade.domain.bank.cache.ProdBankCacheWorker;
import com.hbfintech.pay.trade.repository.po.PayBankProduct;

@Service
public class BankBo 
{

    @Autowired
    ProdBankCacheWorker prodOpenBankCacheWorker ;
    
    public Boolean isProdBankOpen(String prodCode ,String bankCode)
    {
        HashMap<String,String> map = Maps.newHashMap();
        map.put("prodCode", prodCode);
        map.put("bankCode", bankCode);
        PayBankProduct payBankProduct = prodOpenBankCacheWorker.find(map);
        if(null!=payBankProduct&&PayConstants.OPEN==payBankProduct.getStatus()) {
           return true;
        }
        return false;
    }


}
