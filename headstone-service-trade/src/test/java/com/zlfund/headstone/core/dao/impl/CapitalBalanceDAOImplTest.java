package com.zlfund.headstone.core.dao.impl;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zlfund.headstone.JUnitServiceBase;
import com.zlfund.headstone.core.dao.CapitalBalanceDAO;
import com.zlfund.headstone.core.dao.po.CapitalBalancePO;

public class CapitalBalanceDAOImplTest extends JUnitServiceBase {

    @Autowired
    CapitalBalanceDAO capitalBalanceDAO;

    @Test
    public void testCountCapitalBalance() {
        CapitalBalancePO capitalBalancePO = new CapitalBalancePO();
        capitalBalancePO.setTradeAcco("1001228169");
        int count = capitalBalanceDAO.countCapitalBalance(capitalBalancePO);

        System.out.println(count);
    }

    @Test
    public void testSaveCapitalBalance() {
        CapitalBalancePO capitalBalancePO = new CapitalBalancePO();
        capitalBalancePO.setCustNo("1000065746");
        capitalBalancePO.setTradeAcco("1001009202");
        capitalBalancePO.setBalance(1234);
        capitalBalancePO.setAbnmFrozen(0);
        capitalBalancePO.setUpdateTimeStamp(new Date());
        capitalBalancePO.setTransferStatus("S");
        capitalBalancePO.setReturnBalance(0);
        capitalBalancePO.setSoaDate("20170227");
        capitalBalancePO.setLastDate("20170227");

        int count = capitalBalanceDAO.saveCapitalBalance(capitalBalancePO);
        System.out.println(count);
    }

    @Test
    public void testUpdateCapitalBalance() {
        CapitalBalancePO capitalBalancePO = new CapitalBalancePO();
        capitalBalancePO.setTradeAcco("1000011336");
        capitalBalancePO.setCustNo("1000012992");
        capitalBalancePO.setAbnmFrozen(6543.21);

        int count = capitalBalanceDAO.updateCapitalBalance(capitalBalancePO);
        System.out.println(count);
    }
}
