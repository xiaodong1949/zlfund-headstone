/**
 * @Title CapitalBalanceDAO.java 
 * @Package com.zlfund.headstone.core.dao 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月23日 下午6:26:56 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月23日 下午6:26:56 
 * @history:
 */
public interface CapitalBalanceDAO {

    double getAvailableCapitalBalance(String tradeAcco);
}
