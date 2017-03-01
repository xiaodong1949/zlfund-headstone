package com.zlfund.headstone.core.dao.po;

import java.util.Date;

/**
 * @Title TradeRequestDO.java 
 * @Package com.zlfund.headstone.core.dataobject 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月21日 上午10:37:13 
 * @version V1.0   
 */

/** 
 * TRADEREQUEST表PO
 * 
 * @author: 徐文凡 
 * @since: 2017年2月21日 上午10:37:13 
 * @history:
 */
public class TradeRequestPO {

    private String serialNo;

    private String custNo;

    private String tradeAcco;

    private String apKind;

    private String fundId;

    private double subQuty = 0.00;

    private double subAmt = 0.00;

    private String apDt;

    private String apTm;

    private String remark;

    private Date updateTimeStamp;

    private String workDate;

    private String spanFlag;

    private String cashFrom;

    private double subrAmt;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getTradeAcco() {
        return tradeAcco;
    }

    public void setTradeAcco(String tradeAcco) {
        this.tradeAcco = tradeAcco;
    }

    public String getApKind() {
        return apKind;
    }

    public void setApKind(String apKind) {
        this.apKind = apKind;
    }

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public double getSubQuty() {
        return subQuty;
    }

    public void setSubQuty(double subQuty) {
        this.subQuty = subQuty;
    }

    public double getSubAmt() {
        return subAmt;
    }

    public void setSubAmt(double subAmt) {
        this.subAmt = subAmt;
    }

    public String getApDt() {
        return apDt;
    }

    public void setApDt(String apDt) {
        this.apDt = apDt;
    }

    public String getApTm() {
        return apTm;
    }

    public void setApTm(String apTm) {
        this.apTm = apTm;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getUpdateTimeStamp() {
        return updateTimeStamp;
    }

    public void setUpdateTimeStamp(Date updateTimeStamp) {
        this.updateTimeStamp = updateTimeStamp;
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public String getSpanFlag() {
        return spanFlag;
    }

    public void setSpanFlag(String spanFlag) {
        this.spanFlag = spanFlag;
    }

    public String getCashFrom() {
        return cashFrom;
    }

    public void setCashFrom(String cashFrom) {
        this.cashFrom = cashFrom;
    }

    public double getSubrAmt() {
        return subrAmt;
    }

    public void setSubrAmt(double subrAmt) {
        this.subrAmt = subrAmt;
    }

    @Override
    public String toString() {
        return "TradeRequestPO [serialNo=" + serialNo + ", custNo=" + custNo + ", tradeAcco=" + tradeAcco + ", apKind=" + apKind + ", fundId=" + fundId
                + ", subQuty=" + subQuty + ", subAmt=" + subAmt + ", apDt=" + apDt + ", apTm=" + apTm + ", remark=" + remark + ", updateTimeStamp="
                + updateTimeStamp + ", workDate=" + workDate + ", spanFlag=" + spanFlag + ", cashFrom=" + cashFrom + ", subrAmt=" + subrAmt + "]";
    }
}
