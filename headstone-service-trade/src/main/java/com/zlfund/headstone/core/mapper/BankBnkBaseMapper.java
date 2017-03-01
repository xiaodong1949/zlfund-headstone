/**
 * @Title BankBnkBaseMapper.java 
 * @Package com.zlfund.headstone.core.mapper 
 * @Description 
 * @author 徐文凡
 * @date 2017年3月1日 上午10:22:55 
 * @version V1.0   
 */
package com.zlfund.headstone.core.mapper;

import org.apache.ibatis.annotations.Param;

import com.zlfund.headstone.core.common.mybatis.BaseSqlMapper;
import com.zlfund.headstone.core.dao.po.BankBnkBasePO;

/** 
 * @author: 徐文凡 
 * @since: 2017年3月1日 上午10:22:55 
 * @history:
 */
public interface BankBnkBaseMapper extends BaseSqlMapper {

    BankBnkBasePO getBankBnkBaseByBankNo(@Param("bankNo") String bankNo);

}
