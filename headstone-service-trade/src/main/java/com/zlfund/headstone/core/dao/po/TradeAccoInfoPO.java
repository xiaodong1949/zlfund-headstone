/**
 * @Title TradeAccoInfoPO.java 
 * @Package com.zlfund.headstone.core.dao.po 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月21日 下午4:59:20 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao.po;

import java.sql.Date;

/** 
 * TRADEACCOINFO表PO
 * @author: 徐文凡 
 * @since: 2017年2月21日 下午4:59:20 
 * @history:
 */
public class TradeAccoInfoPO {
    private String tradeAcco;

    private String custNo;

    private String mainFlag;

    private String tradeAccoSt;

    private String openDt;

    private String bankNo;

    private String bankAcco;

    private String bankAccoDisplay;

    private String bankIdTp;

    private String bankIdNo;

    private Date updateTimeStamp;

    private String bankProExists;

    private String protocolNo;

    private String inputAcctNo;

    private String subBankNo;

    private String netPoint;

    private String capitalMode;

    private String closeDt;

    private String mobileNo;

    private String partnerNo;

    private String accountType;

    private String pzbId;

    public String getTradeAcco() {
        return tradeAcco;
    }

    public void setTradeAcco(String tradeAcco) {
        this.tradeAcco = tradeAcco;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getMainFlag() {
        return mainFlag;
    }

    public void setMainFlag(String mainFlag) {
        this.mainFlag = mainFlag;
    }

    public String getTradeAccoSt() {
        return tradeAccoSt;
    }

    public void setTradeAccoSt(String tradeAccoSt) {
        this.tradeAccoSt = tradeAccoSt;
    }

    public String getOpenDt() {
        return openDt;
    }

    public void setOpenDt(String openDt) {
        this.openDt = openDt;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public String getBankAcco() {
        return bankAcco;
    }

    public void setBankAcco(String bankAcco) {
        this.bankAcco = bankAcco;
    }

    public String getBankAccoDisplay() {
        return bankAccoDisplay;
    }

    public void setBankAccoDisplay(String bankAccoDisplay) {
        this.bankAccoDisplay = bankAccoDisplay;
    }

    public String getBankIdTp() {
        return bankIdTp;
    }

    public void setBankIdTp(String bankIdTp) {
        this.bankIdTp = bankIdTp;
    }

    public String getBankIdNo() {
        return bankIdNo;
    }

    public void setBankIdNo(String bankIdNo) {
        this.bankIdNo = bankIdNo;
    }

    public Date getUpdateTimeStamp() {
        return updateTimeStamp;
    }

    public void setUpdateTimeStamp(Date updateTimeStamp) {
        this.updateTimeStamp = updateTimeStamp;
    }

    public String getBankProExists() {
        return bankProExists;
    }

    public void setBankProExists(String bankProExists) {
        this.bankProExists = bankProExists;
    }

    public String getProtocolNo() {
        return protocolNo;
    }

    public void setProtocolNo(String protocolNo) {
        this.protocolNo = protocolNo;
    }

    public String getInputAcctNo() {
        return inputAcctNo;
    }

    public void setInputAcctNo(String inputAcctNo) {
        this.inputAcctNo = inputAcctNo;
    }

    public String getSubBankNo() {
        return subBankNo;
    }

    public void setSubBankNo(String subBankNo) {
        this.subBankNo = subBankNo;
    }

    public String getNetPoint() {
        return netPoint;
    }

    public void setNetPoint(String netPoint) {
        this.netPoint = netPoint;
    }

    public String getCapitalMode() {
        return capitalMode;
    }

    public void setCapitalMode(String capitalMode) {
        this.capitalMode = capitalMode;
    }

    public String getCloseDt() {
        return closeDt;
    }

    public void setCloseDt(String closeDt) {
        this.closeDt = closeDt;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPartnerNo() {
        return partnerNo;
    }

    public void setPartnerNo(String partnerNo) {
        this.partnerNo = partnerNo;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getPzbId() {
        return pzbId;
    }

    public void setPzbId(String pzbId) {
        this.pzbId = pzbId;
    }

    @Override
    public String toString() {
        return "TradeAccoInfoPO [tradeAcco=" + tradeAcco + ", custNo=" + custNo + ", mainFlag=" + mainFlag + ", tradeAccoSt=" + tradeAccoSt + ", openDt="
                + openDt + ", bankNo=" + bankNo + ", bankAcco=" + bankAcco + ", bankAccoDisplay=" + bankAccoDisplay + ", bankIdTp=" + bankIdTp + ", bankIdNo="
                + bankIdNo + ", updateTimeStamp=" + updateTimeStamp + ", bankProExists=" + bankProExists + ", protocolNo=" + protocolNo + ", inputAcctNo="
                + inputAcctNo + ", subBankNo=" + subBankNo + ", netPoint=" + netPoint + ", capitalMode=" + capitalMode + ", closeDt=" + closeDt + ", mobileNo="
                + mobileNo + ", partnerNo=" + partnerNo + ", accountType=" + accountType + ", pzbId=" + pzbId + "]";
    }
}
