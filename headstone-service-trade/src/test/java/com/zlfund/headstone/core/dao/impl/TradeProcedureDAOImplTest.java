package com.zlfund.headstone.core.dao.impl;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zlfund.headstone.JUnitServiceBase;
import com.zlfund.headstone.core.dao.TradeProcedureDAO;

public class TradeProcedureDAOImplTest extends JUnitServiceBase {

    @Autowired
    TradeProcedureDAO tradeProcedureDAO;

    @Test
    public void testOqpFundIsFirstBuy() {
        String firstBuyFlag = tradeProcedureDAO.oqpFundIsFirstBuy("1000012992", "000771", "022");
        System.out.println(firstBuyFlag);

        Assert.assertNotNull(firstBuyFlag);
    }

    @Test
    public void testIbfGetCurrentHKWorkDate() {
        String workDate = tradeProcedureDAO.ibfGetCurrentHKWorkDate("022");
        System.out.println(workDate);

        Assert.assertNotNull(workDate);
    }

    @Test
    public void testIbfGetCurrentWorkdate() {
        String workDate = tradeProcedureDAO.ibfGetCurrentWorkdate("022");
        System.out.println(workDate);

        Assert.assertNotNull(workDate);
    }
}
