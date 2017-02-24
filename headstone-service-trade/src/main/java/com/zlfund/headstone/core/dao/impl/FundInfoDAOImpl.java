/**
 * @Title FundInfoDAOImpl.java 
 * @Package com.zlfund.headstone.core.dao.impl 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月22日 下午1:23:06 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zlfund.headstone.core.dao.FundInfoDAO;
import com.zlfund.headstone.core.dao.po.FundInfoPO;
import com.zlfund.headstone.core.mapper.FundInfoMapper;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月22日 下午1:23:06 
 * @history:
 */
@Repository("fundInfoDAO")
public class FundInfoDAOImpl implements FundInfoDAO {

    @Autowired
    FundInfoMapper fundInfoMapper;

    @Override
    public FundInfoPO getFundInfoByFundId(String fundId) {
        return fundInfoMapper.getFundInfoByFundId(fundId);
    }

    @Override
    public int countFundInfoByFundId(String fundId) {
        return fundInfoMapper.countFundInfoByFundId(fundId);
    }

}
