package com.zlfund.headstone.facade.account.manage.dto;

import java.io.Serializable;

import com.zlfund.headstone.common.dto.BaseRequestDTO;

/**
 * 注册请求dto
 * @author Yang Xiaodong
 * @since: 2017年2月21日
 */
public class RegisterRequestDTO extends BaseRequestDTO implements Serializable {

    private static final long serialVersionUID = -4020639312188954726L;

    /**
     * 手机号码
     */
    private String mobileno;

    private String password;

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RegisterRequestDTO [mobileno=" + mobileno + ", password=" + password + "]";
    }

}
