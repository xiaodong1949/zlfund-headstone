/**
 * @Title BuyFacade.java 
 * @Package com.zlfund.headstone.facade.trade.service 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月20日 下午5:04:10 
 * @version V1.0   
 */
package com.zlfund.headstone.facade.trade.service;

import com.zlfund.headstone.facade.trade.entity.BuyRequest;
import com.zlfund.headstone.facade.trade.entity.BuyResult;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月20日 下午5:04:10 
 * @history:
 */
public interface BuyFacade {

    BuyResult buy(BuyRequest buyRequest);

}
