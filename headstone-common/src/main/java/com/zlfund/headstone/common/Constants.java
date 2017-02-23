package com.zlfund.headstone.common;

import java.util.regex.Pattern;

/**
 * headstone系统公共常量类
 * @author: 徐文凡 
 * @since: 2017年2月23日 上午10:07:44 
 * @history:
 */
public class Constants {

    public static final String COMMA_SEPARATOR = ",";

    public static final Pattern COMMA_SPLIT_PATTERN = Pattern.compile("\\s*[,]+\\s*");

    public final static String PATH_SEPARATOR = "/";

    // 客户号长度
    public final static int CUSTNO_LENGTH = 10;

    public final static String SUCCESS_CODE = "00000000";
}
