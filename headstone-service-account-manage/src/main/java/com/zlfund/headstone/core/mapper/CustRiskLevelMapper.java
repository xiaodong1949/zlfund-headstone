package com.zlfund.headstone.core.mapper;

import org.apache.ibatis.annotations.Param;

import com.zlfund.headstone.core.common.mybatis.BaseSqlMapper;

/**
 * @author Yang Xiaodong
 * @since: 2017年2月21日
 */
public interface CustRiskLevelMapper extends BaseSqlMapper {

    /** 
     * 查询是否存有设置过风险等级
     * @param custno
     * @return
     * @return 
     * @create: 2017年2月23日
     * @author: Yang Xiaodong
     * @history: 
     */
    boolean queryNotSetCustRiskLevel(@Param("custno") String custno);

    /** 
     * 设置风险等级
     * @param custInfoExPO
     * @return 
     * @create: 2017年2月23日
     * @author: Yang Xiaodong
     * @history: 
     */
    void saveCustRiskLevel(@Param("custno") String custno);
}
