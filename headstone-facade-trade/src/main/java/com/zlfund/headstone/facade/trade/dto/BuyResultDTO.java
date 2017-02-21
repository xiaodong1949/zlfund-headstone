/**
 * @Title BuyResult.java 
 * @Package com.zlfund.headstone.facade.trade.entity 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月20日 下午5:05:10 
 * @version V1.0   
 */
package com.zlfund.headstone.facade.trade.dto;

import java.io.Serializable;

import com.zlfund.headstone.common.dto.BaseResultDTO;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月20日 下午5:05:10 
 * @history:
 */
public class BuyResultDTO extends BaseResultDTO implements Serializable {

    private static final long serialVersionUID = -9044297068712842696L;

    private String workDate;

    private String serialNo;

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }
}
