package com.revature.util;

public class Encryptor {

	public static String hashPassword(String password) {
		StringBuilder hash = new StringBuilder();
		
		/*
		 * TODO implement better encryption, for now reverse string
		 */
		
		for (int i = password.length() - 1; i >= 0; i--) {
			hash.append(password.charAt(i));
		}
		
		String hashPass = new String(hash);
		
		return hashPass;
	}
}
