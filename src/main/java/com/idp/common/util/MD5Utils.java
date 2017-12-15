package com.idp.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;


public class MD5Utils {
	public static String encodeToMD5(String str) {
		return encodeToAlgorithm(str, "MD5");
	}

	public static String encodeToAlgorithm(String str, String algorithm) {
		if (str == null || str.length() == 0) {
			return null;
		}
		try {
			MessageDigest e = MessageDigest.getInstance(algorithm);
			byte[] digest = e.digest(str.getBytes());
			return new String(Hex.encodeHex(digest));
		} catch (NoSuchAlgorithmException var4) {

		}
		return null;
	}
	
	

}
