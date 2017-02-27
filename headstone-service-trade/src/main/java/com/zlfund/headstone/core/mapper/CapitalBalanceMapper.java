/**
 * @Title CapitalBalanceMapper.java 
 * @Package com.zlfund.headstone.core.mapper 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月23日 下午7:04:55 
 * @version V1.0   
 */
package com.zlfund.headstone.core.mapper;

import org.apache.ibatis.annotations.Param;

import com.zlfund.headstone.core.common.mybatis.BaseSqlMapper;
import com.zlfund.headstone.core.dao.po.CapitalBalancePO;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月23日 下午7:04:55 
 * @history:
 */
public interface CapitalBalanceMapper extends BaseSqlMapper {

    int countCapitalBalance(@Param("capitalBalance") CapitalBalancePO capitalBalancePO);

    int saveCapitalBalance(@Param("capitalBalance") CapitalBalancePO capitalBalancePO);

    int updateCapitalBalance(@Param("capitalBalance") CapitalBalancePO capitalBalancePO);

    CapitalBalancePO getCapitalBalance(@Param("capitalBalance") CapitalBalancePO capitalBalancePO);
}
