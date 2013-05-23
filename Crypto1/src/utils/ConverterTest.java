package utils;

import static org.junit.Assert.*;

import org.apache.commons.codec.DecoderException;
import org.junit.Test;
import java.util.HashMap;
import org.apache.commons.codec.binary.Hex;


public class ConverterTest {

	String base64String = "SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t";
	String hexString = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d";

	@Test
	public void testHexToBase64() throws DecoderException {		
//		System.out.println(new String(converter.hexToBase64(hexString.getBytes())));
		assertEquals(base64String, new String(Converter.hexToBase64(hexString.getBytes())));
	}
	
	@Test
	public void testBase64ToHex() {
		assertEquals(hexString, new String(Converter.base64ToHex(base64String.getBytes())));		
	}
	
	@Test
	public void testXor() throws DecoderException {
		String arg1 = "1c0111001f010100061a024b53535009181c";
		String arg2 = "686974207468652062756c6c277320657965";
		String result = "746865206b696420646f6e277420706c6179";
		//assertEquals(result, new String(Converter.xorBuffers(arg1.getBytes(), arg2.getBytes())));
		assertEquals(result, new String(Converter.rotatingXOR(arg1.getBytes(), arg2.getBytes())));
	}
	
	@Test
	public void testXor1() throws DecoderException {
		String arg1 = "1c0111001f010100061a024b53535009181c";
		String arg2 = "0a";
		System.out.println(new String(Converter.rotatingXOR(arg1.getBytes(), arg2.getBytes())));
		
	}

	
	@Test
	public void testFrequencyCounter() {
		String input = "CAABABC";
		HashMap<Character, Integer> result = new HashMap<Character, Integer>();
		result.put('A', 3);
		result.put('B', 2);
		result.put('C', 2);
		assertEquals(result, Converter.frequencyCounter(input));
	}
	
	@Test
	public void testEmptyStringFrequency() {
		String input = "";
		HashMap<Character, Integer> result = new HashMap<Character, Integer>();
		assertEquals(result, Converter.frequencyCounter(input));
	}
	
	@Test
	public void testXorDecoder() throws DecoderException {
		Hex h = new Hex();
		String input = "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736";
		for (int i = 0; i< 255 ; i++) {
//			String key = '0' + seed.substring(i, i+1);
			String key = String.valueOf(Character.toChars(i));
//			String result = new String(Converter.rotatingXOR(input.getBytes(), key.getBytes()));
			byte[] result = Converter.rotatingXOR(input.getBytes(), key.getBytes());
			System.out.println(key + "=" + new String(h.decode(result)));
		}
	}
}
