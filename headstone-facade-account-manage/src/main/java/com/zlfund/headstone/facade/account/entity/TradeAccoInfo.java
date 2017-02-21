/**
 *
 */
package com.zlfund.headstone.facade.account.entity;

import com.zlfund.headstone.common.dto.BaseEntity;


/**
 * @author Administrator
 */
public class TradeAccoInfo extends BaseEntity {


    private static final long serialVersionUID = 1L;

    private String custno;
    private String tradeAcco;
    private String bankAcco;
    private String tradeAccoST;
    private String bankNo;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCustno() {
        return custno;
    }

    public void setCustno(String custno) {
        this.custno = custno;
    }

    public String getTradeAcco() {
        return tradeAcco;
    }

    public void setTradeAcco(String tradeAcco) {
        this.tradeAcco = tradeAcco;
    }

    public String getBankAcco() {
        return bankAcco;
    }

    public void setBankAcco(String bankAcco) {
        this.bankAcco = bankAcco;
    }

    public String getTradeAccoST() {
        return tradeAccoST;
    }

    public void setTradeAccoST(String tradeAccoST) {
        this.tradeAccoST = tradeAccoST;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }
}
