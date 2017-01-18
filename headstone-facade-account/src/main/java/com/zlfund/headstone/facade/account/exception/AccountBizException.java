package com.zlfund.headstone.facade.account.exception;


import com.zlfund.headstone.common.exceptions.BizException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 账户服务业务异常类,异常代码8位数字组成,前4位固定2008打头,后4位自定义
 * 账户类异常在该类维护，便于统一管理。
 */
public class AccountBizException extends BizException {

    private static final long serialVersionUID = 1L;

    private static final Log log = LogFactory.getLog(AccountBizException.class);

    public static final AccountBizException ACCOUNT_NOT_EXIT = new AccountBizException(20080001, "账户不存在");

    public static final AccountBizException ACCOUNT_MOBILENO_EXIT = new AccountBizException(20080002, "该手机号码已注册");

    public static final AccountBizException ACCOUNTPWD_NOT_EXIT = new AccountBizException(20080006, "账户密码不存在");

    public static final AccountBizException ACCOUNT_STATUS_IS_INACTIVE = new AccountBizException(20080101, "账户状态不可用");

    public static final AccountBizException ACCOUNT_SMSAUTHCODE_ERROR = new AccountBizException(20080103, "短信验证码错误");

    public static final AccountBizException ACCOUNT_LOGINPWD_ERROR = new AccountBizException(20080103, "登录密码错误");

    public static final AccountBizException ACCOUNT_TRADEPWD_ERROR = new AccountBizException(20080104, "交易密码错误");

    public static final AccountBizException ACCOUNT_CREATE_FAILED = new AccountBizException(20080108, "创建账户失败");

    public static final AccountBizException ACCOUNT_TRADEPWD_ERROR_TIMES_OUTLIMIT = new AccountBizException(20080119, "交易密码错误次数超限");

    public static final AccountBizException ACCOUNTHISTORY_IS_EXIST = new AccountBizException(20080122, "账户历史记录已存在");

    public AccountBizException() {
    }

    public AccountBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }

    public AccountBizException(int code, String msg) {
        super(code, msg);
    }

    /**
     * 实例化异常
     *
     * @param msgFormat
     * @param args
     * @return
     */
    public AccountBizException newInstance(String msgFormat, Object... args) {
        return new AccountBizException(this.code, msgFormat, args);
    }


}
