package service;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class EncryptionPassword {

	public String Save(String password) {

		Encoder encoder = Base64.getEncoder();
		String originalString = password;
		String encodedString = encoder.encodeToString(originalString.getBytes());
		return encodedString;
	}

	public String Check(String decode) {

		Decoder decoder = Base64.getDecoder();
		byte[] bytes = decoder.decode(decode);
		return new String(bytes);
	}

}
