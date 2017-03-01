package com.zlfund.headstone.core.dao.impl;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zlfund.headstone.JUnitServiceBase;
import com.zlfund.headstone.core.dao.BankBnkBaseDAO;
import com.zlfund.headstone.core.dao.po.BankBnkBasePO;

public class BankBnkBaseDAOImplTest extends JUnitServiceBase {

    @Autowired
    BankBnkBaseDAO bankBnkBaseDAO;

    @Test
    public void testGetBankBnkBaseByBankNo() {
        BankBnkBasePO bankBnkBasePO = bankBnkBaseDAO.getBankBnkBaseByBankNo("b01");
        System.out.println(bankBnkBasePO);

        bankBnkBasePO = bankBnkBaseDAO.getBankBnkBaseByBankNo("002");
        System.out.println(bankBnkBasePO);

        Assert.assertNotNull(bankBnkBasePO);
    }
}
