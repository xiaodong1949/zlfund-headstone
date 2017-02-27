/**
 * @Title CommonBiz.java 
 * @Package com.zlfund.headstone.core.biz 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月21日 下午7:21:19 
 * @version V1.0   
 */
package com.zlfund.headstone.core.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zlfund.headstone.common.exceptions.BizException;
import com.zlfund.headstone.common.utils.StringUtil;
import com.zlfund.headstone.core.bo.AvailableBalanceBO;
import com.zlfund.headstone.core.dao.CustAbnStatusDAO;
import com.zlfund.headstone.core.dao.CustInfoDAO;
import com.zlfund.headstone.core.dao.FundBalanceDAO;
import com.zlfund.headstone.core.dao.FundInfoDAO;
import com.zlfund.headstone.core.dao.FundInfoExDAO;
import com.zlfund.headstone.core.dao.TAInfoDAO;
import com.zlfund.headstone.core.dao.TradeAccoInfoDAO;
import com.zlfund.headstone.core.dao.TradeProcedureDAO;
import com.zlfund.headstone.core.dao.po.CustAbnStatusPO;
import com.zlfund.headstone.core.dao.po.CustInfoPO;
import com.zlfund.headstone.core.dao.po.FundInfoExPO;
import com.zlfund.headstone.core.dao.po.FundInfoPO;
import com.zlfund.headstone.core.dao.po.TAInfoPO;
import com.zlfund.headstone.facade.trade.consts.ApKindConsts;
import com.zlfund.headstone.facade.trade.consts.FundStatusConsts;
import com.zlfund.headstone.facade.trade.consts.TradeConsts;
import com.zlfund.headstone.facade.trade.exception.TradeBizException;

/** 
 * 交易公共业务，例如交易流水号管理，检查份额余额等
 * 
 * @author: 徐文凡 
 * @since: 2017年2月21日 下午7:21:19 
 * @history:
 */
@Component("commonBiz")
public class TradeCommonBiz {

    @Autowired
    FundInfoDAO fundInfoDAO;

    @Autowired
    TAInfoDAO taInfoDAO;

    @Autowired
    TradeAccoInfoDAO tradeAccoInfoDAO;

    @Autowired
    FundInfoExDAO fundInfoExDAO;

    @Autowired
    CustInfoDAO custInfoDAO;

    @Autowired
    CustAbnStatusDAO custAbnStatusDAO;

    @Autowired
    FundBalanceDAO fundBalanceDAO;

    @Autowired
    TradeProcedureDAO tradeProcedureDAO;

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
     * 检查交易可行性 优化重写IBF_CHECK_AVALIABLE
     * @param custNo 客户号
     * @param tradeAcco 交易账号
     * @param fundId 产品代码
     * @param apKind 交易类型
     * @param quantity 数量（金额OR份额）
     * @return 
     * @create: 2017年2月21日 下午7:25:44 
     * @author: 徐文凡
     * @history:
     */
    public void checkTradeAvailable(String custNo, String tradeAcco, String fundId, String apKind, double quantity) {
        FundInfoExPO fundInfoExPO = fundInfoExDAO.getFundInfoExByFundId(fundId);

        if (fundInfoExPO == null) {
            throw TradeBizException.PRODUCT_NOT_EXISTS;
        }

        if (StringUtil.isIn(apKind, ApKindConsts.SUB, ApKindConsts.BID)) {
            // 认申购 查询是否首次购买
            String firstBuyFlag = tradeProcedureDAO.oqpFundIsFirstBuy(custNo, fundId, apKind);

            // 认购检查
            if (ApKindConsts.SUB.equals(apKind)) {

                // 首次认购检查
                if ("N".equalsIgnoreCase(firstBuyFlag)) {
                    if (quantity < fundInfoExPO.getMinAddSubAmt()) {
                        throw TradeBizException.LT_MINADDSUBAMT;
                    }
                } else {
                    if (quantity < fundInfoExPO.getMinSubAmt()) {
                        throw TradeBizException.LT_MINSUBAMT;
                    }
                }

                if (quantity > fundInfoExPO.getMaxSubAmt()) {
                    throw TradeBizException.GT_MAXSUBAMT;
                }

                if ("1".equals(fundInfoExPO.getIfMultiple()) && (quantity % fundInfoExPO.getMinAddSubAmt() != 0)) {
                    throw TradeBizException.SUBAMT_MUST_MULTIPLE;
                }

            } else if (ApKindConsts.BID.equals(apKind)) {
                // 申购检查
                if ("N".equalsIgnoreCase(firstBuyFlag)) {
                    if (quantity < fundInfoExPO.getMinAddAppAmt()) {
                        throw TradeBizException.LT_MINADDAPPAMT;
                    }
                } else {
                    if (quantity < fundInfoExPO.getMinBidAmt()) {
                        throw TradeBizException.LT_MINBIDAMT;
                    }
                }

                if (quantity > fundInfoExPO.getMaxBidAmt()) {
                    throw TradeBizException.GT_MAXBIDAMT;
                }

                if ("1".equals(fundInfoExPO.getIfMultiple()) && (quantity % fundInfoExPO.getMinAddAppAmt() != 0)) {
                    throw TradeBizException.BIDAMT_MUST_MULTIPLE;
                }
            }

        } else if (StringUtil.isIn(apKind, ApKindConsts.RED, ApKindConsts.CONV, ApKindConsts.QUICK_REDEEM, ApKindConsts.SPAN_CONV)) {
            // 仅针对需要读取可用份额的交易类型做fundbalance行锁操作
            fundBalanceDAO.fundBalanceLineForUpdate(tradeAcco, fundId);

            // 可用余额
            double useableBalance = 0.00;

            // 针对银华定活两变基金特殊处理
            if (TradeConsts.YHHQB_FUNDID.equals(fundId)) {
                // 单独查询银华活钱宝可用份额
                useableBalance = fundBalanceDAO.getYHHQBAvailableBalance(tradeAcco) - quantity;
            } else {
                // 读取账户可用余额
                AvailableBalanceBO availableBalanceBO = fundBalanceDAO.oqpGetAvaliableBalance(tradeAcco, fundId);
                useableBalance = availableBalanceBO.getAvailableBalance() - quantity;
            }

            if (useableBalance < 0) {
                throw TradeBizException.AVAILABLE_BALANCE_LT_ZERO;
            }

            if (useableBalance == 0) {
                // 全额赎回直接返回
                return;
            }

            if (ApKindConsts.RED.equals(apKind)) {
                // 赎回检查
                if (quantity < fundInfoExPO.getMinRedAmt()) {
                    throw TradeBizException.LT_MINREDAMT;
                }

                if (quantity < fundInfoExPO.getMinHoldAmt()) {
                    throw TradeBizException.LT_MINHOLDAMT;
                }
            }

            if (ApKindConsts.CONV.equals(apKind)) {
                // 转换检查
                if (quantity < fundInfoExPO.getMinConvAmt()) {
                    throw TradeBizException.LT_MINCONVAMT;
                }

                if (quantity < fundInfoExPO.getMinHoldAmt()) {
                    throw TradeBizException.LT_MINHOLDAMT;
                }
            }

        }
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
        // 获取客户信息
        CustInfoPO custInfoPO = custInfoDAO.getCustInfoByCustNo(custNo);

        if (custInfoPO == null) {
            throw TradeBizException.CUST_NOT_EXISTS;
        }

        // 15 or 18位证件
        String counterpart = null;

        // 查询用户冻结状态
        CustAbnStatusPO custAbnStatusPO = custAbnStatusDAO.getCustAbnStatusByIdNo(custInfoPO.getIdNo(), counterpart);

        if (custAbnStatusPO == null) {
            // 无冻结记录
            return false;
        }

        String abnStatus = custAbnStatusPO.getAbnStatus();

        if ("D".equalsIgnoreCase(abnStatus)) {
            // 账户已被人工冻结
            throw TradeBizException.ACCOUNT_ALREADY_FREEZE;
        }

        if ("C".equalsIgnoreCase(abnStatus)) {
            // 账户已被人工注销
            throw TradeBizException.ACCOUNT_ALREADY_CANCEL;
        }

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
    public boolean checkFundStatus(FundInfoPO fundInfoPO, String apKind) {
        if (fundInfoPO == null) {
            throw BizException.PARAM_IS_NULL.newInstance("基金产品不存在");
        }

        String fundStatus = fundInfoPO.getFundSt();

        if (ApKindConsts.BID.equals(apKind)) {
            // 申购 0 6
            if (StringUtil.isIn(fundStatus, FundStatusConsts.NORMAL, FundStatusConsts.STOP_RED)) {
                return false;
            }
        } else if (ApKindConsts.SUB.equals(apKind)) {
            // 认购 1
            if (StringUtil.isIn(fundStatus, FundStatusConsts.SUB)) {
                return false;
            }
        } else if (ApKindConsts.RED.equals(apKind)) {
            // 赎回 0 5
            if (StringUtil.isIn(fundStatus, FundStatusConsts.NORMAL, FundStatusConsts.STOP_BID)) {
                return false;
            }
        }
        // balabala

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
    public boolean checkMarketIsFuse(String fundId) {
        // 查询系统是否已经触发熔断机制
        int count = fundInfoExDAO.countFundInfoExIfFuse(fundId);

        if (count == 0) {
            return false;
        }

        return true;
    }

    /**
     * 检查产品所属TA是否仅支持单交易账号
     * @param fundId 产品代码
     * @return 
     * @create: 2017年2月23日 下午1:32:56 
     * @author: 徐文凡
     * @history:
     */
    public boolean checkSingleTradeAccoTA(String fundId) {
        TAInfoPO taInfoPO = taInfoDAO.getTaInfoByFundId(fundId);

        if (taInfoPO == null) {
            throw TradeBizException.TA_NOT_EXISTS;
        }

        if ("Y".equalsIgnoreCase(taInfoPO.getOneacctFlag())) {
            return true;
        }

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
