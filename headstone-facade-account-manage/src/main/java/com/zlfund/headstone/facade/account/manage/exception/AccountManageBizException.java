package com.zlfund.headstone.facade.account.manage.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zlfund.headstone.common.exceptions.BizException;

/**
 * 帐户管理异常处理（100x）
 * 注册异常：1001xxxx
 * @author Yang Xiaodong
 * @since: 2017年2月21日
 */
public class AccountManageBizException extends BizException {

    private static final long serialVersionUID = 3962309428183055029L;

    @SuppressWarnings("unused")
    private static final Log log = LogFactory.getLog(AccountManageBizException.class);

    public static final AccountManageBizException ACCOUNT_NOT_EXIT = new AccountManageBizException(10010001, "账户不存在");

    public static final AccountManageBizException ACCOUNT_NOT_FROM_ZLFUND = new AccountManageBizException(10010002, "非众禄渠道不能使用手机号码注册");

    public static final AccountManageBizException ACCOUNT_ALREADY_REGISTERED = new AccountManageBizException(10010003, "该手机号码已经注册，请直接登录");

    public static final AccountManageBizException ACCOUNT_PARAM_BLANK = new AccountManageBizException(10019999, "参数不能为空");

    protected AccountManageBizException() {
    }

    protected AccountManageBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }

    protected AccountManageBizException(int code, String msg) {
        super(code, msg);
    }

}
