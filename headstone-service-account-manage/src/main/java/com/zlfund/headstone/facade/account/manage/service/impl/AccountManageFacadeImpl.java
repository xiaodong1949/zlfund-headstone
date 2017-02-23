package com.zlfund.headstone.facade.account.manage.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zlfund.headstone.core.biz.RegisterBiz;
import com.zlfund.headstone.facade.account.manage.dto.RegisterMobilenoRequestDTO;
import com.zlfund.headstone.facade.account.manage.dto.RegisterMobilenoResultDTO;
import com.zlfund.headstone.facade.account.manage.service.AccountManageFacade;

/**
 * 帐户管理实现
 * @author Yang Xiaodong
 * @since: 2017年2月21日
 */
@Component("accountManageFacade")
public class AccountManageFacadeImpl implements AccountManageFacade {
    private static final Log log = LogFactory.getLog(AccountManageFacadeImpl.class);

    @Autowired
    private RegisterBiz registerBiz;

    /*
     * (non-Javadoc)
     * 
     * @see com.zlfund.headstone.facade.account.manage.service.AccountManageFacade#register(com.zlfund.headstone.facade.
     * account.manage.dto.RegisterRequestDTO)
     */
    @Override
    public RegisterMobilenoResultDTO registerByMobileno(RegisterMobilenoRequestDTO registerRequestDTO) {
        // 注册前校验
        registerBiz.validation(registerRequestDTO);
        // 注册 (po)
        RegisterMobilenoResultDTO registerResultDTO = (RegisterMobilenoResultDTO)registerBiz.execute(registerRequestDTO);

        // TODO 生成sessionkey
        return registerResultDTO;
    }
}
