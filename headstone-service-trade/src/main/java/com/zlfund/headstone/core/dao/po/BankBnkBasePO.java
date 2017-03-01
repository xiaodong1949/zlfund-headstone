/**
 * @Title BankBnkBase.java 
 * @Package com.zlfund.headstone.core.dao.po 
 * @Description 
 * @author 徐文凡
 * @date 2017年3月1日 上午10:21:26 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao.po;

/** 
 * BANK_BNKBASE
 * @author: 徐文凡 
 * @since: 2017年3月1日 上午10:21:26 
 * @history:
 */
public class BankBnkBasePO {

    private String bnkNo;

    private String bnkNm;

    private String webSite;

    private String ebnkUrl;

    private String bTradeDate;

    private String eTradeDate;

    private String tradeStatus;

    private String bankId;

    public String getBnkNo() {
        return bnkNo;
    }

    public void setBnkNo(String bnkNo) {
        this.bnkNo = bnkNo;
    }

    public String getBnkNm() {
        return bnkNm;
    }

    public void setBnkNm(String bnkNm) {
        this.bnkNm = bnkNm;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getEbnkUrl() {
        return ebnkUrl;
    }

    public void setEbnkUrl(String ebnkUrl) {
        this.ebnkUrl = ebnkUrl;
    }

    public String getbTradeDate() {
        return bTradeDate;
    }

    public void setbTradeDate(String bTradeDate) {
        this.bTradeDate = bTradeDate;
    }

    public String geteTradeDate() {
        return eTradeDate;
    }

    public void seteTradeDate(String eTradeDate) {
        this.eTradeDate = eTradeDate;
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    @Override
    public String toString() {
        return "BankBnkBase [bnkNo=" + bnkNo + ", bnkNm=" + bnkNm + ", webSite=" + webSite + ", ebnkUrl=" + ebnkUrl + ", bTradeDate=" + bTradeDate
                + ", eTradeDate=" + eTradeDate + ", tradeStatus=" + tradeStatus + ", bankId=" + bankId + "]";
    }

}
