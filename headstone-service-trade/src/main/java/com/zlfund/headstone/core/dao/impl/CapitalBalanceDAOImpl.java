/**
 * @Title CapitalBalanceDAOImpl.java 
 * @Package com.zlfund.headstone.core.dao.impl 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月23日 下午6:27:18 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zlfund.headstone.core.dao.CapitalBalanceDAO;
import com.zlfund.headstone.core.mapper.CapitalBalanceMapper;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月23日 下午6:27:18 
 * @history:
 */
@Repository("capitalBalanceDAO")
public class CapitalBalanceDAOImpl implements CapitalBalanceDAO {

    @Autowired
    CapitalBalanceMapper capitalBalanceMapper;

    @Override
    public double getAvailableCapitalBalance(String tradeAcco) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("tradeAcco", tradeAcco);
        capitalBalanceMapper.getAvailableCapitalBalance(param);
        return ((BigDecimal)param.get("sumAvailable")).doubleValue();
    }

}
