/**
 * @Title WorkDateBiz.java 
 * @Package com.zlfund.headstone.core.biz 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月24日 下午1:36:30 
 * @version V1.0   
 */
package com.zlfund.headstone.core.biz;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zlfund.headstone.core.bo.CurrentWorkDateBO;
import com.zlfund.headstone.core.dao.FundInfoExDAO;
import com.zlfund.headstone.core.dao.PostgreSQLDAO;
import com.zlfund.headstone.core.dao.TradeProcedureDAO;
import com.zlfund.headstone.core.dao.po.FundInfoExPO;

/** 
 * 日期与时间业务
 * 包括取数据库时间,获取工作日等和日期时间相关的
 * @author: 徐文凡 
 * @since: 2017年2月24日 下午1:36:30 
 * @history:
 */
@Component("dateTimeBiz")
public class DateTimeBiz {

    @Autowired
    FundInfoExDAO fundInfoExDAO;

    @Autowired
    PostgreSQLDAO postgreSQLDAO;

    @Autowired
    TradeProcedureDAO procedureDAO;

    /**
     * 获取当前工作日,以数据库时间为准(绝对不能使用应用服务器时间!!!)
     * @param fundId 产品代码 用于区分中港互认
     * @param apKind 交易类型
     * @return 
     * @create: 2017年2月24日 下午3:33:29 
     * @author: 徐文凡
     * @history:
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public CurrentWorkDateBO getCurrentCommonWorkDate(String fundId, String apKind) {
        // 当前日期
        String currentDate = getCurrentDate();
        // 当前时间
        String currentTime = getCurrentTime();
        // 当前工作日
        String currentWorkDate = null;

        FundInfoExPO fundInfoExPO = fundInfoExDAO.getFundInfoExByFundId(fundId);
        if ("6".equals(fundInfoExPO.getFundStyle())) {
            // 中港互认
            currentWorkDate = getCurrentHKWorkDate(apKind);
        } else {
            currentWorkDate = getCurrentWorkDate(apKind);
        }

        CurrentWorkDateBO workDateBO = new CurrentWorkDateBO();
        workDateBO.setCurrentDate(currentDate);
        workDateBO.setCurrentTime(currentTime);
        workDateBO.setCurrentWorkDate(currentWorkDate);

        return workDateBO;
    }

    /**
     * 获取当前中港互认工作日
     * @param apKind
     * @return 
     * @create: 2017年2月24日 下午4:43:36 
     * @author: 徐文凡
     * @history:
     */
    public String getCurrentHKWorkDate(String apKind) {
        // TODO 暂时调用IBF_GET_CURRENT_HK_WORKDATE 后续改为JAVA
        // return workDaysDAO.ibfGetCurrentHKWorkDate(apKind);
        return null;
    }

    /**
     * 获取当前工作日
     * @param apKind
     * @return 
     * @create: 2017年2月24日 下午4:43:44 
     * @author: 徐文凡
     * @history:
     */
    public String getCurrentWorkDate(String apKind) {
        // TODO 暂时调用IBF_GET_CURRENT_WORKDATE 后续改为JAVA
        // return workDaysDAO.ibfGetCurrentWorkDate(apKind);
        return null;
    }

    /**
     * 获取当前日期,取数据库日期
     * @return 
     * @create: 2017年2月24日 下午3:52:44 
     * @author: 徐文凡
     * @history:
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public String getCurrentDate() {
        return postgreSQLDAO.getCurrentDate();
    }

    /**
     * 获取当前时间,取数据库时间
     * @return 
     * @create: 2017年2月24日 下午3:53:00 
     * @author: 徐文凡
     * @history:
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public String getCurrentTime() {
        return postgreSQLDAO.getCurrentTime();
    }

    /**
     * 获取当前系统时间戳
     * @return 
     * @create: 2017年2月27日 下午4:01:17 
     * @author: 徐文凡
     * @history:
     */
    public Date getCurrentTimeStamp() {
        return postgreSQLDAO.getCurrentTimeStamp();
    }

}
