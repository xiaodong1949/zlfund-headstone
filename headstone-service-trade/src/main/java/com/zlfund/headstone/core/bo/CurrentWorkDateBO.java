/**
 * @Title WorkDateBO.java 
 * @Package com.zlfund.headstone.core.bo 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月24日 下午1:38:12 
 * @version V1.0   
 */
package com.zlfund.headstone.core.bo;

/** 
 * 工作日业务对象
 * @author: 徐文凡 
 * @since: 2017年2月24日 下午1:38:12 
 * @history:
 */
public class CurrentWorkDateBO {

    // 当前日期
    private String currentDate;

    // 当前时间
    private String currentTime;

    // 当前工作日
    private String currentWorkDate;

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getCurrentWorkDate() {
        return currentWorkDate;
    }

    public void setCurrentWorkDate(String currentWorkDate) {
        this.currentWorkDate = currentWorkDate;
    }

}
