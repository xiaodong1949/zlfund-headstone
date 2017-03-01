/**
 * @Title BuyBiz.java 
 * @Package com.zlfund.headstone.core.biz 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月21日 上午10:08:52 
 * @version V1.0   
 */
package com.zlfund.headstone.core.biz.buy;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zlfund.headstone.common.exceptions.BizException;
import com.zlfund.headstone.core.biz.TradeCommonBiz;
import com.zlfund.headstone.core.dao.CustInfoDAO;
import com.zlfund.headstone.core.dao.FundInfoDAO;
import com.zlfund.headstone.core.dao.TradeAccoInfoDAO;
import com.zlfund.headstone.core.dao.TradeRequestDAO;
import com.zlfund.headstone.core.dao.TradeRequestStatusDAO;
import com.zlfund.headstone.core.dao.po.CustInfoPO;
import com.zlfund.headstone.core.dao.po.FundInfoPO;
import com.zlfund.headstone.core.dao.po.TradeAccoInfoPO;
import com.zlfund.headstone.core.dao.po.TradeRequestPO;
import com.zlfund.headstone.core.dao.po.TradeRequestStatusPO;
import com.zlfund.headstone.facade.trade.consts.ApKindConsts;
import com.zlfund.headstone.facade.trade.dto.BuyRequestDTO;
import com.zlfund.headstone.facade.trade.exception.BuyBizException;

/** 
 * 交易购买业务层接口实现类
 * @author: 徐文凡 
 * @since: 2017年2月21日 上午10:08:52 
 * @history:
 */
@Component("buyBiz")
public class FundBuyBiz {

    @Autowired
    private CustInfoDAO custInfoDAO;

    @Autowired
    private TradeAccoInfoDAO tradeAccoInfoDAO;

    @Autowired
    private TradeCommonBiz commonBiz;

    @Autowired
    private TradeRequestDAO tradeRequestDAO;

    @Autowired
    private TradeRequestStatusDAO tradeRequestStatusDAO;

    @Autowired
    private FundInfoDAO fundInfoDAO;

    /**
     * 购买前检查
     * @param buyRequestDTO 
     * @create: 2017年2月22日 下午3:57:50 
     * @author: 徐文凡
     * @history:
     */
    @Transactional()
    public void checkBeforeBuy(BuyRequestDTO buyRequestDTO) {
    }

    /**
     * 购买基金产品
     * @param buyRequest 购买请求
     * @return 
     * @create: 2017年2月21日 上午11:27:08 
     * @author: 徐文凡
     * @history:
     */
    @Transactional(rollbackFor = Exception.class)
    public TradeRequestPO buyFund(BuyRequestDTO buyRequest) {

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

        // 校验交易账号
        String tradeAcco = buyRequest.getTradeAcco();
        if (StringUtils.isBlank(tradeAcco)) {
            throw BuyBizException.PARAM_IS_NULL.newInstance("无法获取交易账号，请重新登录。");
        }
        // 校验交易账号长度

        // 校验购买金额
        double subAmt = buyRequest.getSubAmt();
        if (subAmt <= 0) {
            throw BuyBizException.PARAM_ILLEGAL.newInstance("购买金额必须大于0.00元，请重新输入。");
        }

        // 获取产品信息
        FundInfoPO fundInfoPO = fundInfoDAO.getFundInfoByFundId(fundId);
        if (fundInfoPO == null) {
            // 产品不存在
            throw BuyBizException.PRODUCT_NOT_EXISTS.newInstance("%s产品信息不存在", fundId);
        }

        // 获取交易类型
        String apKind = StringUtils.EMPTY;
        if ("0".equals(fundInfoPO.getFundSt())) {
            // 申购
            apKind = ApKindConsts.BID;
        } else if ("1".equals(fundInfoPO.getFundSt())) {
            // 认购
            apKind = ApKindConsts.SUB;
        }

        // 获取客户信息
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

        // 校验个人客户是否成年
        if ("1".equals(custInfoPO.getInvTp()) && commonBiz.checkIsMinor(tradeAccoInfoPO.getBankIdNo())) {
            throw BuyBizException.MINOR_NOT_ALLOW_BUY;
        }

        // 校验交易账号是否为S-自助理财账户,限制配置宝交易账户
        if (!"S".equalsIgnoreCase(tradeAccoInfoPO.getAccountType())) {
            // 配置宝交易账户只允许购买配置宝伴侣
            if (!"161608".equals(fundId)) {
                throw BuyBizException.ACCOUNT_TYPE_NOT_ALLOW_BUY;
            }
        }

        // 校验产品所属TA是否仅支持单交易账号
        if (commonBiz.checkSingleTradeAccoTA(fundId)) {
            throw BuyBizException.TA_LIMIT_SINGLE_TRADEACCO.newInstance("对不起，该产品暂时只支持使用%s的银行卡购买", tradeAccoInfoPO.getBankAcco());
        }

        // 校验银行渠道是否交易时间
        if (commonBiz.checkBankTradeTime(tradeAccoInfoPO.getBankNo())) {
            throw BuyBizException.BANK_CHANNEL_NOT_TRADE_TIME;
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

        // 校验交易可行性
        commonBiz.checkTradeAvailable(custNo, tradeAcco, fundId, apKind, subAmt);

        // 生成交易流水号
        String serialNo = commonBiz.newTradeSerialNo();

        // 判断是否重用撤单资金

        // 写TRADEREQUEST表
        TradeRequestPO tradeRequestPO = new TradeRequestPO();
        // set properties
        // ...
        int dbInsertResult = tradeRequestDAO.saveTradeRequest(tradeRequestPO);
        if (dbInsertResult != 1) {
            throw BizException.DB_INSERT_RESULT_0;
        }

        // 写TRADEREQUEST_STATUS表
        // set properties
        // ...
        TradeRequestStatusPO tradeRequestStatusPO = new TradeRequestStatusPO();
        dbInsertResult = tradeRequestStatusDAO.saveTradeRequestStatus(tradeRequestStatusPO);
        if (dbInsertResult != 1) {
            throw BizException.DB_INSERT_RESULT_0;
        }

        // 冻结留存资金金额

        // 如果需要扣款写BANK_COMMAND表
        if (!"R".equalsIgnoreCase(tradeRequestPO.getCashFrom())) {
            // 写BANK_COMMAND表
            // BankCommand bankCommand = new BankCommand();
        }

        // 写资金相关表 CAPITALTD CAPITALBLOTTER CAPITALSUM

        return tradeRequestPO;
    }

    /**
     * 购买质押宝
     * @param buyRequest 
     * @create: 2017年2月22日 上午9:26:34 
     * @author: 徐文凡
     * @history:
     */
    @Transactional(rollbackFor = Exception.class)
    public void buyZYB(BuyRequestDTO buyRequest) {
    }

    /**
     * 购买配置宝
     * @param buyRequest 
     * @create: 2017年2月22日 上午9:27:32 
     * @author: 徐文凡
     * @history:
     */
    public void buyPZB(BuyRequestDTO buyRequest) {
    }

}
