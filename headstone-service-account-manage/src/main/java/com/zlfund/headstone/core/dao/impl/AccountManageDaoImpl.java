package com.zlfund.headstone.core.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zlfund.headstone.core.dao.AccountManageDao;
import com.zlfund.headstone.core.dao.po.CustInfoExPO;
import com.zlfund.headstone.core.dao.po.CustInfoPO;
import com.zlfund.headstone.core.dao.po.InfoSendProdPO;
import com.zlfund.headstone.core.mapper.CustInfoExMapper;
import com.zlfund.headstone.core.mapper.CustInfoMapper;
import com.zlfund.headstone.core.mapper.CustRiskLevelMapper;
import com.zlfund.headstone.core.mapper.InfoSendProdMapper;
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
    private CustInfoExMapper custInfoExMapper;

    @Autowired
    private MerchantMapper merchantMapper;

    @Autowired
    private CustRiskLevelMapper custRiskLevelMapper;

    @Autowired
    private InfoSendProdMapper infoSendProdMapper;

    /*
     * (non-Javadoc)
     * 
     * @see com.zlfund.headstone.core.dao.AccountManageDao#queryFromMerchant(java.lang.String, java.lang.String)
     */
    @Override
    public boolean queryFromMerchant(String mctcode) {
        return merchantMapper.queryFromMerchant(mctcode);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zlfund.headstone.core.dao.AccountManageDao#queryAlreadyRegistered(java.lang.String)
     */
    @Override
    public boolean queryAlreadyRegistered(String mobileno) {
        return custInfoMapper.queryAlreadyRegistered(mobileno) || custInfoExMapper.queryAlreadyRegistered(mobileno);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zlfund.headstone.core.dao.AccountManageDao#queryMctRegistered(java.lang.String)
     */
    @Override
    public String queryMctRegistered(String mobileno) {
        if (custInfoMapper.queryMctRegistered(mobileno)) {
            return custInfoMapper.getlastDigitsIdno(mobileno, 4);
        } else {
            return "";
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zlfund.headstone.core.dao.AccountManageDao#getNewCustno()
     */
    @Override
    public String getNewCustno() {
        return custInfoMapper.generateCustno();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zlfund.headstone.core.dao.AccountManageDao#getNewVIdno()
     */
    @Override
    public String getNewVIdno() {
        return custInfoMapper.generateVirtualIdno();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zlfund.headstone.core.dao.AccountManageDao#saveCustinfo(com.zlfund.headstone.core.dao.po.CustinfoPO)
     */
    @Override
    public void saveCustInfo(CustInfoPO custInfoPO) {
        custInfoMapper.saveCustInfo(custInfoPO);

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zlfund.headstone.core.dao.AccountManageDao#saveCustinfoex(com.zlfund.headstone.core.dao.po.CustinfoexPO)
     */
    @Override
    public void saveCustInfoEx(CustInfoExPO custInfoExPO) {
        custInfoExMapper.saveCustInfoEx(custInfoExPO);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zlfund.headstone.core.dao.AccountManageDao#saveCustrisklevel(java.lang.String)
     */
    @Override
    public void saveCustRiskLevel(String custno) {
        if (custRiskLevelMapper.queryNotSetCustRiskLevel(custno)) {
            custRiskLevelMapper.saveCustRiskLevel(custno);
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zlfund.headstone.core.dao.AccountManageDao#saveInfoSendProd(java.lang.String)
     */
    @Override
    public void saveInfoSendProd(InfoSendProdPO infoSendProdPO) {
        infoSendProdMapper.saveInfoSendProd(infoSendProdPO);
    }

}
