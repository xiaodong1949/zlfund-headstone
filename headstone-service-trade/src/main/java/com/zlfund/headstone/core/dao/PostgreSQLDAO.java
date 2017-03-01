/**
 * @Title PostgreSQLDAO.java 
 * @Package com.zlfund.headstone.core.dao 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月27日 下午4:04:18 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao;

import java.util.Date;

/** 
 * postgresql数据DAO 主要负责数据库本身相关数据
 * @author: 徐文凡 
 * @since: 2017年2月27日 下午4:04:18 
 * @history:
 */
public interface PostgreSQLDAO {

    String getCurrentDate();

    String getCurrentTime();

    Date getCurrentTimeStamp();

}
