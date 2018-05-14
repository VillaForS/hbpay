package com.hbfintech.pay.trade.service.router;

import org.apache.commons.collections.CollectionUtils;

import com.hbfintech.pay.intf.enumm.RespCodeEnum;

public abstract class AbstractChannelRule implements Rule
{

    @Override
    public void execute(RouteDto routeDto)
    {
       if(CollectionUtils.isEmpty(routeDto.getWaitFilterBanks())) {
           routeDto.setResp(RespCodeEnum.BIZ_CHANNEL_NOAVAL);
           return;
       }
       doExecute(routeDto);
       return;
    }
   abstract void doExecute(RouteDto routeDto);

}
