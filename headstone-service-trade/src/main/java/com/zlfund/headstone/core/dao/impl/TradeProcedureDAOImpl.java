/**
 * @Title TradeProcedureDAOImpl.java 
 * @Package com.zlfund.headstone.core.dao.impl 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月27日 下午2:39:21 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zlfund.headstone.core.dao.TradeProcedureDAO;
import com.zlfund.headstone.core.mapper.TradeProcedureMapper;

/** 
 * 交易类存储过程
 * 目前为了赶进度,部分功能仍然采用存储过程方式(大部分为查询类)
 * 后续可以考虑改为JAVA实现
 * @author: 徐文凡 
 * @since: 2017年2月27日 下午2:39:21 
 * @history:
 */
@Repository("tradeProcedureDAO")
public class TradeProcedureDAOImpl implements TradeProcedureDAO {

    @Autowired
    TradeProcedureMapper tradeProcedureMapper;

    /** 
     * @see com.zlfund.headstone.core.dao.TradeProcedureDAO#oqpFundIsFirstBuy(java.util.Map)
     */
    @Override
    public String oqpFundIsFirstBuy(String custNo, String fundId, String apKind) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("custNo", custNo);
        param.put("fundId", fundId);
        param.put("apKind", apKind);

        tradeProcedureMapper.oqpFundIsFirstBuy(param);

        return (String)param.get("firstBuyFlag");
    }

    @Override
    public String ibfGetCurrentHKWorkDate(String apKind) {
        return tradeProcedureMapper.ibfGetCurrentHKWorkDate(apKind);
    }

    @Override
    public String ibfGetCurrentWorkdate(String apKind) {
        return tradeProcedureMapper.ibfGetCurrentWorkDate(apKind);
    }

    @Override
    public double oqpGetCapitalbalanceTradeacco(String tradeAcco) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("tradeAcco", tradeAcco);
        tradeProcedureMapper.oqpGetCapitalbalanceTradeacco(param);

        return ((BigDecimal)param.get("sumAvailable")).doubleValue();
    }

}
