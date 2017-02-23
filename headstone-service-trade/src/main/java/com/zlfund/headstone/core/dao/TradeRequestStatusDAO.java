/**
 * @Title TradeRequestStatusDAO.java 
 * @Package com.zlfund.headstone.core.dao 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月22日 上午10:20:19 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao;

import com.zlfund.headstone.core.dao.po.TradeRequestStatusPO;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月22日 上午10:20:19 
 * @history:
 */
public interface TradeRequestStatusDAO {

    int saveTradeRequestStatus(TradeRequestStatusPO tradeRequestStatusPO);

    int updateTradeRequestStatusPO(TradeRequestStatusPO tradeRequestStatusPO);
}
