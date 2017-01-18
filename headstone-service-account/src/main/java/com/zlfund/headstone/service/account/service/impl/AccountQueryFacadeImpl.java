package com.zlfund.headstone.service.account.service.impl;

import com.zlfund.headstone.core.account.dao.AccountQueryDao;
import com.zlfund.headstone.facade.account.entity.CustInfo;
import com.zlfund.headstone.facade.account.exception.AccountBizException;
import com.zlfund.headstone.facade.account.service.AccountQueryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 账户登录信息查询AccountHisQueryFacade实现类。
 *
 * @author yanfengking@163.com
 * @version V1.0.0, 2017-01-11
 */
@Component("accountQueryFacade")
public class AccountQueryFacadeImpl implements AccountQueryFacade {

    @Autowired
    private AccountQueryDao accountQueryDao;


    @Override
    public CustInfo getCustinfo(String loginID) throws AccountBizException {
        if (loginID == null) {
            throw AccountBizException.ACCOUNT_NOT_EXIT;
        }
        CustInfo custInfo = null;
        int len = loginID.length();
        switch (len) {
            case 10:
                custInfo = accountQueryDao.findCustInfoByCustNo(loginID);
                break;
            case 11:
                custInfo = accountQueryDao.findCustInfoByMobileNo(loginID);
                break;
            case 15:
            case 18:
                custInfo = accountQueryDao.findCustInfoByIdno(loginID);
                break;
            default:
                throw AccountBizException.ACCOUNT_NOT_EXIT;
        }
        if (custInfo == null) {
            throw AccountBizException.ACCOUNT_NOT_EXIT;
        } else {
            return custInfo;
        }
    }
}

