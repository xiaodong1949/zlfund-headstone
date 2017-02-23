package com.zlfund.headstone.core.dao.po;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The persistent class for the custrisklevel database table.
 * 
 */
public class CustRiskLevelPO extends AccountManageBasePO implements Serializable {

    private static final long serialVersionUID = -8255794497165896209L;

    private String custno;

    private String channelcode;

    private String evaldate;

    private String evalformno;

    private String evaltime;

    private String evaltype;

    private String risklevel;

    private BigDecimal score;

    private String status;

    private String terminalinfo;

    private String fundtype;

    /**
     * @return the custno
     */
    public String getCustno() {
        return custno;
    }

    /**
     * @param custno the custno to set
     */
    public void setCustno(String custno) {
        this.custno = custno;
    }

    /**
     * @return the channelcode
     */
    public String getChannelcode() {
        return channelcode;
    }

    /**
     * @param channelcode the channelcode to set
     */
    public void setChannelcode(String channelcode) {
        this.channelcode = channelcode;
    }

    /**
     * @return the evaldate
     */
    public String getEvaldate() {
        return evaldate;
    }

    /**
     * @param evaldate the evaldate to set
     */
    public void setEvaldate(String evaldate) {
        this.evaldate = evaldate;
    }

    /**
     * @return the evalformno
     */
    public String getEvalformno() {
        return evalformno;
    }

    /**
     * @param evalformno the evalformno to set
     */
    public void setEvalformno(String evalformno) {
        this.evalformno = evalformno;
    }

    /**
     * @return the evaltime
     */
    public String getEvaltime() {
        return evaltime;
    }

    /**
     * @param evaltime the evaltime to set
     */
    public void setEvaltime(String evaltime) {
        this.evaltime = evaltime;
    }

    /**
     * @return the evaltype
     */
    public String getEvaltype() {
        return evaltype;
    }

    /**
     * @param evaltype the evaltype to set
     */
    public void setEvaltype(String evaltype) {
        this.evaltype = evaltype;
    }

    /**
     * @return the risklevel
     */
    public String getRisklevel() {
        return risklevel;
    }

    /**
     * @param risklevel the risklevel to set
     */
    public void setRisklevel(String risklevel) {
        this.risklevel = risklevel;
    }

    /**
     * @return the score
     */
    public BigDecimal getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(BigDecimal score) {
        this.score = score;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the terminalinfo
     */
    public String getTerminalinfo() {
        return terminalinfo;
    }

    /**
     * @param terminalinfo the terminalinfo to set
     */
    public void setTerminalinfo(String terminalinfo) {
        this.terminalinfo = terminalinfo;
    }

    /**
     * @return the fundtype
     */
    public String getFundtype() {
        return fundtype;
    }

    /**
     * @param fundtype the fundtype to set
     */
    public void setFundtype(String fundtype) {
        this.fundtype = fundtype;
    }

}