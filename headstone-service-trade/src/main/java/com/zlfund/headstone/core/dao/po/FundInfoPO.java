/**
 * @Title FundInfoPO.java 
 * @Package com.zlfund.headstone.core.dao.po 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月22日 下午1:19:24 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao.po;

import java.sql.Date;

/** 
 * FUNDINFO表PO
 * @author: 徐文凡 
 * @since: 2017年2月22日 下午1:19:24 
 * @history:
 */
public class FundInfoPO {
    private String fundId;

    private String fundNm;

    private String currencyType;

    private String fundSt;

    private String taNo;

    private Date insertTimeStamp;

    private Date updateTimeStamp;

    private String navDt;

    private double nav;

    private String shareType;

    private String shareClass;

    private double yield;

    private String companyNo;

    private String aipSt;

    private String convSt;

    private double fundIncome;

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public String getFundNm() {
        return fundNm;
    }

    public void setFundNm(String fundNm) {
        this.fundNm = fundNm;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public String getFundSt() {
        return fundSt;
    }

    public void setFundSt(String fundSt) {
        this.fundSt = fundSt;
    }

    public String getTaNo() {
        return taNo;
    }

    public void setTaNo(String taNo) {
        this.taNo = taNo;
    }

    public Date getInsertTimeStamp() {
        return insertTimeStamp;
    }

    public void setInsertTimeStamp(Date insertTimeStamp) {
        this.insertTimeStamp = insertTimeStamp;
    }

    public Date getUpdateTimeStamp() {
        return updateTimeStamp;
    }

    public void setUpdateTimeStamp(Date updateTimeStamp) {
        this.updateTimeStamp = updateTimeStamp;
    }

    public String getNavDt() {
        return navDt;
    }

    public void setNavDt(String navDt) {
        this.navDt = navDt;
    }

    public double getNav() {
        return nav;
    }

    public void setNav(double nav) {
        this.nav = nav;
    }

    public String getShareType() {
        return shareType;
    }

    public void setShareType(String shareType) {
        this.shareType = shareType;
    }

    public String getShareClass() {
        return shareClass;
    }

    public void setShareClass(String shareClass) {
        this.shareClass = shareClass;
    }

    public double getYield() {
        return yield;
    }

    public void setYield(double yield) {
        this.yield = yield;
    }

    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo;
    }

    public String getAipSt() {
        return aipSt;
    }

    public void setAipSt(String aipSt) {
        this.aipSt = aipSt;
    }

    public String getConvSt() {
        return convSt;
    }

    public void setConvSt(String convSt) {
        this.convSt = convSt;
    }

    public double getFundIncome() {
        return fundIncome;
    }

    public void setFundIncome(double fundIncome) {
        this.fundIncome = fundIncome;
    }

    @Override
    public String toString() {
        return "FundInfoPO [fundId=" + fundId + ", fundNm=" + fundNm + ", currencyType=" + currencyType + ", fundSt=" + fundSt + ", taNo=" + taNo
                + ", insertTimeStamp=" + insertTimeStamp + ", updateTimeStamp=" + updateTimeStamp + ", navDt=" + navDt + ", nav=" + nav + ", shareType="
                + shareType + ", shareClass=" + shareClass + ", yield=" + yield + ", companyNo=" + companyNo + ", aipSt=" + aipSt + ", convSt=" + convSt
                + ", fundIncome=" + fundIncome + "]";
    }

}
