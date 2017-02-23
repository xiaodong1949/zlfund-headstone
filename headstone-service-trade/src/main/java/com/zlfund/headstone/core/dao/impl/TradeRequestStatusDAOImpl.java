/**
 * @Title TradeRequestStatusDAOImpl.java 
 * @Package com.zlfund.headstone.core.dao.impl 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月22日 上午10:24:06 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.zlfund.headstone.core.dao.TradeRequestStatusDAO;
import com.zlfund.headstone.core.dao.po.TradeRequestStatusPO;
import com.zlfund.headstone.core.mapper.TradeRequestStatusMapper;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月22日 上午10:24:06 
 * @history:
 */
public class TradeRequestStatusDAOImpl implements TradeRequestStatusDAO {

    @Autowired
    TradeRequestStatusMapper tradeRequestStatusMapper;

    /** 
     * @see com.zlfund.headstone.core.dao.TradeRequestStatusDAO#saveTradeRequestStatus(com.zlfund.headstone.core.dao.po.TradeRequestStatusPO)
     */
    @Override
    public int saveTradeRequestStatus(TradeRequestStatusPO tradeRequestStatusPO) {
        return tradeRequestStatusMapper.saveTradeRequestStatus(tradeRequestStatusPO);
    }

    /** 
     * @see com.zlfund.headstone.core.dao.TradeRequestStatusDAO#updateTradeRequestStatusPO(com.zlfund.headstone.core.dao.po.TradeRequestStatusPO)
     */
    @Override
    public int updateTradeRequestStatusPO(TradeRequestStatusPO tradeRequestStatusPO) {
        return tradeRequestStatusMapper.updateTradeRequestStatus(tradeRequestStatusPO);
    }

}
