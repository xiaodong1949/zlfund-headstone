package com.zlfund.headstone.facade.account.manage.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zlfund.headstone.core.biz.RegisterBiz;
import com.zlfund.headstone.facade.account.manage.dto.RegisterRequestDTO;
import com.zlfund.headstone.facade.account.manage.dto.RegisterResultDTO;
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
    public RegisterResultDTO registerByMobileno(RegisterRequestDTO registerRequestDTO) {
        // 注册前校验
        registerBiz.validation(registerRequestDTO);
        // 注册 (po)
        RegisterResultDTO registerResultDTO = registerBiz.registerByMobileno(registerRequestDTO);

        // TODO 刷新设备表
        // TODO 生成sessionkey
        // TODO 关联用户 返回mainflag（是否首次注册）
        // TODO 应用商店来源：如果用户当前没有来源信息，切接口调用传递了来源字段，那么更新用户信息
        // TODO 爱思记录--配置宝iOS
        return registerResultDTO;
    }
}
