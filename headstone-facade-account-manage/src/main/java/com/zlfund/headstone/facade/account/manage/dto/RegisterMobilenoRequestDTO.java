package com.zlfund.headstone.facade.account.manage.dto;

import java.io.Serializable;

import com.zlfund.headstone.common.dto.BaseRequestDTO;
import com.zlfund.headstone.common.utils.StringUtils;

/**
 * 注册请求dto
 * @author Yang Xiaodong
 * @since: 2017年2月21日
 */
public class RegisterMobilenoRequestDTO extends BaseRequestDTO implements Serializable {

    private static final long serialVersionUID = -4020639312188954726L;

    /**
     * 客户ID
     */
    private String custNo;

    /**
     * 手机号码
     */
    private String mobileNo;

    /**
     * 密码
     */
    private String password;

    /**
     * 渠道编号
     */
    private String mctCode;

    /**
     * 流水号
     */
    private String serialno;

    /**
     * 投资人类型
     */
    private String invtp;

    /**
     * 开户真实姓名
     */
    private String invnm;

    /**
     * 开户证件类型
     */
    private String idtp;

    /**
     * 开户证件号码
     */
    private String idno;

    private String email;

    /**
     *  对账单寄送方式
     */
    private String deliverway;

    /**
     * 资金密码
     */
    private String cappassword;

    /**
    * 推广员代码
    */
    private String spread_code;

    /**
     *   地推员代码
     */
    private String promo_code;

    /**
    * 手机验证状态
    */
    private String mobileverifist;

    /**
     * 商户号
     */
    private String mctcode;

    /**
     * 是否本人
     */
    private String isself;

    /**
     * @return the serialno
     */
    public String getSerialno() {
        return serialno;
    }

    /**
     * @param serialno the serialno to set
     */
    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    /**
     * @return the invtp
     */
    public String getInvtp() {
        return invtp;
    }

    /**
     * @param invtp the invtp to set
     */
    public void setInvtp(String invtp) {
        this.invtp = invtp;
    }

    /**
     * @return the invnm
     */
    public String getInvnm() {
        return invnm;
    }

    /**
     * @param invnm the invnm to set
     */
    public void setInvnm(String invnm) {
        this.invnm = invnm;
    }

    /**
     * @return the idtp
     */
    public String getIdtp() {
        return idtp;
    }

    /**
     * @param idtp the idtp to set
     */
    public void setIdtp(String idtp) {
        this.idtp = idtp;
    }

    /**
     * @return the idno
     */
    public String getIdno() {
        return idno;
    }

    /**
     * @param idno the idno to set
     */
    public void setIdno(String idno) {
        this.idno = idno;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the deliverway
     */
    public String getDeliverway() {
        return deliverway;
    }

    /**
     * @param deliverway the deliverway to set
     */
    public void setDeliverway(String deliverway) {
        this.deliverway = deliverway;
    }

    /**
     * @return the cappassword
     */
    public String getCappassword() {
        return cappassword;
    }

    /**
     * @param cappassword the cappassword to set
     */
    public void setCappassword(String cappassword) {
        this.cappassword = cappassword;
    }

    /**
     * @return the spread_code
     */
    public String getSpread_code() {
        return spread_code;
    }

    /**
     * @param spread_code the spread_code to set
     */
    public void setSpread_code(String spread_code) {
        this.spread_code = spread_code;
    }

    /**
     * @return the promo_code
     */
    public String getPromo_code() {
        return promo_code;
    }

    /**
     * @param promo_code the promo_code to set
     */
    public void setPromo_code(String promo_code) {
        this.promo_code = promo_code;
    }

    /**
     * @return the mobileverifist
     */
    public String getMobileverifist() {
        return mobileverifist;
    }

    /**
     * @param mobileverifist the mobileverifist to set
     */
    public void setMobileverifist(String mobileverifist) {
        this.mobileverifist = mobileverifist;
    }

    /**
     * @return the mctcode
     */
    public String getMctcode() {
        return mctcode;
    }

    /**
     * @param mctcode the mctcode to set
     */
    public void setMctcode(String mctcode) {
        this.mctcode = mctcode;
    }

    /**
     * @return the isself
     */
    public String getIsself() {
        return isself;
    }

    /**
     * @param isself the isself to set
     */
    public void setIsself(String isself) {
        this.isself = isself;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMctCode() {
        return mctCode;
    }

    public void setMctCode(String mctCode) {
        this.mctCode = mctCode;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "RegisterRequestDTO [mobileNo=" + mobileNo + ", password=" + (StringUtils.isBlank(password) ? password : "xxxxxx") + ", mctCode=" + mctCode
                + "]";
    }

}
