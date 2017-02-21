package com.zlfund.headstone.core.biz;

import com.zlfund.headstone.common.utils.StringUtils;
import com.zlfund.headstone.facade.account.manage.exception.AccountManageBizException;

/**
 * Biz 父类
 * @author Yang Xiaodong
 * @since: 2017年2月21日
 */
public class AccountManageBiz {

    /** 
     * 参数非空验证
     * @param objects
     * @return 
     * @create: 2017年2月21日
     * @author: Yang Xiaodong
     * @history: 
     */
    protected void validateParameter(Object... objects) {
        for (Object obj : objects) {
            if (obj instanceof String) {
                if (StringUtils.isBlank(String.valueOf(obj))) {
                    throw AccountManageBizException.ACCOUNT_PARAM_BLANK;
                }
            } else if (null == obj) {
                throw AccountManageBizException.ACCOUNT_PARAM_BLANK;
            }
        }
    }
}
