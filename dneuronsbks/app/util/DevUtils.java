package util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DevUtils {

	public static void main(String[] args) {
		/*System.out.println(hashPassword("David", "david"));
		System.out.println(hashPassword("sam", "sam"));
		System.out.println(hashPassword("chris", "chris"));
		System.out.println(hashPassword("vivek", "vivek"));
		System.out.println(hashPassword("joel", "joel"));
		*/
		
		System.out.println(hashPassword("chris1", "chris1"));
		System.out.println(hashPassword("joel1", "joel1"));
		System.out.println(hashPassword("leon1", "leon1"));
		System.out.println(hashPassword("richard1", "richard1"));
		System.out.println(hashPassword("sathish1", "sathish1"));
		
	}

	public static String hashPassword(String username, String password) {

		// Adding username to hash input to prevent reverse password hacking
		String compoundPass = username + ":" + password;

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hashedBytes = md.digest(compoundPass.getBytes("UTF-8"));

			return convertByteArrayToHexString(hashedBytes);

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return compoundPass;
	}

	private static String convertByteArrayToHexString(byte[] arrayBytes) {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < arrayBytes.length; i++) {
			stringBuffer.append(Integer.toString(
					(arrayBytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		return stringBuffer.toString();
	}

}
