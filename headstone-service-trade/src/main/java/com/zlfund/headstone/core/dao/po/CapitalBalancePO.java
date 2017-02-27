package com.zlfund.headstone.core.dao.po;

import java.util.Date;

public class CapitalBalancePO {

    private String tradeAcco;

    private String custNo;

    private double balance;

    private double abnmFrozen;

    private String lastDate;

    private Date updateTimeStamp;

    private String transferStatus;

    private double returnBalance;

    private String soaDate;

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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAbnmFrozen() {
        return abnmFrozen;
    }

    public void setAbnmFrozen(double abnmFrozen) {
        this.abnmFrozen = abnmFrozen;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    public Date getUpdateTimeStamp() {
        return updateTimeStamp;
    }

    public void setUpdateTimeStamp(Date updateTimeStamp) {
        this.updateTimeStamp = updateTimeStamp;
    }

    public String getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }

    public String getSoaDate() {
        return soaDate;
    }

    public void setSoaDate(String soaDate) {
        this.soaDate = soaDate;
    }

    @Override
    public String toString() {
        return "CapitalBalancePO [tradeAcco=" + tradeAcco + ", custNo=" + custNo + ", balance=" + balance + ", abnmFrozen=" + abnmFrozen + ", lastDate="
                + lastDate + ", updateTimeStamp=" + updateTimeStamp + ", transferStatus=" + transferStatus + ", returnBalance=" + returnBalance + ", soaDate="
                + soaDate + "]";
    }

    public double getReturnBalance() {
        return returnBalance;
    }

    public void setReturnBalance(double returnBalance) {
        this.returnBalance = returnBalance;
    }

}
