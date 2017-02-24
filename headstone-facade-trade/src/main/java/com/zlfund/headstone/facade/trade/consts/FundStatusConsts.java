/**
 * @Title FundStatusConsts.java 
 * @Package com.zlfund.headstone.facade.trade.consts 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月23日 上午11:22:30 
 * @version V1.0   
 */
package com.zlfund.headstone.facade.trade.consts;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月23日 上午11:22:30 
 * @history:
 */
public class FundStatusConsts {

    public static final String NORMAL = "0"; // 正常

    public static final String SUB = "1"; // 发行中

    public static final String STOP_TRADE = "4"; // 暂停交易

    public static final String STOP_BID = "5"; // 暂停申购

    public static final String STOP_RED = "6"; // 暂停赎回

    public static final String TERMINATE = "8"; // 基金终止

    public static final String CLOSE = "9"; // 基金封闭

}
