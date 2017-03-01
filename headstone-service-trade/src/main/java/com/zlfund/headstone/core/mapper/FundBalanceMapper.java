/**
 * @Title FundBalanceMapper.java 
 * @Package com.zlfund.headstone.core.mapper 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月27日 上午11:23:33 
 * @version V1.0   
 */
package com.zlfund.headstone.core.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zlfund.headstone.core.common.mybatis.BaseSqlMapper;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月27日 上午11:23:33 
 * @history:
 */
public interface FundBalanceMapper extends BaseSqlMapper {

    double fundBalanceLineForUpdate(@Param("tradeAcco") String tradeAcco, @Param("fundId") String fundId);

    void oqpGetAvaliableBalance(Map<String, Object> param);

    double getYHHQBAvailableBalance(@Param("tradeAcco") String tradeAcco);
}
