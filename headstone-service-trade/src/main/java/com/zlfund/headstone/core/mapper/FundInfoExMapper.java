/**
 * @Title FundInfoExMapper.java 
 * @Package com.zlfund.headstone.core.mapper 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月24日 下午3:34:26 
 * @version V1.0   
 */
package com.zlfund.headstone.core.mapper;

import org.apache.ibatis.annotations.Param;

import com.zlfund.headstone.core.common.mybatis.BaseSqlMapper;
import com.zlfund.headstone.core.dao.po.FundInfoExPO;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月24日 下午3:34:26 
 * @history:
 */
public interface FundInfoExMapper extends BaseSqlMapper {

    FundInfoExPO getFundInfoExByFundId(@Param("fundId") String fundId);

    int countFundInfoExIfFuse(@Param("fundId") String fundId);
}
