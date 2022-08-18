package com.HRA.helper;

import java.util.Base64;

public final class StringEncrypt {

	private StringEncrypt() {

	}

	/********************************************************************
	 *
	 * encryptXOR(String message, String key)
	 *
	 * Uses provided key to encrypt provided message using simple XOR
	 *
	 *********************************************************************/

	public static String encryptXOR(String message, String key) {

		try {
			if (message == null || key == null) {
				return null;
			} else {
				char[] keys = key.toCharArray();
				char[] mesg = message.toCharArray();

				int ml = mesg.length;
				int kl = keys.length;
				char[] newmsg = new char[ml];

				for (int i = 0; i < ml; i++) {
					newmsg[i] = (char) (mesg[i] ^ keys[i % kl]);
				}

				return Base64.getEncoder().encodeToString(new String(newmsg).getBytes());

			}

		} catch (Exception e) {
			return null;
		}

	}

	/********************************************************************
	 *
	 * decryptXOR(String message, String key)
	 *
	 * Uses provided key to decrypt provided message encrypted using the same
	 * key
	 *
	 *********************************************************************/

	public static String decryptXOR(String message, String key) {
		try {
			if (message == null || key == null)
				return null;
			char[] keys = key.toCharArray();

			char[] mesg = new String(Base64.getDecoder().decode(message)).toCharArray();
			int ml = mesg.length;
			int kl = keys.length;
			char[] newmsg = new char[ml];

			for (int i = 0; i < ml; i++) {
				newmsg[i] = (char) (mesg[i] ^ keys[i % kl]);
			}
			return new String(newmsg);
		} catch (Exception e) {
			return null;
		}
	}

}
