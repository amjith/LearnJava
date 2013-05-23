package utils;
import java.util.HashSet;
import java.io.*;

public class LanguageIdentifier {
	public LanguageIdentifier(HashSet<String> dictionary) {
		super();
		this.dictionary = dictionary;
	}
	
	public LanguageIdentifier() {}
	
	public void initializeDictionary(String filename) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		String line = null;
		while ((line = reader.readLine()) != null){
			this.dictionary.add(line.toLowerCase());
		}
		reader.close();
	}
	
	private HashSet<String> dictionary = new HashSet<String>();
	
	public boolean isValidLanguage(String input, double accuracy) {
		String[] words = parseSentence(input);
		int validWordCount=0;
		
		for (String word: words) {
			if (this.dictionary.contains(word.toLowerCase())) {
				validWordCount++;
			}
			if (((double)validWordCount/words.length) > accuracy) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isValidLanguage(String input) {
		return isValidLanguage(input, 0.5);
	}
	
	private String[] parseSentence(String sentence) {
		 return sentence.split("\\s");
	}
}
