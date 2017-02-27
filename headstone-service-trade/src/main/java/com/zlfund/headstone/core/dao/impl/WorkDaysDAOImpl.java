/**
 * @Title WorkDayDAOImpl.java 
 * @Package com.zlfund.headstone.core.dao.impl 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月24日 下午1:40:59 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao.impl;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.zlfund.headstone.core.dao.WorkDaysDAO;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月24日 下午1:40:59 
 * @history:
 */
@Repository("workDaysDAO")
public class WorkDaysDAOImpl implements WorkDaysDAO {

    @Override
    public String getMachineDate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getMachineTime() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Date getCurrentTimeStamp() {
        // TODO Auto-generated method stub
        return null;
    }

}
