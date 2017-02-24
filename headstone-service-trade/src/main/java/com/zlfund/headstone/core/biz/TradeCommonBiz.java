/**
 * @Title CommonBiz.java 
 * @Package com.zlfund.headstone.core.biz 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月21日 下午7:21:19 
 * @version V1.0   
 */
package com.zlfund.headstone.core.biz;

import org.springframework.stereotype.Component;

/** 
 * 交易公共业务，例如交易流水号管理，检查份额余额等
 * 
 * @author: 徐文凡 
 * @since: 2017年2月21日 下午7:21:19 
 * @history:
 */
@Component("commonBiz")
public class TradeCommonBiz {

    /**
     * 生成交易流水号 24bit
     * @return 
     * @create: 2017年2月21日 下午7:22:53 
     * @author: 徐文凡
     * @history:
     */
    public String newTradeSerialNo() {
        return null;
    }

    /**
     * 生成银行指令流水号 18bit
     * @return 
     * @create: 2017年2月21日 下午7:23:22 
     * @author: 徐文凡
     * @history:
     */
    public String newBankSerialNo() {
        return null;
    }

    /**
     * 检查交易可行性
     * @param tradeAcco 交易账号
     * @param fundId 产品代码
     * @param apKind 交易类型
     * @param quantity 数量（金额OR份额）
     * @return 
     * @create: 2017年2月21日 下午7:25:44 
     * @author: 徐文凡
     * @history:
     */
    public boolean checkTradeAvailable(String tradeAcco, String fundId, String apKind, double quantity) {
        return true;
    }

    /**
     * 检查客户账户是否冻结
     * @param custNo 客户号
     * @return 
     * @create: 2017年2月21日 下午7:26:46 
     * @author: 徐文凡
     * @history:
     */
    public boolean checkCustAbnStatus(String custNo) {
        return true;
    }

    /**
     * 检查基金状态，判断基金代码对应的交易类型是否可以通过
     * @param fundId 产品代码
     * @param apKind 交易类型
     * @return 
     * @create: 2017年2月21日 下午7:28:17 
     * @author: 徐文凡
     * @history:
     */
    public boolean checkFundStatus(String fundId, String apKind) {
        return true;
    }

    /**
     * 检查当前该基金是否触发指数熔断
     * @param fundId 产品代码
     * @param apKind 交易类型
     * @return 
     * @create: 2017年2月21日 下午7:30:37 
     * @author: 徐文凡
     * @history:
     */
    public boolean checkMarketIsFuse(String fundId, String apKind) {
        return true;
    }

    /**
     * 检查产品所属TA是否仅支持单交易账号
     * @param fundId 产品代码
     * @return 
     * @create: 2017年2月22日 上午9:05:31 
     * @author: 徐文凡
     * @history:
     */
    public boolean checkSingleTradeAccoTA(String fundId) {
        return false;
    }

    /**
     * 检查该银行渠道是否在交易时间
     * @param bankNo 银行渠道
     * @return 
     * @create: 2017年2月22日 上午9:06:39 
     * @author: 徐文凡
     * @history:
     */
    public boolean checkBankTradeTime(String bankNo) {
        return true;
    }

    /**
     * 检查当前业务和产品是否可以进行交易
     * @param fundId 产品代码
     * @param oFundId 转入产品代码
     * @param apKind 交易类型
     * @return 
     * @create: 2017年2月22日 上午9:09:36 
     * @author: 徐文凡
     * @history:
     */
    public boolean checkApKindIsStop(String fundId, String oFundId, String apKind) {
        return true;
    }

    /**
     * 根据证件号检查是否未成年
     * @param idNo 身份证号
     * @return 
     * @create: 2017年2月22日 上午11:13:20 
     * @author: 徐文凡
     * @history:
     */
    public boolean checkIsMinor(String idNo) {
        return false;
    }
}