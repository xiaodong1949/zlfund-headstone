/**
 * @Title CustAbnStatusPO.java 
 * @Package com.zlfund.headstone.core.dao.po 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月26日 下午6:00:43 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao.po;

/** 
 * CUST_ABNSTATUS表PO
 * @author: 徐文凡 
 * @since: 2017年2月26日 下午6:00:43 
 * @history:
 */
public class CustAbnStatusPO {
    private String idNo;

    private String abnStatus;

    private String remark;

    private String insertTimeStamp;

    private String updateTimeStamp;

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getAbnStatus() {
        return abnStatus;
    }

    public void setAbnStatus(String abnStatus) {
        this.abnStatus = abnStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getInsertTimeStamp() {
        return insertTimeStamp;
    }

    public void setInsertTimeStamp(String insertTimeStamp) {
        this.insertTimeStamp = insertTimeStamp;
    }

    public String getUpdateTimeStamp() {
        return updateTimeStamp;
    }

    public void setUpdateTimeStamp(String updateTimeStamp) {
        this.updateTimeStamp = updateTimeStamp;
    }

    @Override
    public String toString() {
        return "CustAbnStatusPO [idNo=" + idNo + ", abnStatus=" + abnStatus + ", remark=" + remark + ", insertTimeStamp=" + insertTimeStamp
                + ", updateTimeStamp=" + updateTimeStamp + "]";
    }

}
