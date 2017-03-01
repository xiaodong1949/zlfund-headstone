/**
 * @Title CustAbnStatusMapper.java 
 * @Package com.zlfund.headstone.core.mapper 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月26日 下午6:02:49 
 * @version V1.0   
 */
package com.zlfund.headstone.core.mapper;

import org.apache.ibatis.annotations.Param;

import com.zlfund.headstone.core.common.mybatis.BaseSqlMapper;
import com.zlfund.headstone.core.dao.po.CustAbnStatusPO;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月26日 下午6:02:49 
 * @history:
 */
public interface CustAbnStatusMapper extends BaseSqlMapper {

    CustAbnStatusPO getCustAbnStatusByIdNo(@Param("idNo") String idNo, @Param("counterpart") String counterpart);

}
