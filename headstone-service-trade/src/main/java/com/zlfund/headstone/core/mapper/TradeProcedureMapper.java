/**
 * @Title TradeProcedureMapper.java 
 * @Package com.zlfund.headstone.core.mapper 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月27日 下午2:39:57 
 * @version V1.0   
 */
package com.zlfund.headstone.core.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zlfund.headstone.core.common.mybatis.BaseSqlMapper;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月27日 下午2:39:57 
 * @history:
 */
public interface TradeProcedureMapper extends BaseSqlMapper {

    void oqpFundIsFirstBuy(Map<String, Object> param);

    String ibfGetCurrentHKWorkDate(@Param("apKind") String apKind);

    String ibfGetCurrentWorkDate(@Param("apKind") String apKind);

    double oqpGetCapitalbalanceTradeacco(Map<String, Object> param);
}
