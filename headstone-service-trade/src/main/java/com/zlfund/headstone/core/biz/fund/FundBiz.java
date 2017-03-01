/**
 * @Title FundBiz.java 
 * @Package com.zlfund.headstone.core.biz.fund 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月22日 下午3:49:36 
 * @version V1.0   
 */
package com.zlfund.headstone.core.biz.fund;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zlfund.headstone.common.Constants;
import com.zlfund.headstone.core.biz.AbstractProductBiz;
import com.zlfund.headstone.core.biz.CapitalBalanceBiz;
import com.zlfund.headstone.core.biz.DateTimeBiz;
import com.zlfund.headstone.core.biz.TradeCommonBiz;
import com.zlfund.headstone.core.bo.CurrentWorkDateBO;
import com.zlfund.headstone.core.dao.CapitalBalanceDAO;
import com.zlfund.headstone.core.dao.CustInfoDAO;
import com.zlfund.headstone.core.dao.FundInfoDAO;
import com.zlfund.headstone.core.dao.TradeAccoInfoDAO;
import com.zlfund.headstone.core.dao.TradeProcedureDAO;
import com.zlfund.headstone.core.dao.TradeRequestDAO;
import com.zlfund.headstone.core.dao.TradeRequestStatusDAO;
import com.zlfund.headstone.core.dao.po.CustInfoPO;
import com.zlfund.headstone.core.dao.po.FundInfoPO;
import com.zlfund.headstone.core.dao.po.TradeAccoInfoPO;
import com.zlfund.headstone.core.dao.po.TradeRequestPO;
import com.zlfund.headstone.core.dao.po.TradeRequestStatusPO;
import com.zlfund.headstone.facade.trade.consts.ApKindConsts;
import com.zlfund.headstone.facade.trade.consts.CashFromConsts;
import com.zlfund.headstone.facade.trade.consts.FundStatusConsts;
import com.zlfund.headstone.facade.trade.consts.InvTpConsts;
import com.zlfund.headstone.facade.trade.consts.TradeAccoStatusConsts;
import com.zlfund.headstone.facade.trade.consts.TradeAccoTypeConsts;
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
    DateTimeBiz dateTimeBiz;

    @Autowired
    CapitalBalanceBiz capitalBalanceBiz;

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

    @Autowired
    TradeProcedureDAO tradeProcedureDAO;

    @Autowired
    TradeRequestStatusDAO tradeRequestStatusDAO;

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

        // 校验流水号 这里存储过程漏校验了
        String serialNo = buyRequest.getSerialNo();
        if (StringUtils.isBlank(serialNo)) {
            throw BuyBizException.PARAM_IS_NULL.newInstance("请输入交易流水号。");
        }
        if (StringUtils.length(serialNo) != 24) {
            throw BuyBizException.PARAM_ILLEGAL.newInstance("交易流水号应该为24位，请重新输入。");
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
        // 校验用户是否冻结
        commonBiz.checkCustAbnStatus(custNo);

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

        // 获取产品信息
        FundInfoPO fundInfoPO = fundInfoDAO.getFundInfoByFundId(fundId);
        if (fundInfoPO == null) {
            throw BuyBizException.PRODUCT_NOT_EXISTS.newInstance("%s产品信息不存在", fundId);
        }

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
        TradeAccoInfoPO tradeAccoInfoPO = tradeAccoInfoDAO.getTradeAccoInfoByTradeAccoAndCustNo(tradeAcco, custNo);
        if (tradeAccoInfoPO == null) {
            // 交易账号不存在
            throw BuyBizException.TRADEACCO_NOT_EXISTS;
        }
        if (!TradeAccoStatusConsts.NORMAL.equalsIgnoreCase(tradeAccoInfoPO.getTradeAccoSt())) {
            throw BuyBizException.TRADEACCO_STATUS_ABN.newInstance("您的银行卡%s暂未绑定，请重新绑卡。", tradeAccoInfoPO.getBankAcco());
        }

        // 校验个人客户是否成年
        if (InvTpConsts.INDIVIDUAL.equals(custInfoPO.getInvTp()) && commonBiz.checkIsMinor(tradeAccoInfoPO.getBankIdNo())) {
            throw BuyBizException.MINOR_NOT_ALLOW_BUY;
        }

        // 校验交易账号是否为S-自助理财账户,限制配置宝交易账户
        if (!TradeAccoTypeConsts.SELF_SERVICE.equalsIgnoreCase(tradeAccoInfoPO.getAccountType())) {
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
        if (commonBiz.checkMarketIsFuse(fundId)) {
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
    }

    /**
     * 购买下单
     * @see com.zlfund.headstone.core.biz.AbstractProductBiz#submitBuy(com.zlfund.headstone.facade.trade.dto.BuyRequestDTO)
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    protected TradeRequestPO submitBuy(BuyRequestDTO buyRequestDTO) {
        // 首先查询流水是否存在 解决幂等问题
        String serialNo = buyRequestDTO.getSerialNo();
        TradeRequestPO tradeRequestPO = tradeRequestDAO.getTradeRequestBySerialNo(serialNo);
        if (tradeRequestPO != null) {
            // 如果存在直接返回
            return tradeRequestPO;
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

        // 校验交易可行性
        commonBiz.checkTradeAvailable(buyRequestDTO.getCustNo(), buyRequestDTO.getTradeAcco(), buyRequestDTO.getFundId(), apKind, buyRequestDTO.getSubAmt());

        TradeAccoInfoPO tradeAccoInfoPO = tradeAccoInfoDAO.getTradeAccoInfoByTradeAcco(buyRequestDTO.getTradeAcco());

        // 资金来源 默认从银行扣款
        String cashFrom = CashFromConsts.BANK;
        double subAmt = buyRequestDTO.getSubAmt();

        // 0-不重用撤单资金 1-重用撤单资金
        boolean reuseCapital = buyRequestDTO.isReuseCapital();

        double capitalBalance = 0.00;
        // 从留存资金扣除的金额
        double subrAmt = 0.00;
        // bidTp 是否使用撤单资金 0-不使用 1-使用
        if (reuseCapital) {
            // 查询可重用资金余额
            // TODO 暂调存储过程 后续可改为JAVA
            capitalBalance = tradeProcedureDAO.oqpGetCapitalbalanceTradeacco(tradeAccoInfoPO.getTradeAcco());

            if (capitalBalance < 0) {
                throw BuyBizException.ABNORMAL_CAPITAL_BALANCE;
            }

            if (capitalBalance < subAmt) {
                // 部分扣款 部分留存
                cashFrom = CashFromConsts.SECTION;
                subrAmt = capitalBalance;
            } else {
                // 全部留存
                cashFrom = CashFromConsts.REMNANT;
                subrAmt = buyRequestDTO.getSubAmt();
            }
        }

        // 获取当前工作日
        CurrentWorkDateBO currentWorkDateBO = dateTimeBiz.getCurrentCommonWorkDate(buyRequestDTO.getFundId(), apKind);

        // 写traderequest
        tradeRequestPO = new TradeRequestPO();
        // 这里的流水号需要外部传进来 解决幂等问题
        tradeRequestPO.setSerialNo(buyRequestDTO.getSerialNo());
        tradeRequestPO.setCustNo(buyRequestDTO.getCustNo());
        tradeRequestPO.setTradeAcco(buyRequestDTO.getTradeAcco());
        tradeRequestPO.setFundId(buyRequestDTO.getFundId());
        tradeRequestPO.setApKind(apKind);
        tradeRequestPO.setSubAmt(buyRequestDTO.getSubAmt());
        tradeRequestPO.setApDt(currentWorkDateBO.getCurrentDate());
        tradeRequestPO.setApTm(currentWorkDateBO.getCurrentTime());
        tradeRequestPO.setCashFrom(cashFrom);
        tradeRequestPO.setSubrAmt(subrAmt);
        tradeRequestPO.setWorkDate(currentWorkDateBO.getCurrentWorkDate());
        tradeRequestPO.setUpdateTimeStamp(dateTimeBiz.getCurrentTimeStamp());
        tradeRequestDAO.saveTradeRequest(tradeRequestPO);

        String applySt = "K";
        String paySt = null;
        if (CashFromConsts.REMNANT.equals(cashFrom)) {
            // 使用资金留存
            applySt = "N";
            paySt = "Y";
        }

        // 写traderequest_status
        TradeRequestStatusPO tradeRequestStatusPO = new TradeRequestStatusPO();
        tradeRequestStatusPO.setSerialNo(tradeRequestPO.getSerialNo());
        tradeRequestStatusPO.setPriorNo(tradeRequestPO.getSerialNo());
        tradeRequestStatusPO.setReferNo(tradeRequestPO.getSerialNo());
        tradeRequestStatusPO.setApplySt(applySt);
        tradeRequestStatusPO.setTransSt("N");
        tradeRequestStatusPO.setPaySt(paySt);
        tradeRequestStatusPO.setModifyFlag("N");
        tradeRequestStatusPO.setSeqNo(1);
        tradeRequestStatusPO.setCustNo(buyRequestDTO.getCustNo());
        tradeRequestStatusPO.setPayDt(null);
        tradeRequestStatusPO.setPayTm(null);
        tradeRequestStatusPO.setSummary(null);
        tradeRequestStatusPO.setUpdateTimeStamp(dateTimeBiz.getCurrentTimeStamp());
        tradeRequestStatusDAO.saveTradeRequestStatus(tradeRequestStatusPO);

        if (subrAmt > 0) {
            // 冻结留存资金
            capitalBalanceBiz.frozenCapitalBalance(buyRequestDTO.getCustNo(), buyRequestDTO.getTradeAcco(), subrAmt);
        }

        if (CashFromConsts.REMNANT.equals(cashFrom)) {
            // 直接写资金流水
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("serialNo", serialNo);
            param.put("apDt", tradeRequestPO.getWorkDate());
            param.put("apTm", tradeRequestPO.getApTm());
            param.put("ackDt", tradeRequestPO.getWorkDate());
            param.put("ackTm", tradeRequestPO.getApTm());
            param.put("apKind", tradeRequestPO.getApKind());
            param.put("capitalAmt", tradeRequestPO.getSubAmt());
            param.put("custNo", tradeRequestPO.getCustNo());
            param.put("tradeAcco", tradeRequestPO.getTradeAcco());
            param.put("capitalTp", "S");
            param.put("bankNo", tradeAccoInfoPO.getBankNo());
            param.put("bankAcco", tradeAccoInfoPO.getBankAcco());
            param.put("fundId", tradeRequestPO.getFundId());
            tradeProcedureDAO.ibfWriteCaptrade(param);
        } else {
            // 转账处理
            // 这里逻辑过于复杂 直接调用过程
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("serialNo", serialNo);
            param.put("custNo", tradeRequestPO.getCustNo());
            param.put("tadeTp", "B");
            param.put("apKind", tradeRequestPO.getApKind());
            param.put("tradeAcco", tradeRequestPO.getTradeAcco());
            param.put("amount", tradeRequestPO.getSubAmt());
            param.put("subrAmt", tradeRequestPO.getSubrAmt());
            param.put("fundId", tradeRequestPO.getFundId());
            tradeProcedureDAO.otpCaptialtdBid(param);
        }

        return tradeRequestPO;
    }
}
