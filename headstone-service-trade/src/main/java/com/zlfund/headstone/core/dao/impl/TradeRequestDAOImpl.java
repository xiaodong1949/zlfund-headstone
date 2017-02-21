/**
 * @Title TradeRequestDAOImpl.java 
 * @Package com.zlfund.headstone.core.dao.impl 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月21日 上午11:00:53 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.zlfund.headstone.core.dao.TradeRequestDAO;
import com.zlfund.headstone.core.mapper.TradeRequestMapper;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月21日 上午11:00:53 
 * @history:
 */
public class TradeRequestDAOImpl implements TradeRequestDAO {

    @Autowired
    private TradeRequestMapper tradeRequestMapper;

    // CRUD
}
