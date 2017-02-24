/**
 * @Title TradeRequestMapper.java 
 * @Package com.zlfund.headstone.core.mapper 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月21日 下午2:22:55 
 * @version V1.0   
 */
package com.zlfund.headstone.core.mapper;

import org.apache.ibatis.annotations.Param;

import com.zlfund.headstone.core.common.mybatis.BaseSqlMapper;
import com.zlfund.headstone.core.dao.po.FundInfoPO;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月21日 下午2:22:55 
 * @history:
 */
public interface FundInfoMapper extends BaseSqlMapper {

    FundInfoPO getFundInfoByFundId(@Param("fundId") String fundId);

    int countFundInfoByFundId(@Param("fundId") String fundId);
}