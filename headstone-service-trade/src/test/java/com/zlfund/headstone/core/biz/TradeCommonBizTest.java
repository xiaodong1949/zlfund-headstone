package com.zlfund.headstone.core.biz;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zlfund.headstone.JUnitServiceBase;

public class TradeCommonBizTest extends JUnitServiceBase {

    @Autowired
    TradeCommonBiz commonBiz;

    @Test
    public void testNewTradeSerialNo() {
        fail("Not yet implemented");
    }

    @Test
    public void testNewBankSerialNo() {
        fail("Not yet implemented");
    }

    @Test
    public void testCheckTradeAvailable() {
        String custNo = "1000012992";
        String tradeAcco = "1000011336";
        String fundId = "000771";
        String apKind = "022";
        double quantity = 1234.56;

        commonBiz.checkTradeAvailable(custNo, tradeAcco, fundId, apKind, quantity);
    }

    @Test
    public void testCheckCustAbnStatus() {
        fail("Not yet implemented");
    }

    @Test
    public void testCheckFundStatus() {
        fail("Not yet implemented");
    }

    @Test
    public void testCheckMarketIsFuse() {
        fail("Not yet implemented");
    }

    @Test
    public void testCheckSingleTradeAccoTA() {
        fail("Not yet implemented");
    }

    @Test
    public void testCheckBankTradeTime() {
        fail("Not yet implemented");
    }

    @Test
    public void testCheckApKindIsStop() {
        fail("Not yet implemented");
    }

    @Test
    public void testCheckIsMinor() {
        fail("Not yet implemented");
    }

}
