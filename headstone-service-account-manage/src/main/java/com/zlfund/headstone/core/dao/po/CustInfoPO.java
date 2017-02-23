package com.zlfund.headstone.core.dao.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * DB:trade
 * table ： custinfo
 * @author Yang Xiaodong
 * @since: 2017年2月21日
 */
public class CustInfoPO implements Serializable {

    private static final long serialVersionUID = 5059904617385607483L;

    private String custno;

    private String cappasswd;

    private String custst;

    private String email;

    private Timestamp flogintime;

    private String idno;

    private String idtp;

    private Timestamp inserttimestamp;

    private String invnm;

    private String invtp;

    private BigDecimal logincount;

    private Timestamp logintime;

    private String mobileno;

    private String mobileverifist;

    private BigDecimal npasswderr;

    private String opendt;

    private String passwd;

    private BigDecimal passwderr;

    private String pwdchdt;

    private String resetflag;

    private Timestamp tradeftime;

    private Integer tradenpasswderr;

    private String tradepasswd;

    private Integer tradepasswderr;

    private String tradepwdchdt;

    private Timestamp updatetimestamp;

    private String mctcode;

    /**
     * @return the custno
     */
    public String getCustno() {
        return custno;
    }

    /**
     * @param custno the custno to set
     */
    public void setCustno(String custno) {
        this.custno = custno;
    }

    /**
     * @return the cappasswd
     */
    public String getCappasswd() {
        return cappasswd;
    }

    /**
     * @param cappasswd the cappasswd to set
     */
    public void setCappasswd(String cappasswd) {
        this.cappasswd = cappasswd;
    }

    /**
     * @return the custst
     */
    public String getCustst() {
        return custst;
    }

    /**
     * @param custst the custst to set
     */
    public void setCustst(String custst) {
        this.custst = custst;
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
     * @return the flogintime
     */
    public Timestamp getFlogintime() {
        return flogintime;
    }

    /**
     * @param flogintime the flogintime to set
     */
    public void setFlogintime(Timestamp flogintime) {
        this.flogintime = flogintime;
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
     * @return the inserttimestamp
     */
    public Timestamp getInserttimestamp() {
        return inserttimestamp;
    }

    /**
     * @param inserttimestamp the inserttimestamp to set
     */
    public void setInserttimestamp(Timestamp inserttimestamp) {
        this.inserttimestamp = inserttimestamp;
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
     * @return the logincount
     */
    public BigDecimal getLogincount() {
        return logincount;
    }

    /**
     * @param logincount the logincount to set
     */
    public void setLogincount(BigDecimal logincount) {
        this.logincount = logincount;
    }

    /**
     * @return the logintime
     */
    public Timestamp getLogintime() {
        return logintime;
    }

    /**
     * @param logintime the logintime to set
     */
    public void setLogintime(Timestamp logintime) {
        this.logintime = logintime;
    }

    /**
     * @return the mobileno
     */
    public String getMobileno() {
        return mobileno;
    }

    /**
     * @param mobileno the mobileno to set
     */
    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
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
     * @return the npasswderr
     */
    public BigDecimal getNpasswderr() {
        return npasswderr;
    }

    /**
     * @param npasswderr the npasswderr to set
     */
    public void setNpasswderr(BigDecimal npasswderr) {
        this.npasswderr = npasswderr;
    }

    /**
     * @return the opendt
     */
    public String getOpendt() {
        return opendt;
    }

    /**
     * @param opendt the opendt to set
     */
    public void setOpendt(String opendt) {
        this.opendt = opendt;
    }

    /**
     * @return the passwd
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * @param passwd the passwd to set
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     * @return the passwderr
     */
    public BigDecimal getPasswderr() {
        return passwderr;
    }

    /**
     * @param passwderr the passwderr to set
     */
    public void setPasswderr(BigDecimal passwderr) {
        this.passwderr = passwderr;
    }

    /**
     * @return the pwdchdt
     */
    public String getPwdchdt() {
        return pwdchdt;
    }

    /**
     * @param pwdchdt the pwdchdt to set
     */
    public void setPwdchdt(String pwdchdt) {
        this.pwdchdt = pwdchdt;
    }

    /**
     * @return the resetflag
     */
    public String getResetflag() {
        return resetflag;
    }

    /**
     * @param resetflag the resetflag to set
     */
    public void setResetflag(String resetflag) {
        this.resetflag = resetflag;
    }

    /**
     * @return the tradeftime
     */
    public Timestamp getTradeftime() {
        return tradeftime;
    }

    /**
     * @param tradeftime the tradeftime to set
     */
    public void setTradeftime(Timestamp tradeftime) {
        this.tradeftime = tradeftime;
    }

    /**
     * @return the tradenpasswderr
     */
    public Integer getTradenpasswderr() {
        return tradenpasswderr;
    }

    /**
     * @param tradenpasswderr the tradenpasswderr to set
     */
    public void setTradenpasswderr(Integer tradenpasswderr) {
        this.tradenpasswderr = tradenpasswderr;
    }

    /**
     * @return the tradepasswd
     */
    public String getTradepasswd() {
        return tradepasswd;
    }

    /**
     * @param tradepasswd the tradepasswd to set
     */
    public void setTradepasswd(String tradepasswd) {
        this.tradepasswd = tradepasswd;
    }

    /**
     * @return the tradepasswderr
     */
    public Integer getTradepasswderr() {
        return tradepasswderr;
    }

    /**
     * @param tradepasswderr the tradepasswderr to set
     */
    public void setTradepasswderr(Integer tradepasswderr) {
        this.tradepasswderr = tradepasswderr;
    }

    /**
     * @return the tradepwdchdt
     */
    public String getTradepwdchdt() {
        return tradepwdchdt;
    }

    /**
     * @param tradepwdchdt the tradepwdchdt to set
     */
    public void setTradepwdchdt(String tradepwdchdt) {
        this.tradepwdchdt = tradepwdchdt;
    }

    /**
     * @return the updatetimestamp
     */
    public Timestamp getUpdatetimestamp() {
        return updatetimestamp;
    }

    /**
     * @param updatetimestamp the updatetimestamp to set
     */
    public void setUpdatetimestamp(Timestamp updatetimestamp) {
        this.updatetimestamp = updatetimestamp;
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


}
