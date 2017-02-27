package com.zlfund.headstone.facade.account.manage.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zlfund.headstone.core.biz.RegisterBiz;
import com.zlfund.headstone.facade.account.manage.dto.RegisterMobilenoRequestDTO;
import com.zlfund.headstone.facade.account.manage.dto.RegisterMobilenoResultDTO;
import com.zlfund.headstone.facade.account.manage.service.AccountManageFacade;
import com.zlfund.headstone.util.AccountManageUtil;

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

        AccountManageUtil.logDebug(log, "execute……");
        // 注册 (po)
        registerBiz.checkRequestDTO(registerRequestDTO);
        // 业务处理，一般配置事务
        RegisterMobilenoResultDTO registerResultDTO = registerBiz.doBiz(registerRequestDTO);

        AccountManageUtil.logDebug(log, "return obj:" + registerResultDTO);
        registerResultDTO.setSuccess(true);
        return registerResultDTO;
    }
}
