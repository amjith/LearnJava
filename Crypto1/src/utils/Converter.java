package utils;

import java.util.HashMap;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

public class Converter {
	
	public static byte[] hexToBase64(byte[] hexValue) throws DecoderException{
		Hex hex = new Hex();
		byte[] decodedHex = hex.decode(hexValue);
		return Base64.encodeBase64(decodedHex);
	}
	
	public static byte [] base64ToHex(byte[] base64Value) {
		byte[] decodedBase64 = Base64.decodeBase64(base64Value);
		Hex hex = new Hex();
		return hex.encode(decodedBase64);
	}
	
	public static byte[] xorBuffers(byte[] arg1, byte[] arg2) throws DecoderException {
		if (arg1.length != arg2.length) { 
			return null;
		}
		Hex hex = new Hex();
		byte[] decodedArg1 = hex.decode(arg1);
		byte[] decodedArg2 = hex.decode(arg2);
		byte[] result = new byte[decodedArg1.length]; 
		
		for (int i = 0; i < decodedArg1.length; i++) {
			result[i] = (byte) (decodedArg1[i] ^ decodedArg2[i]);
		}
		
		return hex.encode(result);
	}
	
	public static byte[] xorSingleChar(byte[] input, byte key) throws DecoderException {
		if (input.length < 1) {
			return null;
		}
		Hex hex = new Hex();
		byte[] decodedInput = hex.decode(input);
		byte[] result = new byte[decodedInput.length]; 
		int i = 0;
		for (byte c: decodedInput) {
			result[i++] = (byte) (c ^ key);
		}
		return result;
	}
	
	public static byte[] rotatingXOR(byte[] input, byte[] key) throws DecoderException {
		Hex hex = new Hex();
		byte[] decodedInput = hex.decode(input);
		byte[] decodedKey = hex.decode(key);
		byte[] result = new byte[decodedInput.length];
		for (int i = 0; i < decodedInput.length; ) {
			for (int j = 0; j < decodedKey.length; j++, i++) {
				result[i] = (byte) (decodedInput[i] ^ decodedKey[j]); 
			}
		}
		return hex.encode(result);
	}
	
	public static HashMap<Character, Integer> frequencyCounter(String input) {
		HashMap<Character, Integer> result = new HashMap<Character, Integer>();
		for (Character c: input.toCharArray()) {
			if (result.containsKey(c)) { 
				result.put(c, result.get(c) + 1);
			}
			else {
				result.put(c, 1);
			}
		}
		return result;
	}
}