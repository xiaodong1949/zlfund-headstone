package com.zlfund.headstone.core.biz.fund;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zlfund.headstone.JUnitServiceBase;
import com.zlfund.headstone.facade.trade.dto.BuyRequestDTO;

public class FundBizTest extends JUnitServiceBase {

    @Autowired
    FundBiz fundBiz;

    @Test
    public void testCheckBeforeBuy() {
        BuyRequestDTO buyRequest = new BuyRequestDTO();

        fundBiz.checkBeforeBuy(buyRequest);
    }

    @Test
    public void testSubmitBuy() {
        // fail("Not yet implemented");
    }

}
