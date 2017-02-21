package com.zlfund.headstone.facade.account.entity;

import com.zlfund.headstone.common.dto.BaseEntity;
import com.zlfund.headstone.facade.account.enums.AccountActionEnum;

/**
 * Class description
 *
 *
 * @version        V1.0.0, 2017-01-11
 * @author         yanfengking@163.com
 */
public class CustHistory extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private String            custno;
    private AccountActionEnum actionType;
    private String            actionDateTime;

    /**
     * Method description
     *
     * @return
     */
    public String getActionDateTime() {
        return actionDateTime;
    }

    /**
     * Method description
     *
     * @param actionDateTime
     */
    public void setActionDateTime(String actionDateTime) {
        this.actionDateTime = actionDateTime;
    }

    /**
     * Method description
     *
     * @return
     */
    public AccountActionEnum getActionType() {
        return actionType;
    }

    /**
     * Method description
     *
     * @param actionType
     */
    public void setActionType(AccountActionEnum actionType) {
        this.actionType = actionType;
    }

    /**
     * Method description
     *
     * @return
     */
    public String getCustno() {
        return custno;
    }

    /**
     * Method description
     *
     * @param custno
     */
    public void setCustno(String custno) {
        this.custno = custno;
    }
}

