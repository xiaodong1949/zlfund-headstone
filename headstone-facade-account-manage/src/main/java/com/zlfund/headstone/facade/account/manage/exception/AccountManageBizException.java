package com.zlfund.headstone.facade.account.manage.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zlfund.headstone.common.exceptions.BizException;

/**
 * 帐户管理异常处理（100x）
 * 注册异常：1001
 * @author Yang Xiaodong
 * @since: 2017年2月21日
 */
public class AccountManageBizException extends BizException {

    private static final long serialVersionUID = 3962309428183055029L;

    private static final Log log = LogFactory.getLog(AccountManageBizException.class);

    public static final AccountManageBizException ACCOUNT_NOT_EXIT = new AccountManageBizException(20080001, "账户不存在");

    public static final AccountManageBizException ACCOUNT_MOBILENO_EXIT = new AccountManageBizException(20080002, "该手机号码已注册");

    public static final AccountManageBizException ACCOUNTPWD_NOT_EXIT = new AccountManageBizException(20080006, "账户密码不存在");

    public static final AccountManageBizException ACCOUNT_STATUS_IS_INACTIVE = new AccountManageBizException(20080101, "账户状态不可用");

    public static final AccountManageBizException ACCOUNT_SMSAUTHCODE_ERROR = new AccountManageBizException(20080103, "短信验证码错误");

    public static final AccountManageBizException ACCOUNT_LOGINPWD_ERROR = new AccountManageBizException(20080103, "登录密码错误");

    public static final AccountManageBizException ACCOUNT_TRADEPWD_ERROR = new AccountManageBizException(20080104, "交易密码错误");

    public static final AccountManageBizException ACCOUNT_CREATE_FAILED = new AccountManageBizException(20080108, "创建账户失败");

    public static final AccountManageBizException ACCOUNT_TRADEPWD_ERROR_TIMES_OUTLIMIT = new AccountManageBizException(20080119, "交易密码错误次数超限");

    public static final AccountManageBizException ACCOUNTHISTORY_IS_EXIST = new AccountManageBizException(20080122, "账户历史记录已存在");

    protected AccountManageBizException() {
    }

    protected AccountManageBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }

    protected AccountManageBizException(int code, String msg) {
        super(code, msg);
    }

}
