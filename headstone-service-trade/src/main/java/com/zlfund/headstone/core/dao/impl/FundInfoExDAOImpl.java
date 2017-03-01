/**
 * @Title FundInfoExDAOImpl.java 
 * @Package com.zlfund.headstone.core.dao.impl 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月24日 下午3:46:50 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zlfund.headstone.core.dao.FundInfoExDAO;
import com.zlfund.headstone.core.dao.po.FundInfoExPO;
import com.zlfund.headstone.core.mapper.FundInfoExMapper;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月24日 下午3:46:50 
 * @history:
 */
@Repository("fundInfoExDAO")
public class FundInfoExDAOImpl implements FundInfoExDAO {

    @Autowired
    FundInfoExMapper fundInfoExMapper;

    @Override
    public FundInfoExPO getFundInfoExByFundId(String fundId) {
        return fundInfoExMapper.getFundInfoExByFundId(fundId);
    }

    @Override
    public int countFundInfoExIfFuse(String fundId) {
        return fundInfoExMapper.countFundInfoExIfFuse(fundId);
    }

}
