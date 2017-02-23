/**
 * @Title BuyBizException.java 
 * @Package com.zlfund.headstone.facade.trade.exception 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月20日 下午5:35:52 
 * @version V1.0   
 */
package com.zlfund.headstone.facade.trade.exception;

/** 
 * 购买业务异常 2001xxxx
 * @author: 徐文凡 
 * @since: 2017年2月20日 下午5:35:52 
 * @history:
 */
public class BuyBizException extends TradeBizException {

    private static final long serialVersionUID = 1L;

    public static final BuyBizException ACCOUNT_TYPE_NOT_ALLOW_BUY = new BuyBizException("20010001", "非自助理财账户不允许此交易，请更换银行卡");

    public static final BuyBizException TA_LIMIT_SINGLE_TRADEACCO = new BuyBizException("20010002", "该产品TA限制单交易账号");

    public static final BuyBizException TRIGGER_FUSE = new BuyBizException("20010003", "已触发指数熔断机制，暂停交易");

    public static final BuyBizException MINOR_NOT_ALLOW_BUY = new BuyBizException("20010004", "您未满18周岁按监管部门的要求不能进行购买");

    public static final BuyBizException BANK_CHANNEL_NOT_TRADE_TIME = new BuyBizException("20010005", "银行渠道非交易时间");

    public static final BuyBizException APKIND_IS_STOP = new BuyBizException("20010006", "由于银行升级，暂不允许购买");

    public static final BuyBizException FUND_STATUS_PAUSE_BUY = new BuyBizException("20010007", "基金状态暂停购买");

    protected BuyBizException(String code, String msg) {
        super(code, msg);
    }

    protected BuyBizException(String code, String msg, String detailMsg) {
        super(code, msg, detailMsg);
    }

    protected BuyBizException(String code, String msg, String detailMsg, Object... args) {
        super(code, msg, detailMsg, args);
    }

    public BuyBizException newInstance(String detailMsg) {
        return new BuyBizException(this.code, this.msg, detailMsg);
    }

    public BuyBizException newInstance(String detailMsg, Object... args) {
        return new BuyBizException(this.code, this.msg, detailMsg, args);
    }

}
