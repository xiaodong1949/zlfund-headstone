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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zlfund.headstone.common.Constants;
import com.zlfund.headstone.core.biz.AbstractProductBiz;
import com.zlfund.headstone.core.biz.TradeCommonBiz;
import com.zlfund.headstone.core.dao.CustInfoDAO;
import com.zlfund.headstone.core.dao.FundInfoDAO;
import com.zlfund.headstone.core.dao.TradeAccoInfoDAO;
import com.zlfund.headstone.core.dao.po.CustInfoPO;
import com.zlfund.headstone.core.dao.po.TradeAccoInfoPO;
import com.zlfund.headstone.facade.trade.consts.InvTpConsts;
import com.zlfund.headstone.facade.trade.dto.BuyRequestDTO;
import com.zlfund.headstone.facade.trade.exception.BuyBizException;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月22日 下午3:49:36 
 * @history:
 */
public class FundBiz extends AbstractProductBiz {

    @Autowired
    TradeCommonBiz commonBiz;

    @Autowired
    FundInfoDAO fundInfoDAO;

    @Autowired
    TradeAccoInfoDAO tradeAccoInfoDAO;

    @Autowired
    CustInfoDAO custInfoDAO;

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

        // 校验个人客户是否成年
        if (InvTpConsts.INDIVIDUAL.equals(custInfoPO.getInvTp()) && commonBiz.checkIsMinor(tradeAccoInfoPO.getBankIdNo())) {
            throw BuyBizException.MINOR_NOT_ALLOW_BUY;
        }
    }

    /**
     * 购买下单
     * @see com.zlfund.headstone.core.biz.AbstractProductBiz#submitBuy(com.zlfund.headstone.facade.trade.dto.BuyRequestDTO)
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    protected void submitBuy(BuyRequestDTO buyRequestDTO) {
        super.submitBuy(buyRequestDTO);
    }

}
