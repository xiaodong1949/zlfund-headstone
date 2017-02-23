package com.zlfund.headstone.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;

/**
 * 帐户业务工具类
 * @author Yang Xiaodong
 * @since: 2017年2月23日
 */
public class AccountManageUtil {

    /** 
     * 检查手机号码 
     * 以1开头的11为数字
     * @param mobileno
     * @return 
     * @create: 2017年2月23日
     * @author: Yang Xiaodong
     * @history: 
     */
    public static boolean isMobileno(String mobileno) {
        if (StringUtils.isBlank(mobileno)) {
            return false;
        }
        String regex = "^1\\d{10}$";
        return match(regex, mobileno);
    }

    /** 
     * 检查密码
     * @param password
     * @return 
     * @create: 2017年2月23日
     * @author: Yang Xiaodong
     * @history: 
     */
    public static String verifyPassword(String password, String idno) {
        if (password.contains(" ")) {
            return "密码不能包含空格";
        }
        if (password.length() < 6) {
            return "密码至少需要6位";
        }
        if (match("^\\d*$", password)) {
            return "密码不能全是数字";
        }
        if (match("^[a-zA-Z]*$", password)) {
            return "密码不能全是字母";
        }
        if (StringUtils.isNotBlank(idno) && idno.equalsIgnoreCase(password)) {
            return "密码不能为身份证号";
        }
        return "";
    }

    /** 
     * 正则匹配
     * @param regex
     * @param str
     * @return
     * @return 
     * @create: 2017年2月23日
     * @author: Yang Xiaodong
     * @history: 
     */
    public static boolean match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    /** 
     * 打印debug日志
     * @param log
     * @param msg
     * @return 
     * @create: 2017年2月23日
     * @author: Yang Xiaodong
     * @history: 
     */
    public static void logDebug(Log log, String msg) {
        if (log.isDebugEnabled()) {
            log.debug(msg);
        }
    }

}
