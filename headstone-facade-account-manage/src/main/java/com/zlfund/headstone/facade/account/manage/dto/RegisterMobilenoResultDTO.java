package com.zlfund.headstone.facade.account.manage.dto;

import java.io.Serializable;

import com.zlfund.headstone.common.dto.BaseResultDTO;

/**
 * 用户注册请求对象
 * @author Yang Xiaodong
 * @since: 2017年2月21日
 */
public class RegisterMobilenoResultDTO extends BaseResultDTO implements Serializable {

    private static final long serialVersionUID = -8232006821804289735L;

    /**
     * 客户号
     */
    private String mctCustno;

    /**
     * session key
     */
    private String sessionKey;

    /**
     * 是否首次注册
     */
    private String mainFlag;

    public String getMctCustno() {
        return mctCustno;
    }

    public void setMctCustno(String mctCustno) {
        this.mctCustno = mctCustno;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getMainFlag() {
        return mainFlag;
    }

    public void setMainFlag(String mainFlag) {
        this.mainFlag = mainFlag;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "RegisterMobilenoResultDTO [mctCustno=" + mctCustno + ", sessionKey=" + sessionKey + ", mainFlag=" + mainFlag + ", isSuccess()=" + isSuccess()
                + ", getErrMsg()=" + getErrMsg() + ", getErrCode()=" + getErrCode() + ", getErrDetailMsg()=" + getErrDetailMsg() + "]";
    }


}
