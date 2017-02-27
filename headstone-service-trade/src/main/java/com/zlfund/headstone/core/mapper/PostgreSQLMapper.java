/**
 * @Title PostgreSQLMapper.java 
 * @Package com.zlfund.headstone.core.mapper 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月27日 下午4:05:34 
 * @version V1.0   
 */
package com.zlfund.headstone.core.mapper;

import java.util.Date;

import com.zlfund.headstone.core.common.mybatis.BaseSqlMapper;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月27日 下午4:05:34 
 * @history:
 */
public interface PostgreSQLMapper extends BaseSqlMapper {

    String getCurrentDate();

    String getCurrentTime();

    Date getCurrentTimeStamp();

}
