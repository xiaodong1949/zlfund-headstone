package com.zlfund.headstone.core.account.dao.impl;

import com.zlfund.headstone.core.account.dao.AccountQueryDao;
import com.zlfund.headstone.core.common.dao.BaseDaoImpl;
import com.zlfund.headstone.facade.account.entity.CustInfo;
import com.zlfund.headstone.facade.account.exception.AccountBizException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vcoolwind on 2017/1/14.
 */
@Repository("accountQueryDao")
public class AccountQueryDaoImpl extends BaseDaoImpl<CustInfo> implements AccountQueryDao {
    @Override
    public CustInfo findCustInfoByCustNo(String custNo) throws AccountBizException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("custno", custNo);
        return super.getBy(params);
    }

    @Override
    public CustInfo findCustInfoByIdno(String idno) throws AccountBizException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("idno", idno);
        return super.getBy(params);
    }

    @Override
    public CustInfo findCustInfoByMobileNo(String mobileNo) throws AccountBizException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("mobileno", mobileNo);
        params.put("mobileverifist", "N");
        return super.getBy(params);
    }
}
