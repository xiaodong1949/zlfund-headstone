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
import com.zlfund.headstone.core.dao.po.TradeAccoInfoPO;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月21日 下午2:22:55 
 * @history:
 */
public interface TradeAccoInfoMapper extends BaseSqlMapper {

    TradeAccoInfoPO getTradeAccoInfoByTradeAcco(@Param("tradeAcco") String tradeAcco);

}
