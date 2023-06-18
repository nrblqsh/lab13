package server;
/**
 * This class will translate the word from client based on targeted language
 * 
 * @author norbalqish
 *
 */

public class TranslationRequest {

	public static String translate(String word,String targetLanguage) {
		
		if(targetLanguage.equals("Bahasa Melayu")) {
			
			return "Ada apa?";
		}
		else if(targetLanguage.equals("Korean"))
		{
			return "뭐야?";
		}
		else if(targetLanguage.equals("Arabic"))
		{
			return "ما أخبارك؟";
		}
		
		else{
			
			return "The language is not available";
		}
		
	}
}