package com.zlfund.headstone.facade.account.enums;

/**
 * 用戶賬戶動作
 *
 */
public enum AccountActionEnum {


    LOGIN("登录", 1),


    LOGOUT("退出", 0);


    /**
     * 枚举值
     */
    private int value;

    /**
     * 描述
     */
    private String desc;

    private AccountActionEnum(String desc, int value) {
        this.value = value;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
