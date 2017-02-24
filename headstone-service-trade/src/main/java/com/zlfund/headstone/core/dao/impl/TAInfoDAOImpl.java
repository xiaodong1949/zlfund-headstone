/**
 * @Title TAInfoDAOImpl.java 
 * @Package com.zlfund.headstone.core.dao.impl 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月23日 下午1:19:43 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zlfund.headstone.core.dao.TAInfoDAO;
import com.zlfund.headstone.core.dao.po.TAInfoPO;
import com.zlfund.headstone.core.mapper.TAInfoMapper;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月23日 下午1:19:43 
 * @history:
 */
@Repository("taInfoDAO")
public class TAInfoDAOImpl implements TAInfoDAO {

    @Autowired
    TAInfoMapper taInfoMapper;

    /** 
     * @see com.zlfund.headstone.core.dao.TAInfoDAO#getTaInfoByFundId(java.lang.String)
     */
    @Override
    public TAInfoPO getTaInfoByFundId(String fundId) {
        return taInfoMapper.getTAInfoByFundId(fundId);
    }

}
