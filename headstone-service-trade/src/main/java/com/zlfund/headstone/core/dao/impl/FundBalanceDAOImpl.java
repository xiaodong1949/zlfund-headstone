/**
 * @Title FundBalanceDAOImpl.java 
 * @Package com.zlfund.headstone.core.dao.impl 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月27日 上午11:22:11 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zlfund.headstone.core.bo.AvailableBalanceBO;
import com.zlfund.headstone.core.dao.FundBalanceDAO;
import com.zlfund.headstone.core.mapper.FundBalanceMapper;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月27日 上午11:22:11 
 * @history:
 */
@Repository("fundBalanceDAO")
public class FundBalanceDAOImpl implements FundBalanceDAO {

    @Autowired
    FundBalanceMapper fundBalanceMapper;

    @Override
    public double fundBalanceLineForUpdate(String tradeAcco, String fundId) {
        return fundBalanceMapper.fundBalanceLineForUpdate(tradeAcco, fundId);
    }

    @Override
    public AvailableBalanceBO oqpGetAvaliableBalance(String tradeAcco, String fundId) {
        AvailableBalanceBO availableBalanceBO = new AvailableBalanceBO();

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("tradeAcco", tradeAcco);
        param.put("fundId", fundId);
        fundBalanceMapper.oqpGetAvaliableBalance(param);

        availableBalanceBO.setBalance(((BigDecimal)param.get("balance")).doubleValue());
        availableBalanceBO.setAvailableBalance(((BigDecimal)param.get("available")).doubleValue());
        availableBalanceBO.setFrozenBalance(((BigDecimal)param.get("frozen")).doubleValue());

        return availableBalanceBO;
    }

    @Override
    public double getYHHQBAvailableBalance(String tradeAcco) {
        return fundBalanceMapper.getYHHQBAvailableBalance(tradeAcco);
    }

}
