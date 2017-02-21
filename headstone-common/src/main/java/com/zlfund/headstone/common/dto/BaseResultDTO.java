/**
 * @Title BaseResult.java 
 * @Package com.zlfund.headstone.common.entity 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月21日 上午9:33:34 
 * @version V1.0   
 */
package com.zlfund.headstone.common.dto;

/** 
 * RPC数据传输对象响应基类,所有响应DTO继承此类
 * @author: 徐文凡 
 * @since: 2017年2月21日 上午9:33:34 
 * @history:
 */
public class BaseResultDTO {

    // 调用是否成功
    private boolean isSuccess;

    // 错误码 00000000-成功,其余为各自业务Exception里自定义的错误码
    private String errCode;

    // 错误码描述
    private String errMsg;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
