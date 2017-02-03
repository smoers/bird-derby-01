package org.bird.derby.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
 
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
 
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Base64.Decoder;
/*
* user specification: the function's comment should contain keys as follows: 1. write about the function's comment.but
* it must be before the "{talendTypes}" key.
*
* 2. {talendTypes} 's value must be talend Type, it is required . its value should be one of: String, char | Character,
* long | Long, int | Integer, boolean | Boolean, byte | Byte, Date, double | Double, float | Float, Object, short |
* Short
*
* 3. {Category} define a category for the Function. it is required. its value is user-defined .
*
* 4. {param} 's format is: {param} <type>[(<default value or closed list values>)] <name>[ : <comment>]
*
* <type> 's value should be one of: string, int, list, double, object, boolean, long, char, date. <name>'s value is the
* Function's parameter name. the {param} is optional. so if you the Function without the parameters. the {param} don't
* added. you can have many parameters for the Function.
*
* 5. {example} gives a example for the Function. it is optional.
*/
public class Encrypt {
 
 
	private static final char[] PASSWORD = "enfldsgbnlsngdlksdsgm".toCharArray();
	private static final byte[] SALT = {
			(byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12,
			(byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12,
	};
 
 
	/**
	* encrypt: Return an encrypted String.
	*
	* {talendTypes} String
	*
	* {Category} User Defined
	*
	* {param} string("world") input: The string need to be encrypted.
	*
	* {example} encrypt("Secret") # aebdgsjq01=
	*/
	public static String encrypt(String property) throws GeneralSecurityException, UnsupportedEncodingException {
		
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
		SecretKey key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD));
		Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
		pbeCipher.init(Cipher.ENCRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
		
		return base64Encode(pbeCipher.doFinal(property.getBytes("UTF-8")));
	}
 
	private static String base64Encode(byte[] bytes) {
		// NB: This class is internal, and you probably should use another impl
		Encoder enc = Base64.getEncoder();
		
		return enc.encodeToString( bytes );
	}
 
	/**
	* decrypt: Return an uncrypted String.
	*
	*
	* {talendTypes} String
	*
	* {Category} User Defined
	*
	* {param} string("aebdgsjq01=") input: The string need to be decrypted base64encoded.
	*
	* {example} decrypt("aebdgsjq01=") # Secret
	*/
	 
	public static String decrypt(String property) throws GeneralSecurityException, IOException {
		
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
		SecretKey key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD));
		Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
		pbeCipher.init(Cipher.DECRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
		
		return new String(pbeCipher.doFinal(base64Decode(property)), "UTF-8");
	}
	 
	private static byte[] base64Decode(String property) throws IOException {
		//NB: This class is internal, and you probably should use another impl
		Decoder dec = Base64.getDecoder();
		
		return dec.decode( property ) ;
	}
}
