package com.zlfund.headstone.facade.account.manage.service;

import com.zlfund.headstone.facade.account.manage.dto.RegisterResultDTO;
import com.zlfund.headstone.facade.account.manage.exception.AccountManageBizException;

/**
 * 帐户管理接口
 * @author Yang Xiaodong
 * @since: 2017年2月21日
 */
public interface AccountManageFacade {

    /** 
     * 用户手机号码注册
     * @param mobileNo
     * @param password
     * @param smsAuthCode
     * @return
     * @throws AccountManageBizException
     * @return 
     * @create: 2017年2月21日
     * @author: Yang Xiaodong
     * @history: 
     */
    RegisterResultDTO register(String mobileNo, String password) throws AccountManageBizException;

}
