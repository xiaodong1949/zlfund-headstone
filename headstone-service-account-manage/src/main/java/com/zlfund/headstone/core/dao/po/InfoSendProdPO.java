package com.zlfund.headstone.core.dao.po;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * The persistent class for the infosendprod database table.
 * 
 */
public class InfoSendProdPO extends AccountManageBasePO implements Serializable {

    private static final long serialVersionUID = 6491758299024207257L;

    private String custno;

    private String openprocd;

    private String opendetailcd;

    private String mailflg;

    private String mailfrequency;

    private String msgflg;

    private String msgfrequency;

    private String postflg;

    private String postfrequency;

    private Timestamp updatetimestamp;

    private String usestat;

    public InfoSendProdPO(String custno) {
        this.custno = custno;
        this.openprocd = "00";
        this.opendetailcd = "0001";
        this.msgflg = "N";
        this.msgfrequency = "1";
        this.mailflg = "N";
        this.mailfrequency = "1";
        this.postflg = "N";
        this.postfrequency = "1";
        this.usestat = "U";

    }

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
     * @return the openprocd
     */
    public String getOpenprocd() {
        return openprocd;
    }

    /**
     * @param openprocd the openprocd to set
     */
    public void setOpenprocd(String openprocd) {
        this.openprocd = openprocd;
    }

    /**
     * @return the opendetailcd
     */
    public String getOpendetailcd() {
        return opendetailcd;
    }

    /**
     * @param opendetailcd the opendetailcd to set
     */
    public void setOpendetailcd(String opendetailcd) {
        this.opendetailcd = opendetailcd;
    }

    /**
     * @return the mailflg
     */
    public String getMailflg() {
        return mailflg;
    }

    /**
     * @param mailflg the mailflg to set
     */
    public void setMailflg(String mailflg) {
        this.mailflg = mailflg;
    }

    /**
     * @return the mailfrequency
     */
    public String getMailfrequency() {
        return mailfrequency;
    }

    /**
     * @param mailfrequency the mailfrequency to set
     */
    public void setMailfrequency(String mailfrequency) {
        this.mailfrequency = mailfrequency;
    }

    /**
     * @return the msgflg
     */
    public String getMsgflg() {
        return msgflg;
    }

    /**
     * @param msgflg the msgflg to set
     */
    public void setMsgflg(String msgflg) {
        this.msgflg = msgflg;
    }

    /**
     * @return the msgfrequency
     */
    public String getMsgfrequency() {
        return msgfrequency;
    }

    /**
     * @param msgfrequency the msgfrequency to set
     */
    public void setMsgfrequency(String msgfrequency) {
        this.msgfrequency = msgfrequency;
    }

    /**
     * @return the postflg
     */
    public String getPostflg() {
        return postflg;
    }

    /**
     * @param postflg the postflg to set
     */
    public void setPostflg(String postflg) {
        this.postflg = postflg;
    }

    /**
     * @return the postfrequency
     */
    public String getPostfrequency() {
        return postfrequency;
    }

    /**
     * @param postfrequency the postfrequency to set
     */
    public void setPostfrequency(String postfrequency) {
        this.postfrequency = postfrequency;
    }

    /**
     * @return the updatetimestamp
     */
    public Timestamp getUpdatetimestamp() {
        return updatetimestamp;
    }

    /**
     * @param updatetimestamp the updatetimestamp to set
     */
    public void setUpdatetimestamp(Timestamp updatetimestamp) {
        this.updatetimestamp = updatetimestamp;
    }

    /**
     * @return the usestat
     */
    public String getUsestat() {
        return usestat;
    }

    /**
     * @param usestat the usestat to set
     */
    public void setUsestat(String usestat) {
        this.usestat = usestat;
    }

}