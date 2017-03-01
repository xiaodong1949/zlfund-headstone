package com.zlfund.headstone.core.dao.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zlfund.headstone.JUnitServiceBase;
import com.zlfund.headstone.core.bo.AvailableBalanceBO;
import com.zlfund.headstone.core.dao.FundBalanceDAO;

public class FundBalanceDAOImplTest extends JUnitServiceBase {

    @Autowired
    FundBalanceDAO fundBalanceDAO;

    @Test
    public void testFundBalanceLineForUpdate() {
        String tradeAcco = "1000011336";
        String fundId = "000771";
        double balance = fundBalanceDAO.fundBalanceLineForUpdate(tradeAcco, fundId);
        System.out.println(balance);
    }

    @Test
    public void testOqpGetAvaliableBalance() {
        String tradeAcco = "1000011336";
        String fundId = "000771";
        AvailableBalanceBO availableBalanceBO = fundBalanceDAO.oqpGetAvaliableBalance(tradeAcco, fundId);
        System.out.println(availableBalanceBO);
    }

    @Test
    public void testGetYHHQBAvailableBalance() {
        double balance = fundBalanceDAO.getYHHQBAvailableBalance("1000303911");
        System.out.println(balance);
    }

}
