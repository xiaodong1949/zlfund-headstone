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

import com.zlfund.headstone.core.dao.CustInfoDAO;
import com.zlfund.headstone.core.dao.po.CustInfoPO;
import com.zlfund.headstone.core.mapper.CustInfoMapper;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月22日 下午2:08:21 
 * @history:
 */
public class CustInfoDAOImpl implements CustInfoDAO {

    @Autowired
    CustInfoMapper custInfoMapper;

    @Override
    public CustInfoPO getCustInfoByCustNo(String custNo) {
        return custInfoMapper.getCustInfoByCustNo(custNo);
    }

    @Override
    public int countCustInfoByCustNo(String custNo) {
        return 0;
    }

}
