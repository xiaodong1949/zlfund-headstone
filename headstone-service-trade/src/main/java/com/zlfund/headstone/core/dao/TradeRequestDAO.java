/**
 * @Title TradeRequestDAO.java 
 * @Package com.zlfund.headstone.core.dao 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月21日 上午11:00:08 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao;

import java.util.List;

import com.zlfund.headstone.core.dao.po.TradeRequestPO;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月21日 上午11:00:08 
 * @history:
 */
public interface TradeRequestDAO {

    TradeRequestPO getTradeRequest();

    List<TradeRequestPO> listTradeRequest();

    int countTradeRequest();

    int saveTradeRequest(TradeRequestPO tradeRequestPO);

    int updateTradeRequest(TradeRequestPO tradeRequestPO);

}
