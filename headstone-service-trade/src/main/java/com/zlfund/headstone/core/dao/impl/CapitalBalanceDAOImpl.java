/**
 * @Title CapitalBalanceDAOImpl.java 
 * @Package com.zlfund.headstone.core.dao.impl 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月23日 下午6:27:18 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zlfund.headstone.core.dao.CapitalBalanceDAO;
import com.zlfund.headstone.core.dao.po.CapitalBalancePO;
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
    public int countCapitalBalance(CapitalBalancePO capitalBalancePO) {
        return capitalBalanceMapper.countCapitalBalance(capitalBalancePO);
    }

    @Override
    public int saveCapitalBalance(CapitalBalancePO capitalBalancePO) {
        return capitalBalanceMapper.saveCapitalBalance(capitalBalancePO);
    }

    @Override
    public int updateCapitalBalance(CapitalBalancePO capitalBalancePO) {
        return capitalBalanceMapper.updateCapitalBalance(capitalBalancePO);
    }

    @Override
    public CapitalBalancePO getCapitalBalance(CapitalBalancePO capitalBalancePO) {
        return capitalBalanceMapper.getCapitalBalance(capitalBalancePO);
    }

}
