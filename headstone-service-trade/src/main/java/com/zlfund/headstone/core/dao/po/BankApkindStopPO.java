/**
 * @Title BankApkindStop.java 
 * @Package com.zlfund.headstone.core.dao.po 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月27日 下午7:58:06 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao.po;

import java.util.Date;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月27日 下午7:58:06 
 * @history:
 */
public class BankApkindStopPO {

    private String fundId;

    private String apStop;

    private String strDateTime;

    private String endDateTime;

    private Date cTime;

    private String cMan;

    private Date eTime;

    private String eMan;

    private String status;

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public String getApStop() {
        return apStop;
    }

    public void setApStop(String apStop) {
        this.apStop = apStop;
    }

    public String getStrDateTime() {
        return strDateTime;
    }

    public void setStrDateTime(String strDateTime) {
        this.strDateTime = strDateTime;
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(String endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public String getcMan() {
        return cMan;
    }

    public void setcMan(String cMan) {
        this.cMan = cMan;
    }

    public Date geteTime() {
        return eTime;
    }

    public void seteTime(Date eTime) {
        this.eTime = eTime;
    }

    public String geteMan() {
        return eMan;
    }

    public void seteMan(String eMan) {
        this.eMan = eMan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BankApkindStop [fundId=" + fundId + ", apStop=" + apStop + ", strDateTime=" + strDateTime + ", endDateTime=" + endDateTime + ", cTime=" + cTime
                + ", cMan=" + cMan + ", eTime=" + eTime + ", eMan=" + eMan + ", status=" + status + "]";
    }

}
