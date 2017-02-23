/**
 * @Title RedeemBizException.java 
 * @Package com.zlfund.headstone.facade.trade.exception 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月22日 下午1:06:39 
 * @version V1.0   
 */
package com.zlfund.headstone.facade.trade.exception;

/** 
 * 赎回类业务异常 2002xxxx
 * @author: 徐文凡 
 * @since: 2017年2月22日 下午1:06:39 
 * @history:
 */
public class RedeemBizException extends TradeBizException {

    private static final long serialVersionUID = 1L;

    protected RedeemBizException(String code, String msg) {
        super(code, msg);
    }

    protected RedeemBizException(String code, String msg, String detailMsg) {
        super(code, msg, detailMsg);
    }

    protected RedeemBizException(String code, String msg, String detailMsg, Object... args) {
        super(code, msg, detailMsg, args);
    }
}
