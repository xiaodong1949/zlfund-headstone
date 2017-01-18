package com.zlfund.headstone.service.account.service.impl;

import com.zlfund.headstone.core.account.dao.AccountManageDao;
import com.zlfund.headstone.core.account.dao.AccountQueryDao;
import com.zlfund.headstone.facade.account.entity.CustInfo;
import com.zlfund.headstone.facade.account.exception.AccountBizException;
import com.zlfund.headstone.facade.account.service.AccountManageFacade;
import com.zlfund.headstone.facade.account.service.AccountQueryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 账户管理AccountManagementFacade实现类
 *
 * @author yanfengking@163.com
 * @version V1.0.0, 2017-01-11
 */
@Component("accountManageFacade")
public class AccountManageFacadeImpl implements AccountManageFacade {
    @Autowired
    private AccountManageDao accountManageDao;

    @Autowired
    private AccountQueryFacade accountQueryFacade;

    @Override
    public CustInfo bind(String name, String idno, String bankacco, String bankid) throws AccountBizException {
        return null;
    }

    @Override
    public CustInfo login(String loginid, String password) throws AccountBizException {
        return null;
    }

    @Override
    public CustInfo reg(String mobileNo, String password, String smsAuthCode) throws AccountBizException {
        try {
            CustInfo custInfo = accountQueryFacade.getCustinfo(mobileNo);
            if (custInfo != null && "N".equals(custInfo.getMobileverifist())) {
                throw AccountBizException.ACCOUNT_MOBILENO_EXIT;
            }
        } catch (AccountBizException abe) {
            //账户不存在的异常是可接受的。
            if (abe.getCode() != AccountBizException.ACCOUNT_NOT_EXIT.getCode()) {
                throw abe;
            }
        }


        if ("000000".equals(smsAuthCode)) {
            //TODO 测试伪代码
            throw AccountBizException.ACCOUNT_SMSAUTHCODE_ERROR;
        }
        return accountManageDao.insertCustinfo(mobileNo, password, "N");
    }

    @Override
    public void sendSmsAuthCode(String mobileNo) throws AccountBizException {
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
