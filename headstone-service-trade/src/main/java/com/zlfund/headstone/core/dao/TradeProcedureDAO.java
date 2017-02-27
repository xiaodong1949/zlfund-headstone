/**
 * @Title TradeProcedureDAO.java 
 * @Package com.zlfund.headstone.core.dao 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月27日 下午2:36:52 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao;

/** 
 * 交易类存储过程
 * 目前为了赶进度,部分功能仍然采用存储过程方式(大部分为查询类)
 * 后续可以考虑改为JAVA实现
 * @author: 徐文凡 
 * @since: 2017年2月27日 下午2:36:52 
 * @history:
 */
public interface TradeProcedureDAO {

    /**
     * 查询用户是否为首次购买该基金
     * @param param 
     * @create: 2017年2月27日 下午2:38:57 
     * @author: 徐文凡
     * @history:
     */
    String oqpFundIsFirstBuy(String custNo, String fundId, String apKind);

    /**
     * 获取当前中港共同工作日
     * @param apKind
     * @return 
     * @create: 2017年2月27日 下午4:57:41 
     * @author: 徐文凡
     * @history:
     */
    String ibfGetCurrentHKWorkDate(String apKind);

    /**
     * 获取当前工作日
     * @param apKind
     * @return 
     * @create: 2017年2月27日 下午4:58:09 
     * @author: 徐文凡
     * @history:
     */
    String ibfGetCurrentWorkdate(String apKind);

    /**
     * 获取资金留存
     * @param tradeAcco
     * @return 
     * @create: 2017年2月27日 下午7:00:16 
     * @author: 徐文凡
     * @history:
     */
    double oqpGetCapitalbalanceTradeacco(String tradeAcco);
}
