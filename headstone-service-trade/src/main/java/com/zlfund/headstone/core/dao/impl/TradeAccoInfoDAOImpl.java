/**
 * @Title TradeAccoInfoDAOImpl.java 
 * @Package com.zlfund.headstone.core.dao.impl 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月22日 下午2:08:21 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zlfund.headstone.core.dao.TradeAccoInfoDAO;
import com.zlfund.headstone.core.dao.po.TradeAccoInfoPO;
import com.zlfund.headstone.core.mapper.TradeAccoInfoMapper;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月22日 下午2:08:21 
 * @history:
 */
@Repository("tradeAccoInfoDAO")
public class TradeAccoInfoDAOImpl implements TradeAccoInfoDAO {

    @Autowired
    TradeAccoInfoMapper tradeAccoInfoMapper;

    @Override
    public TradeAccoInfoPO getTradeAccoInfoByTradeAcco(String tradeAcco) {
        return tradeAccoInfoMapper.getTradeAccoInfoByTradeAcco(tradeAcco);
    }

    @Override
    public TradeAccoInfoPO getTradeAccoInfoByTradeAccoAndCustNo(String tradeAcco, String custNo) {
        return tradeAccoInfoMapper.getTradeAccoInfoByTradeAccoAndCustNo(tradeAcco, custNo);
    }

    @Override
    public int countYeepayRemainCust(String custNo) {
        return tradeAccoInfoMapper.countYeepayRemainCust(custNo);
    }

}
