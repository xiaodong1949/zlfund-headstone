/**
 * @Title buyFacadeImpl.java 
 * @Package com.zlfund.headstone.facade.trade.service.impl 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月20日 下午6:57:43 
 * @version V1.0   
 */
package com.zlfund.headstone.facade.trade.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zlfund.headstone.core.biz.BuyBiz;
import com.zlfund.headstone.facade.trade.dto.BuyRequestDTO;
import com.zlfund.headstone.facade.trade.dto.BuyResultDTO;
import com.zlfund.headstone.facade.trade.service.BuyFacade;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月20日 下午6:57:43 
 * @history:
 */
@Component("buyFacade")
public class BuyFacadeImpl implements BuyFacade {

    private static final Logger LOG = Logger.getLogger(BuyFacadeImpl.class);

    @Autowired
    private BuyBiz buyBiz;

    /** 
     * @see com.zlfund.headstone.facade.trade.service.BuyFacade#buy(com.zlfund.headstone.facade.trade.dto.BuyRequestDTO)
     */
    @Override
    public BuyResultDTO buy(BuyRequestDTO buyRequest) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("buy request:" + buyRequest);
        }

        // 下单
        buyBiz.buyFund();

        // 发起扣款
        buyBiz.charge();

        BuyResultDTO buyResult = new BuyResultDTO();
        buyResult.setSuccess(true);
        return buyResult;
    }
}
