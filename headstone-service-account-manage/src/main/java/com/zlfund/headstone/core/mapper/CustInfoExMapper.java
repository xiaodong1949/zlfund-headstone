package com.zlfund.headstone.core.mapper;

import org.apache.ibatis.annotations.Param;

import com.zlfund.headstone.core.common.mybatis.BaseSqlMapper;
import com.zlfund.headstone.core.dao.po.CustInfoExPO;

/**
 * @author Yang Xiaodong
 * @since: 2017年2月21日
 */
public interface CustInfoExMapper extends BaseSqlMapper {

    /** 
     * @param mobileno
     * @return
     * @return 
     * @create: 2017年2月23日
     * @author: Yang Xiaodong
     * @history: 
     */
    boolean queryAlreadyRegistered(@Param("mobileno") String mobileno);

    /** 
     * 插入custinfoex表
     * @param custInfoExPO
     * @return 
     * @create: 2017年2月23日
     * @author: Yang Xiaodong
     * @history: 
     */
    void saveCustInfoEx(@Param("custInfoExPO") CustInfoExPO custInfoExPO);
}