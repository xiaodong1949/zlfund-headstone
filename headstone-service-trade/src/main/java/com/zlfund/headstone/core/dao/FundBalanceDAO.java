/**
 * @Title FundBalanceDAO.java 
 * @Package com.zlfund.headstone.core.dao 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月27日 上午11:21:48 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao;

import com.zlfund.headstone.core.bo.AvailableBalanceBO;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月27日 上午11:21:48 
 * @history:
 */
public interface FundBalanceDAO {

    /**
     * 对持仓记录做行锁
     * @param tradeAcco
     * @param fundId 
     * @create: 2017年2月27日 上午11:22:45 
     * @author: 徐文凡
     * @history:
     */
    double fundBalanceLineForUpdate(String tradeAcco, String fundId);

    /**
     * 获取账户可用份额
     * @param tradeAcco
     * @param fundId
     * @return 
     * @create: 2017年2月27日 下午1:27:54 
     * @author: 徐文凡
     * @history:
     */
    AvailableBalanceBO oqpGetAvaliableBalance(String tradeAcco, String fundId);

    /**
     * 获取银华活钱宝可用份额
     * @param tradeAcco
     * @return 
     * @create: 2017年2月27日 下午3:06:22 
     * @author: 徐文凡
     * @history:
     */
    double getYHHQBAvailableBalance(String tradeAcco);
}
