/**
 * @Title buyFacadeImpl.java 
 * @Package com.zlfund.headstone.facade.trade.service.impl 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月20日 下午6:57:43 
 * @version V1.0   
 */
package com.zlfund.headstone.facade.trade.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zlfund.headstone.common.exceptions.BizException;
import com.zlfund.headstone.core.biz.buy.FundBuyBiz;
import com.zlfund.headstone.core.biz.fund.FundBiz;
import com.zlfund.headstone.facade.trade.dto.BuyRequestDTO;
import com.zlfund.headstone.facade.trade.dto.BuyResultDTO;
import com.zlfund.headstone.facade.trade.service.BuyFacade;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月20日 下午6:57:43 
 * @history:
 */
@Component("buyFacade")
public class BuyFacadeImpl implements BuyFacade {

    private static final Logger LOG = Logger.getLogger(BuyFacadeImpl.class);

    @Autowired
    private FundBuyBiz buyBiz;

    @Autowired
    private FundBiz fundBiz;

    /** 
     * @see com.zlfund.headstone.facade.trade.service.BuyFacade#buy(com.zlfund.headstone.facade.trade.dto.BuyRequestDTO)
     */
    @Override
    public BuyResultDTO buy(BuyRequestDTO buyRequest) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("buy request:" + buyRequest);
        }

        BuyResultDTO buyResultDTO = new BuyResultDTO();
        try {
            fundBiz.buy(buyRequest);

            // 下单
            buyBiz.buyFund(buyRequest);

            buyResultDTO.setSuccess(true);
            buyResultDTO.setErrCode(00000000);
            buyResultDTO.setErrMsg("成功");
            buyResultDTO.setErrDetailMsg("成功");
        } catch(BizException bizEx) {
            // TODO 利用Spring AOP统一处理异常

            // 业务异常
            buyResultDTO.setSuccess(false);
            buyResultDTO.setErrCode(bizEx.getCode());
            buyResultDTO.setErrMsg(bizEx.getMsg());
            buyResultDTO.setErrDetailMsg(bizEx.getDetailMsg());
        } catch(Exception e) {
            // 运行时异常
            buyResultDTO.setSuccess(false);
            buyResultDTO.setErrCode(99999999);
            buyResultDTO.setErrMsg("内部错误，请联系客服");
            buyResultDTO.setErrDetailMsg(e.getLocalizedMessage());

            // 错误邮件报警
            // Mail and sms send error message

        }

        return buyResultDTO;
    }
}
