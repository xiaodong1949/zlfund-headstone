package com.zlfund.headstone.core.dao.impl;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zlfund.headstone.JUnitServiceBase;
import com.zlfund.headstone.core.dao.po.CustInfoPO;

public class CustInfoDAOImplTest extends JUnitServiceBase {

    @Autowired
    CustInfoDAOImpl custInfoDAO;

    @Test
    public void testGetCustInfoByCustNo() {
        custInfoDAO = null;
        CustInfoPO custInfoPO = custInfoDAO.getCustInfoByCustNo("1000012992");
        System.out.println(custInfoPO);
    }

    @Test
    public void testCountCustInfoByCustNo() {
        fail("Not yet implemented");
    }

}
