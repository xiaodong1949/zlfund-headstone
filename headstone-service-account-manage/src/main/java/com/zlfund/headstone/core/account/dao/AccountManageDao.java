package com.zlfund.headstone.core.account.dao;

import com.zlfund.headstone.core.common.dao.BaseDao;
import com.zlfund.headstone.facade.account.entity.CustInfo;

/**
 * Interface description
 *
 * @author yanfengking@163.com
 * @version V1.0.0, 2017-01-12
 */
public interface AccountManageDao extends BaseDao<CustInfo> {

    /**
     * Method description
     *
     * @param mobileNo
     * @param loginPwd
     * @param mibileVerifiST
     *
     * @return
     */
    CustInfo insertCustinfo(String mobileNo, String loginPwd, String mibileVerifiST);

    /**
     * Method description
     *
     * @return
     */
    String newCustno();
}


//~ Formatted by Jindent --- http://www.jindent.com
