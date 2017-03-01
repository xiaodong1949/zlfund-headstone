package com.zlfund.headstone.core.dao.impl;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zlfund.headstone.JUnitServiceBase;
import com.zlfund.headstone.core.dao.TradeAccoInfoDAO;
import com.zlfund.headstone.core.dao.po.TradeAccoInfoPO;

public class TradeAccoInfoDAOImplTest extends JUnitServiceBase {

    @Autowired
    TradeAccoInfoDAO tradeAccoInfoDAO;

    @Test
    public void testGetTradeAccoInfoByTradeAcco() {
        TradeAccoInfoPO tradeAccoInfoPO = tradeAccoInfoDAO.getTradeAccoInfoByTradeAcco("1000011336");
        System.out.println(tradeAccoInfoPO);
    }

    @Test
    public void testGetTradeAccoInfoByTradeAccoAndCustNo() {
        fail("Not yet implemented");
    }

    @Test
    public void testCountYeepayRemainCust() {
        fail("Not yet implemented");
    }

}
