/**
 * @Title AmtAndQutyException.java 
 * @Package com.zlfund.headstone.facade.trade.exception 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月22日 上午11:31:11 
 * @version V1.0   
 */
package com.zlfund.headstone.facade.trade.exception;

import com.zlfund.headstone.common.exceptions.BizException;

/** 
 * 交易类公共异常 2000xxxx
 * @author: 徐文凡 
 * @since: 2017年2月22日 上午11:31:11 
 * @history:
 */
public class TradeBizException extends BizException {

    private static final long serialVersionUID = 1L;

    public static final TradeBizException PRODUCT_NOT_EXISTS = new BuyBizException("20000001", "产品不存在");

    public static final TradeBizException TRADEACCO_NOT_EXISTS = new BuyBizException("20000002", "交易账号不存在，请重新开户");

    public static final TradeBizException CUST_NOT_EXISTS = new BuyBizException("20000003", "客户信息不存在，请重新注册");

    protected TradeBizException(String code, String msg) {
        super(code, msg);
    }

    protected TradeBizException(String code, String msg, String detailMsg) {
        super(code, msg, detailMsg);
    }

    protected TradeBizException(String code, String msg, String detailMsg, Object... args) {
        super(code, msg, detailMsg, args);
    }
}