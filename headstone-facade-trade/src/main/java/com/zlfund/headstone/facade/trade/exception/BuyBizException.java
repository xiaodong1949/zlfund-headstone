/**
 * @Title BuyBizException.java 
 * @Package com.zlfund.headstone.facade.trade.exception 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月20日 下午5:35:52 
 * @version V1.0   
 */
package com.zlfund.headstone.facade.trade.exception;

import com.zlfund.headstone.common.exceptions.BizException;

/** 
 * 购买业务异常 2001xxxx
 * @author: 徐文凡 
 * @since: 2017年2月20日 下午5:35:52 
 * @history:
 */
public class BuyBizException extends BizException {

    private static final long serialVersionUID = 1L;

    public static final BuyBizException BUY_PARAM_IS_NULL = new BuyBizException(20010001, "购买参数为空");

    public static final BuyBizException BUY_PARAM_ERROR = new BuyBizException(20010002, "购买参数异常");

    public static final BuyBizException TRADE_ACCO_INFO_NOT_EXISTS = new BuyBizException(20010003, "交易账号不存在，请重新开户");

    private BuyBizException(int code, String msg) {
        super(code, msg);
    }

    private BuyBizException(int code, String msg, String detailMsg) {
        super(code, msg, detailMsg);
    }

    private BuyBizException(int code, String msg, String detailMsg, Object... args) {
        super(code, msg, detailMsg, args);
    }

    public BuyBizException newInstance(String detailMsg) {
        return new BuyBizException(this.code, this.msg, detailMsg);
    }

    public BuyBizException newInstance(String detailMsg, Object... args) {
        return new BuyBizException(this.code, this.msg, detailMsg, args);
    }

}
