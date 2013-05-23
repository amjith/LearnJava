package utils;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class LanguageIdentifierTest {
	
	@Test
	public void testInvalidSingleWord() throws IOException {
		LanguageIdentifier li = new LanguageIdentifier();
		li.initializeDictionary("/usr/share/dict/words");
		assertFalse(li.isValidLanguage("abc"));
	}

	@Test
	public void testInvalidSentence() throws IOException {
		LanguageIdentifier li = new LanguageIdentifier();
		li.initializeDictionary("/usr/share/dict/words");
		assertFalse(li.isValidLanguage("abc xyz qret"));
	}

	@Test
	public void testValidSingleWord() throws IOException {
		LanguageIdentifier li = new LanguageIdentifier();
		li.initializeDictionary("/usr/share/dict/words");
		assertTrue(li.isValidLanguage("baby"));
	}
	
	@Test
	public void testValidSentence() throws IOException {
		LanguageIdentifier li = new LanguageIdentifier();
		li.initializeDictionary("/usr/share/dict/words");
		assertTrue(li.isValidLanguage("this is a valid sentence"));
	}
}
