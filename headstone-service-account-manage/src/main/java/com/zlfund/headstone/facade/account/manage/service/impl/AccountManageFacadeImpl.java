package com.zlfund.headstone.facade.account.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zlfund.headstone.core.biz.RegisterBiz;
import com.zlfund.headstone.facade.account.manage.dto.RegisterResultDTO;
import com.zlfund.headstone.facade.account.manage.exception.AccountManageBizException;
import com.zlfund.headstone.facade.account.manage.service.AccountManageFacade;

/**
 * 帐户管理实现
 * @author Yang Xiaodong
 * @since: 2017年2月21日
 */
@Component("accountManageFacade")
public class AccountManageFacadeImpl implements AccountManageFacade {
    @Autowired
    private RegisterBiz registerBiz;

    @Override
    public RegisterResultDTO register(String mobileNo, String password) throws AccountManageBizException {
        return registerBiz.register(mobileNo, password);
    }

}
