/**
 * @Title CapitalBalanceBiz.java 
 * @Package com.zlfund.headstone.core.biz 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月27日 下午6:45:01 
 * @version V1.0   
 */
package com.zlfund.headstone.core.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zlfund.headstone.common.exceptions.BizException;
import com.zlfund.headstone.core.dao.CapitalBalanceDAO;
import com.zlfund.headstone.core.dao.po.CapitalBalancePO;

/** 
 * 留存资金业务
 * @author: 徐文凡 
 * @since: 2017年2月27日 下午6:45:01 
 * @history:
 */
@Component("capitalBalanceBiz")
public class CapitalBalanceBiz {

    @Autowired
    DateTimeBiz dateTimeBiz;

    @Autowired
    CapitalBalanceDAO capitalBalanceDAO;

    /**
     * 冻结资金留存
     * @param custNo
     * @param tradeAcco
     * @param subAmt 
     * @create: 2017年2月27日 下午6:46:33 
     * @author: 徐文凡
     * @history:
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void frozenCapitalBalance(String custNo, String tradeAcco, double subAmt) {
        CapitalBalancePO capitalBalancePO = new CapitalBalancePO();
        capitalBalancePO.setCustNo(custNo);
        capitalBalancePO.setTradeAcco(tradeAcco);

        int count = capitalBalanceDAO.countCapitalBalance(capitalBalancePO);

        if (count == 0) {
            // save
            capitalBalancePO.setBalance(subAmt);
            capitalBalancePO.setAbnmFrozen(0.00);
            capitalBalancePO.setLastDate(dateTimeBiz.getCurrentDate());
            capitalBalancePO.setUpdateTimeStamp(dateTimeBiz.getCurrentTimeStamp());
            capitalBalancePO.setTransferStatus("S");
            capitalBalancePO.setReturnBalance(0.00);

            count = capitalBalanceDAO.saveCapitalBalance(capitalBalancePO);

            if (count != 1) {
                throw BizException.DB_INSERT_RESULT_0;
            }
        } else {
            capitalBalancePO = capitalBalanceDAO.getCapitalBalance(capitalBalancePO);

            // update
            double abnmFrozen = capitalBalancePO.getAbnmFrozen() + subAmt;
            capitalBalancePO.setAbnmFrozen(abnmFrozen);
            count = capitalBalanceDAO.updateCapitalBalance(capitalBalancePO);
            if (count != 1) {
                throw BizException.DB_UPDATE_RESULT_NE_1;
            }
        }
    }

}
