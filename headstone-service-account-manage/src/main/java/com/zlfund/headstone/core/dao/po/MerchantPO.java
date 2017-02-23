package com.zlfund.headstone.core.dao.po;

import java.io.Serializable;

/**
 * DB:trade
 * table ： MERCHANT
 * @author Yang Xiaodong
 * @since: 2017年2月22日
 */
public class MerchantPO extends AccountManageBasePO implements Serializable {

    private static final long serialVersionUID = -1172153128782422911L;

    private String mctcode;

    private String cancelfromzl;

    private String mctfrom;

    private String mctname;

    private String mctstatus;

    private String partnerno;

    private String redfromzl;

    /**
     * @return the mctcode
     */
    public String getMctcode() {
        return mctcode;
    }

    /**
     * @param mctcode the mctcode to set
     */
    public void setMctcode(String mctcode) {
        this.mctcode = mctcode;
    }

    /**
     * @return the cancelfromzl
     */
    public String getCancelfromzl() {
        return cancelfromzl;
    }

    /**
     * @param cancelfromzl the cancelfromzl to set
     */
    public void setCancelfromzl(String cancelfromzl) {
        this.cancelfromzl = cancelfromzl;
    }

    /**
     * @return the mctfrom
     */
    public String getMctfrom() {
        return mctfrom;
    }

    /**
     * @param mctfrom the mctfrom to set
     */
    public void setMctfrom(String mctfrom) {
        this.mctfrom = mctfrom;
    }

    /**
     * @return the mctname
     */
    public String getMctname() {
        return mctname;
    }

    /**
     * @param mctname the mctname to set
     */
    public void setMctname(String mctname) {
        this.mctname = mctname;
    }

    /**
     * @return the mctstatus
     */
    public String getMctstatus() {
        return mctstatus;
    }

    /**
     * @param mctstatus the mctstatus to set
     */
    public void setMctstatus(String mctstatus) {
        this.mctstatus = mctstatus;
    }

    /**
     * @return the partnerno
     */
    public String getPartnerno() {
        return partnerno;
    }

    /**
     * @param partnerno the partnerno to set
     */
    public void setPartnerno(String partnerno) {
        this.partnerno = partnerno;
    }

    /**
     * @return the redfromzl
     */
    public String getRedfromzl() {
        return redfromzl;
    }

    /**
     * @param redfromzl the redfromzl to set
     */
    public void setRedfromzl(String redfromzl) {
        this.redfromzl = redfromzl;
    }

}
