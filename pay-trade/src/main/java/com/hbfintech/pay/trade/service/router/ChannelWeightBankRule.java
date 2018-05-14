package com.hbfintech.pay.trade.service.router;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.hbfintech.pay.trade.domain.bank.BankBo;
import com.hbfintech.pay.trade.repository.entity.PayChannelBank;

/**
 * 渠道权重路由规则
 *
 * @author zhush
 * @since 1.0
 */
@Component
public class ChannelWeightBankRule extends AbstractChannelRule
{
    
    private static int seq =0;
            
    @Autowired
    BankBo bankBo;

    @Override
    public void doExecute(RouteDto routeDto)
    {
        List<String> weightList = bankBo.getBankChannelWeightList(routeDto.getBankCode());
        if(CollectionUtils.isEmpty(weightList)) {
            return;
        }
        List<PayChannelBank> list = Lists.newArrayList();
        if(seq>=weightList.size()) {
            seq=0;
        }
        String channelCode = weightList.get(seq);
        list.add(bankBo.getByCode(routeDto.getBankCode(), channelCode) );    
        routeDto.setWaitFilterBanks(list);
        return;
    }


}
