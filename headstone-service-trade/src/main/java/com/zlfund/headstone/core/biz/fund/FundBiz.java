/**
 * @Title FundBiz.java 
 * @Package com.zlfund.headstone.core.biz.fund 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月22日 下午3:49:36 
 * @version V1.0   
 */
package com.zlfund.headstone.core.biz.fund;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zlfund.headstone.common.Constants;
import com.zlfund.headstone.core.biz.AbstractProductBiz;
import com.zlfund.headstone.core.biz.TradeCommonBiz;
import com.zlfund.headstone.core.dao.CapitalBalanceDAO;
import com.zlfund.headstone.core.dao.CustInfoDAO;
import com.zlfund.headstone.core.dao.FundInfoDAO;
import com.zlfund.headstone.core.dao.TradeAccoInfoDAO;
import com.zlfund.headstone.core.dao.TradeRequestDAO;
import com.zlfund.headstone.core.dao.po.CustInfoPO;
import com.zlfund.headstone.core.dao.po.FundInfoPO;
import com.zlfund.headstone.core.dao.po.TradeAccoInfoPO;
import com.zlfund.headstone.core.dao.po.TradeRequestPO;
import com.zlfund.headstone.facade.trade.consts.ApKindConsts;
import com.zlfund.headstone.facade.trade.consts.FundStatusConsts;
import com.zlfund.headstone.facade.trade.consts.InvTpConsts;
import com.zlfund.headstone.facade.trade.dto.BuyRequestDTO;
import com.zlfund.headstone.facade.trade.exception.BuyBizException;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月22日 下午3:49:36 
 * @history:
 */
@Component("fundBiz")
public class FundBiz extends AbstractProductBiz {

    @Autowired
    TradeCommonBiz commonBiz;

    @Autowired
    FundInfoDAO fundInfoDAO;

    @Autowired
    TradeAccoInfoDAO tradeAccoInfoDAO;

    @Autowired
    CustInfoDAO custInfoDAO;

    @Autowired
    CapitalBalanceDAO capitalBalanceDAO;

    @Autowired
    TradeRequestDAO tradeRequestDAO;

    /**
     * 购买下单前检查，不开启事务
     * @see com.zlfund.headstone.core.biz.AbstractProductBiz#checkBeforeBuy(com.zlfund.headstone.facade.trade.dto.BuyRequestDTO)
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    protected void checkBeforeBuy(BuyRequestDTO buyRequest) {
        // 基本参数校验
        if (buyRequest == null) {
            throw BuyBizException.PARAM_IS_NULL;
        }

        // 校验基金代码
        String fundId = buyRequest.getFundId();
        if (StringUtils.isBlank(fundId)) {
            throw BuyBizException.PARAM_IS_NULL.newInstance("请输入产品代码。");
        }
        if (StringUtils.length(fundId) != 6) {
            throw BuyBizException.PARAM_ILLEGAL.newInstance("产品代码应该为6位，请重新输入。");
        }

        // 校验客户号
        String custNo = buyRequest.getCustNo();
        if (StringUtils.isBlank(custNo)) {
            throw BuyBizException.PARAM_IS_NULL.newInstance("无法获取客户号，请重新登录。");
        }
        // 校验客户号长度
        if (StringUtils.length(custNo) != Constants.CUSTNO_LENGTH) {
            throw BuyBizException.PARAM_ILLEGAL.newInstance("客户号长度不合法%s", custNo);
        }

        // 校验交易账号
        String tradeAcco = buyRequest.getTradeAcco();
        if (StringUtils.isBlank(tradeAcco)) {
            throw BuyBizException.PARAM_IS_NULL.newInstance("无法获取交易账号，请重新登录。");
        }
        if (StringUtils.length(tradeAcco) > 17) {
            throw BuyBizException.PARAM_ILLEGAL.newInstance("交易账号长度不合法%s", tradeAcco);
        }

        // 校验购买金额
        double subAmt = buyRequest.getSubAmt();
        if (subAmt <= 0) {
            throw BuyBizException.PARAM_ILLEGAL.newInstance("购买金额必须大于0.00元，请重新输入。");
        }

        // 校验产品是否存在
        int count = fundInfoDAO.countFundInfoByFundId(fundId);
        if (count == 0) {
            throw BuyBizException.PRODUCT_NOT_EXISTS.newInstance("%s产品信息不存在", fundId);
        }

        // 获取产品信息
        FundInfoPO fundInfoPO = fundInfoDAO.getFundInfoByFundId(fundId);

        if ("ZL".equalsIgnoreCase(fundInfoPO.getTaNo())) {
            throw BuyBizException.NOT_SUPPORT_ZYB;
        }

        // 校验客户是否存在
        CustInfoPO custInfoPO = custInfoDAO.getCustInfoByCustNo(custNo);
        if (custInfoPO == null) {
            // 客户信息不存在
            throw BuyBizException.CUST_NOT_EXISTS;
        }

        // 获取交易账号信息
        TradeAccoInfoPO tradeAccoInfoPO = tradeAccoInfoDAO.getTradeAccoInfoByTradeAcco(tradeAcco);
        if (tradeAccoInfoPO == null) {
            // 交易账号不存在
            throw BuyBizException.TRADEACCO_NOT_EXISTS;
        }
        if (!"N".equalsIgnoreCase(tradeAccoInfoPO.getTradeAccoSt())) {
            throw BuyBizException.TRADEACCO_STATUS_ABN;
        }

        // 校验个人客户是否成年
        if (InvTpConsts.INDIVIDUAL.equals(custInfoPO.getInvTp()) && commonBiz.checkIsMinor(tradeAccoInfoPO.getBankIdNo())) {
            throw BuyBizException.MINOR_NOT_ALLOW_BUY;
        }

        // 校验交易账号是否为S-自助理财账户,限制配置宝交易账户
        if (!InvTpConsts.INDIVIDUAL.equalsIgnoreCase(tradeAccoInfoPO.getAccountType())) {
            // 配置宝交易账户只允许购买配置宝伴侣
            if (!"161608".equals(fundId)) {
                throw BuyBizException.ACCOUNT_TYPE_NOT_ALLOW_BUY;
            }
        }

        // 校验产品所属TA是否仅支持单交易账号
        if (commonBiz.checkSingleTradeAccoTA(fundId) && !"1".equals(tradeAccoInfoPO.getMainFlag())) {
            throw BuyBizException.TA_SINGLE_TRADEACCO_LIMIT.newInstance("对不起，该产品暂时只支持使用%s的银行卡购买", tradeAccoInfoPO.getBankAcco());
        }

        // 校验银行渠道是否交易时间
        if (commonBiz.checkBankTradeTime(tradeAccoInfoPO.getBankNo())) {
            throw BuyBizException.BANK_CHANNEL_NOT_TRADE_TIME;
        }

        // 获取交易类型
        String apKind = StringUtils.EMPTY;
        if (FundStatusConsts.SUB.equals(fundInfoPO.getFundSt())) {
            // 认购
            apKind = ApKindConsts.SUB;
        } else {
            // 申购
            apKind = ApKindConsts.BID;
        }

        // 校验是否触发指数熔断机制
        if (commonBiz.checkMarketIsFuse(fundId, apKind)) {
            throw BuyBizException.TRIGGER_FUSE;
        }

        // 校验交易业务类型是否正常
        if (commonBiz.checkApKindIsStop(fundId, null, apKind)) {
            throw BuyBizException.APKIND_IS_STOP;
        }

        // 校验基金状态
        if (commonBiz.checkFundStatus(fundInfoPO, apKind)) {
            throw BuyBizException.FUND_STATUS_PAUSE_BUY;
        }

        // 校验交易可行性
        commonBiz.checkTradeAvailable(tradeAcco, fundId, apKind, subAmt);
    }

    /**
     * 购买下单
     * @see com.zlfund.headstone.core.biz.AbstractProductBiz#submitBuy(com.zlfund.headstone.facade.trade.dto.BuyRequestDTO)
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    protected TradeRequestPO submitBuy(BuyRequestDTO buyRequestDTO) {
        TradeAccoInfoPO tradeAccoInfoPO = tradeAccoInfoDAO.getTradeAccoInfoByTradeAcco(buyRequestDTO.getTradeAcco());

        // 资金来源
        String cashFrom = "B";
        double subAmt = buyRequestDTO.getSubAmt();

        // 0-不重用撤单资金 1-重用撤单资金
        String bidTp = buyRequestDTO.getBidTp();

        double capitalBalance = 0.00;
        if ("1".equals(bidTp)) {
            // 查询可重用资金余额
            capitalBalance = capitalBalanceDAO.getAvailableCapitalBalance(tradeAccoInfoPO.getTradeAcco());

            if (capitalBalance < 0) {
                throw BuyBizException.ABNORMAL_CAPITAL_BALANCE;
            }

            if (capitalBalance < subAmt) {
                // 部分扣款 部分留存
                cashFrom = "S";
            } else {
                // 全部留存
                cashFrom = "R";
            }
        }

        String apKind = null;
        FundInfoPO fundInfoPO = fundInfoDAO.getFundInfoByFundId(buyRequestDTO.getFundId());
        if (FundStatusConsts.SUB.equals(fundInfoPO.getFundSt())) {
            // 认购
            apKind = ApKindConsts.SUB;
        } else {
            // 申购
            apKind = ApKindConsts.BID;
        }

        // 写traderequest
        TradeRequestPO tradeRequestPO = new TradeRequestPO();
        tradeRequestPO.setSerialNo(commonBiz.newBankSerialNo());
        tradeRequestPO.setCustNo(buyRequestDTO.getCustNo());
        tradeRequestPO.setTradeAcco(buyRequestDTO.getTradeAcco());
        tradeRequestPO.setFundId(buyRequestDTO.getFundId());
        tradeRequestPO.setApKind(apKind);
        tradeRequestDAO.saveTradeRequest(tradeRequestPO);

        return tradeRequestPO;
    }

}
