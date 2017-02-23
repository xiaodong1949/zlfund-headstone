package com.zlfund.headstone.core.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zlfund.headstone.core.dao.AccountManageDao;
import com.zlfund.headstone.core.dao.po.CustInfoExPO;
import com.zlfund.headstone.core.dao.po.CustInfoPO;
import com.zlfund.headstone.core.dao.po.MerchantPO;
import com.zlfund.headstone.core.mapper.CustInfoMapper;
import com.zlfund.headstone.core.mapper.MerchantMapper;

/**
 * AccountManageDao实现
 * @author Yang Xiaodong
 * @since: 2017年2月21日
 */
@Repository("AccountManageDao")
public class AccountManageDaoImpl implements AccountManageDao {
    @Autowired
    private CustInfoMapper custInfoMapper;

    @Autowired
    private MerchantMapper merchantMapper;

    /*
     * (non-Javadoc)
     * 
     * @see com.zlfund.headstone.core.dao.AccountManageDao#queryFromMerchant(java.lang.String, java.lang.String)
     */
    @Override
    public boolean queryFromMerchant(String mctcode, String partnerno) {
        MerchantPO merchantPO = new MerchantPO();
        merchantPO.setMctcode(mctcode);
        merchantPO.setPartnerno(partnerno);
        return merchantMapper.queryFromMerchant(merchantPO);
    }

    @Override
    public boolean queryAlreadyRegistered(String mobileNo, String mobilenoVerifist) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean queryMctRegistered(String mobileNo, String mobilenoVerifist) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String getNewCustno() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getNewVIdno() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void saveCustInfo(CustInfoPO custInfoPO) {
        // TODO Auto-generated method stub

    }

    @Override
    public void saveCustinfoex(CustInfoExPO custInfoExPO) {
        // TODO Auto-generated method stub

    }

}
