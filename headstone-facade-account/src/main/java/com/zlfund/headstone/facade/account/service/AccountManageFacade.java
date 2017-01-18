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
public interface AccountManageFacade {

    /**
     * 绑定银行卡
     *
     * @param name 用户姓名
     * @param idno 用户身份证
     * @param bankacco 银行账号
     * @param bankid 银行ID
     *
     * @return 用户开户后的信息
     *
     * @throws AccountBizException
     */
    CustInfo bind(String name, String idno, String bankacco, String bankid) throws AccountBizException;

    /**
     * 登录服务
     *
     * @param loginid 登录Id，身份证或者手机号码
     * @param password 登录密码
     *
     * @return 登陆后的用户信息
     *
     * @throws AccountBizException
     */
    CustInfo login(String loginid, String password) throws AccountBizException;

    /**
     * Method description
     *
     * @param mobileNo
     * @param password
     * @param smsAuthCode
     *
     * @return
     *
     * @throws AccountBizException
     */
    CustInfo reg(String mobileNo, String password, String smsAuthCode) throws AccountBizException;

    /**
     * Method description
     *
     * @param mobileNo
     *
     * @throws AccountBizException
     */
    void sendSmsAuthCode(String mobileNo) throws AccountBizException;
}


//~ Formatted by Jindent --- http://www.jindent.com
