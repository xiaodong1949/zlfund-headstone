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

    public static final TradeBizException PRODUCT_NOT_EXISTS = new TradeBizException("20000001", "产品不存在");

    public static final TradeBizException TRADEACCO_NOT_EXISTS = new TradeBizException("20000002", "交易账号不存在，请重新开户");

    public static final TradeBizException CUST_NOT_EXISTS = new TradeBizException("20000003", "客户信息不存在，请重新注册");

    public static final TradeBizException TA_NOT_EXISTS = new TradeBizException("20000004", "TA信息不存在");

    public static final TradeBizException TA_SINGLE_TRADEACCO_LIMIT = new TradeBizException("20000005", "TA单交易账号限制");

    public static final TradeBizException ACCOUNT_ALREADY_FREEZE = new TradeBizException("20000006", "对不起，您的账户已被冻结，详询请致电在线客服。");

    public static final TradeBizException ACCOUNT_ALREADY_CANCEL = new TradeBizException("20000007", "对不起，您的账户已注销，详询请致电在线客服。");

    public static final TradeBizException AVAILABLE_BALANCE_LT_ZERO = new TradeBizException("20000008", "该次赎回份额大于该可用余额");

    public static final TradeBizException LT_MINREDAMT = new TradeBizException("20000009", "小于最低赎回份额");

    public static final TradeBizException LT_MINADDSUBAMT = new TradeBizException("20000010", "认购金额不能低于最低追加认购金额");

    public static final TradeBizException GT_MAXSUBAMT = new TradeBizException("20000011", "认购金额不能高于最高认购金额");

    public static final TradeBizException SUBAMT_MUST_MULTIPLE = new TradeBizException("20000012", "认购金额必须为级差的整数倍");

    public static final TradeBizException LT_MINSUBAMT = new TradeBizException("20000013", "认购金额不能低于最低认购金额");

    public static final TradeBizException LT_MINADDAPPAMT = new TradeBizException("20000014", "申购金额不能低于最低追加申购金额");

    public static final TradeBizException LT_MINBIDAMT = new TradeBizException("20000015", "申购金额不能低于最低申购金额");

    public static final TradeBizException GT_MAXBIDAMT = new TradeBizException("20000016", "申购金额不能高于最高申购金额");

    public static final TradeBizException BIDAMT_MUST_MULTIPLE = new TradeBizException("20000017", "申购金额必须为级差的整数倍");

    public static final TradeBizException LT_MINHOLDAMT = new TradeBizException("20000018", "剩余份额低于最低保有份额");

    public static final TradeBizException LT_MINCONVAMT = new TradeBizException("20000019", "低于最低转换份额");

    /**
     * 交易账号状态不为N
     */
    public static final TradeBizException TRADEACCO_STATUS_ABN = new TradeBizException("", "交易账号状态异常，请重新绑卡");

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
