package com.zlfund.headstone.core.biz.fund;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zlfund.headstone.JUnitServiceBase;
import com.zlfund.headstone.common.utils.RandomUtil;
import com.zlfund.headstone.facade.trade.dto.BuyRequestDTO;

public class FundBizTest extends JUnitServiceBase {

    @Autowired
    FundBiz fundBiz;

    @Test
    public void testCheckBeforeBuy() {
        BuyRequestDTO buyRequest = new BuyRequestDTO();
        buyRequest.setSerialNo(RandomUtil.generateString(24));
        buyRequest.setCustNo("1000012992");
        buyRequest.setTradeAcco("1000011336");
        buyRequest.setFundId("000771");
        buyRequest.setSubAmt(1234.56);

        fundBiz.checkBeforeBuy(buyRequest);
    }

    @Test
    public void testSubmitBuy() {
        // fail("Not yet implemented");
    }

}
