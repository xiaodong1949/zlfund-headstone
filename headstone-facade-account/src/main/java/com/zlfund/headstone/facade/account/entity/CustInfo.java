/**
 *
 */
package com.zlfund.headstone.facade.account.entity;

import com.zlfund.headstone.common.entity.BaseEntity;

import java.util.Date;
import java.util.List;


/**
 * @author Administrator
 */
public class CustInfo extends BaseEntity {


    private static final long serialVersionUID = 1L;

    private String custno;
    private String invnm;
    private String idno;
    private String mobileno;
    private String custst;
    private String mobileverifist;

    private String loginPWD;

    private Date insertTimestamp;
    private Date updateTimestamp;

    private List<TradeAccoInfo> tradeAccoInfoList;

    public String getCustno() {
        return custno;
    }

    public void setCustno(String custno) {
        this.custno = custno;
    }

    public String getInvnm() {
        return invnm;
    }

    public void setInvnm(String invnm) {
        this.invnm = invnm;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getCustst() {
        return custst;
    }

    public void setCustst(String custst) {
        this.custst = custst;
    }

    public String getMobileverifist() {
        return mobileverifist;
    }

    public void setMobileverifist(String mobileverifist) {
        this.mobileverifist = mobileverifist;
    }

    public List<TradeAccoInfo> getTradeAccoInfoList() {
        return tradeAccoInfoList;
    }

    public void setTradeAccoInfoList(List<TradeAccoInfo> tradeAccoInfoList) {
        this.tradeAccoInfoList = tradeAccoInfoList;
    }

    public String getLoginPWD() {
        return loginPWD;
    }

    public void setLoginPWD(String loginPWD) {
        this.loginPWD = loginPWD;
    }

    public Date getInsertTimestamp() {
        return insertTimestamp;
    }

    public void setInsertTimestamp(Date insertTimestamp) {
        this.insertTimestamp = insertTimestamp;
    }

    public Date getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Date updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    @Override
    public String toString() {
        return "CustInfo{" +
                "custno='" + custno + '\'' +
                ", invnm='" + invnm + '\'' +
                ", idno='" + idno + '\'' +
                ", mobileno='" + mobileno + '\'' +
                ", custst='" + custst + '\'' +
                ", mobileverifist='" + mobileverifist + '\'' +
                ", loginPWD='" + loginPWD + '\'' +
                ", insertTimestamp=" + insertTimestamp +
                ", updateTimestamp=" + updateTimestamp +
                ", tradeAccoInfoList=" + tradeAccoInfoList +
                '}';
    }
}
