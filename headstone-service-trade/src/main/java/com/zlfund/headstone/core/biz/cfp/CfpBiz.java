/**
 * @Title CfpBiz.java 
 * @Package com.zlfund.headstone.core.biz.cfp 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月22日 下午3:51:48 
 * @version V1.0   
 */
package com.zlfund.headstone.core.biz.cfp;

import com.zlfund.headstone.core.biz.fund.FundBiz;
import com.zlfund.headstone.facade.trade.dto.BuyRequestDTO;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月22日 下午3:51:48 
 * @history:
 */
public class CfpBiz extends FundBiz {

    @Override
    public void buy(BuyRequestDTO buyRequestDTO) {
        super.buy(buyRequestDTO);

        // 写电子合同
    }
}
