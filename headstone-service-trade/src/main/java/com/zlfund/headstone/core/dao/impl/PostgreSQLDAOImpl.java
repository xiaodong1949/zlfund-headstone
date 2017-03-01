/**
 * @Title PostgreSQLDAOImpl.java 
 * @Package com.zlfund.headstone.core.dao.impl 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月27日 下午4:05:11 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zlfund.headstone.core.dao.PostgreSQLDAO;
import com.zlfund.headstone.core.mapper.PostgreSQLMapper;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月27日 下午4:05:11 
 * @history:
 */
@Repository("postgreSQLDAO")
public class PostgreSQLDAOImpl implements PostgreSQLDAO {

    @Autowired
    PostgreSQLMapper postgreSQLMapper;

    @Override
    public String getCurrentDate() {
        return postgreSQLMapper.getCurrentDate();
    }

    @Override
    public String getCurrentTime() {
        return postgreSQLMapper.getCurrentTime();
    }

    @Override
    public Date getCurrentTimeStamp() {
        return postgreSQLMapper.getCurrentTimeStamp();
    }

}
