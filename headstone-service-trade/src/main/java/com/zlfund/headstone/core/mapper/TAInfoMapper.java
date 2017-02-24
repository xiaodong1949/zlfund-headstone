package com.zlfund.headstone.core.mapper;

import org.apache.ibatis.annotations.Param;

import com.zlfund.headstone.core.common.mybatis.BaseSqlMapper;
import com.zlfund.headstone.core.dao.po.TAInfoPO;

public interface TAInfoMapper extends BaseSqlMapper {

    TAInfoPO getTAInfoByFundId(@Param("fundId") String fundId);

}
