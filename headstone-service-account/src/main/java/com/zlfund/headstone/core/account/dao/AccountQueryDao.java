package com.zlfund.headstone.core.account.dao;

import com.zlfund.headstone.core.common.dao.BaseDao;
import com.zlfund.headstone.facade.account.entity.CustInfo;
import com.zlfund.headstone.facade.account.exception.AccountBizException;

/**
 * 账户相关查询DAO
 *
 * @author yanfengking@163.com
 * @version V1.0.0, 2017-01-12
 */
public interface AccountQueryDao extends BaseDao<CustInfo> {

    /**
     * 根据客户号码查询用户信息
     *
     * @param custNo
     * @return
     * @throws AccountBizException
     */
    CustInfo findCustInfoByCustNo(String custNo) throws AccountBizException;

    /**
     * 根据身份证查询用户信息
     *
     * @param idno
     * @return
     * @throws AccountBizException
     */
    CustInfo findCustInfoByIdno(String idno) throws AccountBizException;

    /**
     * Method description
     *
     * @param mobileNo
     * @return
     * @throws AccountBizException
     */
    CustInfo findCustInfoByMobileNo(String mobileNo) throws AccountBizException;

}


//~ Formatted by Jindent --- http://www.jindent.com
