package com.zlfund.headstone.common.security;

import com.zlfund.headstone.common.security.pbkdf2.de.rtner.security.auth.spi.DJangoFormatter;
import com.zlfund.headstone.common.security.pbkdf2.de.rtner.security.auth.spi.PBKDF2Engine;
import com.zlfund.headstone.common.security.pbkdf2.de.rtner.security.auth.spi.PBKDF2Parameters;

import java.util.Random;


/**
 * <p>
 * Title: PBKDF2ForDJango
 * </p>
 * <p>
 * Description: 实现django的加密、验证算法
 * </p>
 * <p>
 * Company: zlfund
 * </p>
 *
 * @author wangyanfeng
 * @date 2014年2月26日
 */
public class DJangoEncUtil {
    private static char[] SEEDCHARS = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2',
            '3', '4', '5', '6', '7', '8', '9'};

    public static String genRandomStr(int len) {
        char[] ret = new char[len];
        Random r = new Random();
        for (int i = 0; i < len; i++) {
            int curPos = r.nextInt(SEEDCHARS.length);
            ret[i] = SEEDCHARS[curPos];
        }
        return new String(ret);

    }

    /**
     * <p>
     * Title: encrypt
     * </p>
     * <p>
     * Description: 按django方式对密码进行加密
     * </p>
     *
     * @param oriPwd 原密码
     * @return
     * @author wangyanfeng
     * @date 2014年2月26日
     */
    public static String encrypt(String oriPwd) {
        try {
            byte[] salt = genRandomStr(12).getBytes();
            int iterations = 10000;
            PBKDF2Parameters p = new PBKDF2Parameters("HmacSHA256", "ISO-8859-1", salt, iterations);
            PBKDF2Engine e = new PBKDF2Engine(p);
            p.setDerivedKey(e.deriveKey(oriPwd));
            return DJangoFormatter.toString(p);
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * <p>
     * Title: verify
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param oriPwd 待验证的密码(原始密码，未加密)
     * @param encPwd 已经加密的密码
     * @return
     * @author wangyanfeng
     * @date 2014年2月26日
     */
    public static boolean verify(String oriPwd, String encPwd) {
        try {
            PBKDF2Parameters p = new PBKDF2Parameters();
            p.setHashAlgorithm("HmacSHA256");
            p.setHashCharset("ISO-8859-1");
            if (!DJangoFormatter.fromString(p, encPwd)) {
                throw new IllegalArgumentException("Candidate data does not have correct format (\"" + encPwd + "\")");
            }
            PBKDF2Engine e = new PBKDF2Engine(p);
            return e.verifyKey(oriPwd);
        } catch (Exception e) {
            return false;
        }

    }

    public static void main(String[] args) {
        String oripwd = "wyf@2017";
        String endpwd = encrypt(oripwd);
        System.out.println(endpwd);
        System.out.println(verify(oripwd, endpwd));

        oripwd = "wyf@790909";
        endpwd = "pbkdf2_sha256$10000$j7TLwt6A2djQ$bZ5zIzIUio3JaRttZAM7AGVo010SOoF+CYWOrQZKqQ0=";
        System.out.println(verify(oripwd, endpwd));
    }
}
