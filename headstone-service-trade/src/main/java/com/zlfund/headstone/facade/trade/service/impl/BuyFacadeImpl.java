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

import com.zlfund.headstone.facade.trade.entity.BuyRequest;
import com.zlfund.headstone.facade.trade.entity.BuyResult;
import com.zlfund.headstone.facade.trade.service.BuyFacade;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月20日 下午6:57:43 
 * @history:
 */
public class BuyFacadeImpl implements BuyFacade {

    private static final Logger LOG = Logger.getLogger(BuyFacadeImpl.class);

    /** 
     * @see com.zlfund.headstone.facade.trade.service.BuyFacade#buy(com.zlfund.headstone.facade.trade.entity.BuyRequest)
     */
    @Override
    public BuyResult buy(BuyRequest buyRequest) {
        LOG.info(buyRequest);

        BuyResult buyResult = new BuyResult();
        buyResult.setErrCod("0000");
        buyResult.setErrMsg("成功");
        buyResult.setWorkDate("20170220");
        return buyResult;
    }
}
