package com.zlfund.headstone.common.security.pbkdf2.de.rtner.security.auth.spi;

import com.zlfund.headstone.common.security.util.Base64Helper;

import java.io.UnsupportedEncodingException;


/**
 * <p>
 * Title: DJangoFormatter
 * </p>
 * <p>
 * Description: 改造PBKDF2，适配django
 * </p>
 * <p>
 * Company: zlfund
 * </p>
 * 
 * @author wangyanfeng
 * @date 2014年2月26日
 */
public class DJangoFormatter {

	public static boolean fromString(com.zlfund.headstone.common.security.pbkdf2.de.rtner.security.auth.spi.PBKDF2Parameters p, String s) throws UnsupportedEncodingException {
		String PLACEHOLDER = "\\$";
		if (p == null || s == null) {
			return false;
		}
		String[] p123 = s.split(PLACEHOLDER);

		if (p123 == null || p123.length != 4) {
			return false;
		}

		int iterationCount = Integer.parseInt(p123[1]);
		byte salt[] = p123[2].getBytes("ISO-8859-1");
		byte bDK[] = Base64Helper.decode(p123[3]);

		p.setSalt(salt);
		p.setIterationCount(iterationCount);
		p.setDerivedKey(bDK);
		return true;
	}

	public static String toString(PBKDF2Parameters p) throws UnsupportedEncodingException {
		String PLACEHOLDER = "$";
		String hashAlgorithm = "pbkdf2_sha256";

		String s = hashAlgorithm + PLACEHOLDER + String.valueOf(p.getIterationCount()) + PLACEHOLDER
				+ new String(p.getSalt(), "ISO-8859-1") + PLACEHOLDER +  Base64Helper.encode(p.getDerivedKey());
		return s;
	}

}
