package com.zlfund.headstone.facade.account.service;

import com.zlfund.headstone.facade.account.entity.CustInfo;
import com.zlfund.headstone.facade.account.exception.AccountBizException;

/**
 * Interface description
 *
 *
 * @version        V1.0.0, 2017-01-11
 * @author         yanfengking@163.com
 */
public interface AccountQueryFacade {

    CustInfo getCustinfo(String loginID) throws AccountBizException;

}


//~ Formatted by Jindent --- http://www.jindent.com
