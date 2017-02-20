package com.zlfund.headstone.facade.account.enums;

/**
 * @描述: 账户状态. 适用于账户表.
 * @版本: 1.0 .
 */
public enum AccountStatusEnum {

    /**
     * 激活
     */
    ACTIVE("激活", 100),
    /**
     * 冻结
     */
    INACTIVE("冻结", 101),

    /**
     * 注销
     */
    CANCELLED("注销", 102);

    /**
     * 枚举值
     */
    private int value;

    /**
     * 描述
     */
    private String desc;

    private AccountStatusEnum(String desc, int value) {
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

    public static AccountStatusEnum getEnum(int value) {
        AccountStatusEnum resultEnum = null;
        AccountStatusEnum[] enumAry = AccountStatusEnum.values();
        for (int i = 0; i < enumAry.length; i++) {
            if (enumAry[i].getValue() == value) {
                resultEnum = enumAry[i];
                break;
            }
        }
        return resultEnum;
    }


}
