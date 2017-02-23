/**
 * @Title CustInfoPO.java 
 * @Package com.zlfund.headstone.core.dao.po 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月21日 下午7:06:28 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao.po;

/** 
 * CUSTINFO表PO
 * @author: 徐文凡 
 * @since: 2017年2月21日 下午7:06:28 
 * @history:
 */
public class CustInfoPO {

    private String custNo;

    private String invTp;

    private String invNm;

    private String idTp;

    private String idNo;

    private String mobileNo;

    private String email;

    private String custSt;

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getInvTp() {
        return invTp;
    }

    public void setInvTp(String invTp) {
        this.invTp = invTp;
    }

    public String getInvNm() {
        return invNm;
    }

    public void setInvNm(String invNm) {
        this.invNm = invNm;
    }

    public String getIdTp() {
        return idTp;
    }

    public void setIdTp(String idTp) {
        this.idTp = idTp;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustSt() {
        return custSt;
    }

    public void setCustSt(String custSt) {
        this.custSt = custSt;
    }

    @Override
    public String toString() {
        return "CustInfoPO [custNo=" + custNo + ", invTp=" + invTp + ", invNm=" + invNm + ", idTp=" + idTp + ", idNo=" + idNo + ", mobileNo=" + mobileNo
                + ", email=" + email + ", custSt=" + custSt + "]";
    }
}
