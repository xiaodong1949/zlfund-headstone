package com.zlfund.headstone.core.biz;

import org.springframework.transaction.annotation.Transactional;

import com.zlfund.headstone.facade.account.manage.dto.RegisterResultDTO;
import com.zlfund.headstone.facade.account.manage.exception.AccountManageBizException;

/**
 * 注册业务类逻辑实现
 * @author Yang Xiaodong
 * @since: 2017年2月21日
 */
public class RegisterBiz extends AccountManageBiz {

    /** 
     * @param mobileNo
     * @param password
     * @return
     * @return 
     * @create: 2017年2月21日
     * @author: Yang Xiaodong
     * @history: 
     */
    @Transactional(rollbackFor = Exception.class)
    public RegisterResultDTO register(String mobileNo, String password) throws AccountManageBizException {
        // TODO 参数校验
        validateParameter(mobileNo, password);
        // TODO 客户信息校验
        // TODO

        return null;
    }

}
