/**
 * @Title AbstractBuyBiz.java 
 * @Package com.zlfund.headstone.core.biz 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月22日 下午3:14:20 
 * @version V1.0   
 */
package com.zlfund.headstone.core.biz.buy;

import com.zlfund.headstone.core.dao.po.TradeRequestPO;
import com.zlfund.headstone.facade.trade.dto.BuyRequestDTO;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月22日 下午3:14:20 
 * @history:
 */
public abstract class AbstractBuyBiz {

    abstract TradeRequestPO buy(BuyRequestDTO buyRequestDTO);
}
