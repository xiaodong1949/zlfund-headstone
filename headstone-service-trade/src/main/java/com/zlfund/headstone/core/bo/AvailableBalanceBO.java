/**
 * @Title AvailableBalanceBO.java 
 * @Package com.zlfund.headstone.core.bo 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月27日 上午11:30:55 
 * @version V1.0   
 */
package com.zlfund.headstone.core.bo;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月27日 上午11:30:55 
 * @history:
 */
public class AvailableBalanceBO {

    // 总份额
    private double balance = 0.00;

    // 可用份额
    private double availableBalance = 0.00;

    // 被冻结份额
    private double frozenBalance = 0.00;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public double getFrozenBalance() {
        return frozenBalance;
    }

    public void setFrozenBalance(double frozenBalance) {
        this.frozenBalance = frozenBalance;
    }

    @Override
    public String toString() {
        return "AvailableBalanceBO [balance=" + balance + ", availableBalance=" + availableBalance + ", frozenBalance=" + frozenBalance + "]";
    }

}
