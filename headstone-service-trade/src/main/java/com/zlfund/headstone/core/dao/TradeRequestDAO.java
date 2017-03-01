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

    public TradeRequestPO getTradeRequestBySerialNo(String serialNo);

    public TradeRequestPO getTradeRequest();

    public List<TradeRequestPO> listTradeRequest();

    public int countTradeRequest();

    public int saveTradeRequest(TradeRequestPO tradeRequestPO);

    public int updateTradeRequest(TradeRequestPO tradeRequestPO);

}
