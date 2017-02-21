/**
 * @Title BuyBiz.java 
 * @Package com.zlfund.headstone.core.biz 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月21日 上午10:08:52 
 * @version V1.0   
 */
package com.zlfund.headstone.core.biz;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zlfund.headstone.core.dao.po.TradeRequestPO;
import com.zlfund.headstone.facade.trade.dto.BuyRequestDTO;

/** 
 * 交易购买业务层接口实现类
 * @author: 徐文凡 
 * @since: 2017年2月21日 上午10:08:52 
 * @history:
 */
@Component("buyBiz")
public class BuyBiz {

    /**
     * 购买基金产品
     * @param buyRequest 购买请求
     * @return 
     * @create: 2017年2月21日 上午11:27:08 
     * @author: 徐文凡
     * @history:
     */
    @Transactional(rollbackFor = Exception.class)
    public TradeRequestPO buyFund(BuyRequestDTO buyRequest) {
        // 基本参数校验
        if (buyRequest == null) {
        }

        return null;
    }

    public void buyZYB() {
    }

    public void buyPZB() {
    }

}
