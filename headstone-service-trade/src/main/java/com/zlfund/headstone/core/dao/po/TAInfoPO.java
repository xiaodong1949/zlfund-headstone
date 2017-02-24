/**
 * @Title TAInfoPO.java 
 * @Package com.zlfund.headstone.core.dao.po 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月23日 下午1:15:51 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao.po;

import java.sql.Date;

/** 
 * TAINFO表PO
 * @author: 徐文凡 
 * @since: 2017年2月23日 下午1:15:51 
 * @history:
 */
public class TAInfoPO {

    private String taNo;

    private String taNm;

    private String taType;

    private String detailFlag;

    private String shareType;

    private Date insertTimeStamp;

    private Date updateTimeStamp;

    private String sendFlag;

    private String send;

    private String receive;

    private String oneacctFlag;

    public String getTaNo() {
        return taNo;
    }

    public void setTaNo(String taNo) {
        this.taNo = taNo;
    }

    public String getTaNm() {
        return taNm;
    }

    public void setTaNm(String taNm) {
        this.taNm = taNm;
    }

    public String getTaType() {
        return taType;
    }

    public void setTaType(String taType) {
        this.taType = taType;
    }

    public String getDetailFlag() {
        return detailFlag;
    }

    public void setDetailFlag(String detailFlag) {
        this.detailFlag = detailFlag;
    }

    public String getShareType() {
        return shareType;
    }

    public void setShareType(String shareType) {
        this.shareType = shareType;
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

    public String getSendFlag() {
        return sendFlag;
    }

    public void setSendFlag(String sendFlag) {
        this.sendFlag = sendFlag;
    }

    public String getSend() {
        return send;
    }

    public void setSend(String send) {
        this.send = send;
    }

    public String getReceive() {
        return receive;
    }

    public void setReceive(String receive) {
        this.receive = receive;
    }

    public String getOneacctFlag() {
        return oneacctFlag;
    }

    public void setOneacctFlag(String oneacctFlag) {
        this.oneacctFlag = oneacctFlag;
    }

    @Override
    public String toString() {
        return "TAInfoPO [taNo=" + taNo + ", taNm=" + taNm + ", taType=" + taType + ", detailFlag=" + detailFlag + ", shareType=" + shareType
                + ", insertTimeStamp=" + insertTimeStamp + ", updateTimeStamp=" + updateTimeStamp + ", sendFlag=" + sendFlag + ", send=" + send + ", receive="
                + receive + ", oneacctFlag=" + oneacctFlag + "]";
    }

}
