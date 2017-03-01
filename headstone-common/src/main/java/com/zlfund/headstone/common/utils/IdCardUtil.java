package com.zlfund.headstone.common.utils;

import java.util.Calendar;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * 身份证工具类
 * @author: 徐文凡 
 * @since: 2017年2月28日 上午10:34:49 
 * @history:
 */
public class IdCardUtil {

    private static final Logger logger = Logger.getLogger(IdCardUtil.class);

    /**
     * 根据身份证号码查询年龄
     * 
     * @param id
     * @return
     */
    public static int getAgeById(String id) {
        if (StringUtils.isEmpty(id) || (id.trim().length() != 15 && id.trim().length() != 18)) {
            logger.error("身份证号码不合法, id = " + id);
            return 0;
        }

        Calendar cal = Calendar.getInstance();
        int nowYear = cal.get(Calendar.YEAR);
        int nowMonth = cal.get(Calendar.MONTH) + 1;
        // System.out.println("now = " + nowYear + "/" + nowMonth);
        int len = id.trim().length();
        // System.out.println("len = " + len);
        int IDYear, IDMonth;

        if (len == 18) {
            IDYear = Integer.parseInt(id.substring(6, 10));
            IDMonth = Integer.parseInt(id.substring(10, 12));
            if (IDMonth - nowMonth > 0) {
                return nowYear - IDYear - 1;
            } else {
                return nowYear - IDYear;
            }
        } else if (len == 15) {
            IDYear = Integer.parseInt(id.substring(6, 8)) + 1900;
            IDMonth = Integer.parseInt(id.substring(8, 10));
            if (IDMonth - nowMonth > 0) {
                return nowYear - IDYear - 1;
            } else {
                return nowYear - IDYear;
            }
        } else {
            return 0;
        }
    }

    public static String getGenderById(String id) {
        if (StringUtils.isEmpty(id) || (id.trim().length() != 15 && id.trim().length() != 18)) {
            logger.error("身份证号码不合法, id = " + id);
            return "男";
        }

        id = id.trim();
        String lastValue;
        if (id.length() == 15) {
            lastValue = id.substring(id.length() - 1, id.length());
        } else {
            lastValue = id.substring(id.length() - 2, id.length() - 1);
        }
        int sex;
        if (lastValue.trim().toLowerCase().equals("x") || lastValue.trim().toLowerCase().equals("e")) {
            return "男";
        } else {
            sex = Integer.parseInt(lastValue) % 2;
            return sex == 0 ? "女" : "男";
        }
    }

    public static String mask(String id) {
        String ret = "";
        if (StringUtils.isBlank(id)) {
            return ret;
        }
        if (id.length() == 15) {
            ret = StringUtils.substring(id, 0, 3) + "*********" + StringUtils.substring(id, 12, 15);
        } else if (id.length() == 18) {
            ret = StringUtils.substring(id, 0, 3) + "************" + StringUtils.substring(id, 15, 18);
        } else {
            ret = id;
        }
        return ret;
    }

    /** 
     * 根据15位身份证获取18位身份证或根据18位身份证获取15位身份证
     * @param idno
     * @return 
     * @create: 2014年6月24日 下午4:45:32 
     * @author: Yang Xiaodong
     * @history: 
     */
    public static String getOtherIdNo(String idno) {
        String oidno = "";
        int sum;
        if (idno.length() == 15) {
            oidno = idno.substring(0, 6) + "19" + idno.substring(6, 15);// 加入年份前的19
            sum = Integer.parseInt(oidno.substring(0, 1)) * 7 + Integer.parseInt(oidno.substring(1, 2)) * 9 + Integer.parseInt(oidno.substring(2, 3)) * 10
                    + Integer.parseInt(oidno.substring(3, 4)) * 5 + Integer.parseInt(oidno.substring(4, 5)) * 8 + Integer.parseInt(oidno.substring(5, 6)) * 4
                    + Integer.parseInt(oidno.substring(6, 7)) * 2 + Integer.parseInt(oidno.substring(7, 8)) * 1 + Integer.parseInt(oidno.substring(8, 9)) * 6
                    + Integer.parseInt(oidno.substring(9, 10)) * 3 + Integer.parseInt(oidno.substring(10, 11)) * 7 + Integer.parseInt(oidno.substring(11, 12))
                    * 9 + Integer.parseInt(oidno.substring(12, 13)) * 10 + Integer.parseInt(oidno.substring(13, 14)) * 5
                    + Integer.parseInt(oidno.substring(14, 15)) * 8 + Integer.parseInt(oidno.substring(15, 16)) * 4 + Integer.parseInt(oidno.substring(16, 17))
                    * 2;
            if (sum % 11 == 0) {
                oidno = oidno + "1";
            } else if (sum % 11 == 1) {
                oidno = oidno + "0";
            } else if (sum % 11 == 2) {
                oidno = oidno + "X";
            } else {
                int i = 12 - (sum % 11);
                oidno = oidno + Integer.toString(i);
            }
        } else if (idno.length() == 18) {
            oidno = idno.substring(0, 6) + idno.substring(8, 17);
        }
        return oidno.toUpperCase();
    }
}
