/**
 * @Title TradeRequestDAOImpl.java 
 * @Package com.zlfund.headstone.core.dao.impl 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月21日 上午11:00:53 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zlfund.headstone.core.dao.TradeRequestDAO;
import com.zlfund.headstone.core.dao.po.TradeRequestPO;
import com.zlfund.headstone.core.mapper.TradeRequestMapper;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月21日 上午11:00:53 
 * @history:
 */
@Repository("tradeRequestDAO")
public class TradeRequestDAOImpl implements TradeRequestDAO {

    @Autowired
    private TradeRequestMapper tradeRequestMapper;

    @Override
    public TradeRequestPO getTradeRequest() {
        return null;
    }

    @Override
    public List<TradeRequestPO> listTradeRequest() {
        return null;
    }

    @Override
    public int countTradeRequest() {
        return 0;
    }

    @Override
    public int saveTradeRequest(TradeRequestPO tradeRequestPO) {
        return tradeRequestMapper.saveTradeRequest(tradeRequestPO);
    }

    @Override
    public int updateTradeRequest(TradeRequestPO tradeRequestPO) {
        return tradeRequestMapper.updateTradeRequest(tradeRequestPO);
    }

}
