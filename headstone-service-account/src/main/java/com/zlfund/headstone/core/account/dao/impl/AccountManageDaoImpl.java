package com.zlfund.headstone.core.account.dao.impl;

import com.zlfund.headstone.core.account.dao.AccountManageDao;
import com.zlfund.headstone.core.common.dao.BaseDaoImpl;
import com.zlfund.headstone.facade.account.entity.CustInfo;
import org.springframework.stereotype.Repository;

/**
 * Created by vcoolwind on 2017/1/14.
 */

@Repository("accountManageDao")
public class AccountManageDaoImpl extends BaseDaoImpl<CustInfo> implements AccountManageDao {

    @Override
    public CustInfo insertCustinfo(String mobileNo, String loginPwd, String mobileVerifiST) {
        CustInfo custInfo = new CustInfo();
        custInfo.setCustno(newCustno());
        custInfo.setMobileno(mobileNo);
        custInfo.setMobileverifist(mobileVerifiST);
        custInfo.setLoginPWD(loginPwd);
        super.insert(custInfo);
        return custInfo;
    }

    @Override
    public String newCustno() {
        Integer cusnto = super.getSessionTemplate().selectOne(getStatement("newCustNo"));

        return String.valueOf(cusnto);
    }


}
