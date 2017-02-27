
package com.zlfund.headstone.core.mapper;

import org.apache.ibatis.annotations.Param;

import com.zlfund.headstone.core.common.mybatis.BaseSqlMapper;
import com.zlfund.headstone.core.dao.po.InfoSendProdPO;


/**
 * @author Yang Xiaodong
 * @since: 2017年2月27日
 */
public interface InfoSendProdMapper extends BaseSqlMapper {

    boolean saveInfoSendProd(@Param("infoSendProdPO") InfoSendProdPO infoSendProdPO);

}
