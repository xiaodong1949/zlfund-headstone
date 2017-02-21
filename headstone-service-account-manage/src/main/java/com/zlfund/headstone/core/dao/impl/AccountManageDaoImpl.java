package com.zlfund.headstone.core.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zlfund.headstone.core.common.dao.BaseDaoImpl;
import com.zlfund.headstone.core.dao.AccountManageDao;
import com.zlfund.headstone.core.dao.po.CustInfoPO;
import com.zlfund.headstone.core.mapper.CustInfoMapper;

/**
 * AccountManageDao实现
 * @author Yang Xiaodong
 * @since: 2017年2月21日
 */
@Repository("AccountManageDao")
public class AccountManageDaoImpl extends BaseDaoImpl<CustInfoPO> implements AccountManageDao {
    @Autowired
    private CustInfoMapper custInfoMapper;

    /*
     * (non-Javadoc)
     * 
     * @see com.zlfund.headstone.core.dao.AccountManageDao#getCustInfo(java.lang.String)
     */
    @Override
    public CustInfoPO getCustInfo(String custNo) {
        return custInfoMapper.getCustInfo(custNo);
    }

}
