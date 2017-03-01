/**
 * @Title TradeRequestStatusPO.java 
 * @Package com.zlfund.headstone.core.dao.po 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月22日 上午10:20:49 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao.po;

import java.util.Date;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月22日 上午10:20:49 
 * @history:
 */
public class TradeRequestStatusPO {

    private String serialNo;

    private String priorNo;

    private String referNo;

    private int seqNo;

    private String custNo;

    private String applySt;

    private String transSt;

    private String paySt;

    private String summary;

    private String modifyFlag;

    private String payDt;

    private String payTm;

    private Date updateTimeStamp;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getPriorNo() {
        return priorNo;
    }

    public void setPriorNo(String priorNo) {
        this.priorNo = priorNo;
    }

    public String getReferNo() {
        return referNo;
    }

    public void setReferNo(String referNo) {
        this.referNo = referNo;
    }

    public int getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getApplySt() {
        return applySt;
    }

    public void setApplySt(String applySt) {
        this.applySt = applySt;
    }

    public String getTransSt() {
        return transSt;
    }

    public void setTransSt(String transSt) {
        this.transSt = transSt;
    }

    public String getPaySt() {
        return paySt;
    }

    public void setPaySt(String paySt) {
        this.paySt = paySt;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getModifyFlag() {
        return modifyFlag;
    }

    public void setModifyFlag(String modifyFlag) {
        this.modifyFlag = modifyFlag;
    }

    public String getPayDt() {
        return payDt;
    }

    public void setPayDt(String payDt) {
        this.payDt = payDt;
    }

    public String getPayTm() {
        return payTm;
    }

    public void setPayTm(String payTm) {
        this.payTm = payTm;
    }

    @Override
    public String toString() {
        return "TradeRequestStatusPO [serialNo=" + serialNo + ", priorNo=" + priorNo + ", referNo=" + referNo + ", seqNo=" + seqNo + ", custNo=" + custNo
                + ", applySt=" + applySt + ", transSt=" + transSt + ", paySt=" + paySt + ", summary=" + summary + ", modifyFlag=" + modifyFlag + ", payDt="
                + payDt + ", payTm=" + payTm + "]";
    }

    public Date getUpdateTimeStamp() {
        return updateTimeStamp;
    }

    public void setUpdateTimeStamp(Date updateTimeStamp) {
        this.updateTimeStamp = updateTimeStamp;
    }

}
