package com.zlfund.headstone.core.dao.impl;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zlfund.headstone.JUnitServiceBase;
import com.zlfund.headstone.core.dao.PostgreSQLDAO;

public class PostgreSQLDAOImplTest extends JUnitServiceBase {

    @Autowired
    PostgreSQLDAO postgreSQLDAO;

    @Test
    public void testGetCurrentDate() {
        String currentDate = postgreSQLDAO.getCurrentDate();
        System.out.println(currentDate);
    }

    @Test
    public void testGetCurrentTime() {
        String currentTime = postgreSQLDAO.getCurrentTime();
        System.out.println(currentTime);
    }

    @Test
    public void testGetCurrentTimeStamp() {
        Date currentTimeStamp = postgreSQLDAO.getCurrentTimeStamp();
        System.out.println(currentTimeStamp);
    }

}
