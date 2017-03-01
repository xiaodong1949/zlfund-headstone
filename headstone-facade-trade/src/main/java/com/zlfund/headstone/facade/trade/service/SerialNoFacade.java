/**
 * @Title SerialNoFacade.java 
 * @Package com.zlfund.headstone.facade.trade.service 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月28日 上午9:49:50 
 * @version V1.0   
 */
package com.zlfund.headstone.facade.trade.service;

/** 
 * 流水号业务
 * @author: 徐文凡 
 * @since: 2017年2月28日 上午9:49:50 
 * @history:
 */
public interface SerialNoFacade {

    /**
     * 生成交易流水号
     * @return 
     * @create: 2017年2月28日 上午9:50:15 
     * @author: 徐文凡
     * @history:
     */
    String newTradeSerialNo();

}
