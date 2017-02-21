/**
 * @Title BuyFacade.java 
 * @Package com.zlfund.headstone.facade.trade.service 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月20日 下午5:04:10 
 * @version V1.0   
 */
package com.zlfund.headstone.facade.trade.service;

import com.zlfund.headstone.facade.trade.dto.BuyRequestDTO;
import com.zlfund.headstone.facade.trade.dto.BuyResultDTO;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月20日 下午5:04:10 
 * @history:
 */
public interface BuyFacade {

    BuyResultDTO buy(BuyRequestDTO buyRequest);

}
