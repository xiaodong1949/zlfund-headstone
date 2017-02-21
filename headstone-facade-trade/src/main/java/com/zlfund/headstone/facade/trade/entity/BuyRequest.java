/**
 * @Title BuyRequest.java 
 * @Package com.zlfund.headstone.facade.trade.entity 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月20日 下午5:06:39 
 * @version V1.0   
 */
package com.zlfund.headstone.facade.trade.entity;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月20日 下午5:06:39 
 * @history:
 */
public class BuyRequest extends BaseRequest {

    private static final long serialVersionUID = 1L;

    // 业务流水号
    private String serialNo;

    // 客户号
    private String custNo;

    // 交易账号
    private String tradeAcco;

    // 产品代码
    private String fundId;

    // 申请金额
    private double subAmt;

    // 扣款类型 0-不重用撤单资金 1-重用撤单资金
    private char bidTp;

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

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public double getSubAmt() {
        return subAmt;
    }

    public void setSubAmt(double subAmt) {
        this.subAmt = subAmt;
    }

    public char getBidTp() {
        return bidTp;
    }

    public void setBidTp(char bidTp) {
        this.bidTp = bidTp;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    @Override
    public String toString() {
        return "BuyRequest [serialNo=" + serialNo + ", custNo=" + custNo + ", tradeAcco=" + tradeAcco + ", fundId="
                + fundId + ", subAmt=" + subAmt + ", bidTp=" + bidTp + "]";
    }
}
