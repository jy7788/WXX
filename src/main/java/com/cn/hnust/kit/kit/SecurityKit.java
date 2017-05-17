package com.cn.hnust.kit.kit;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityKit {

	/**
	 * @param str
	 * @return
	 */
	public static String sha1(String str) {
		try {
			StringBuffer sb = new StringBuffer();
			MessageDigest digest = MessageDigest.getInstance("sha1");
			digest.update(str.getBytes());
			byte[] digestMsg = digest.digest();
			for(byte b:digestMsg) {
				sb.append(String.format("%02x", b));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}
