package password;

import java.util.Random;

/**
 * Develop a utility class that can be used to generate random passwords. It can
 * also be used to encrypt/decrypt texts, passwords
 */

public class PasswordGenerator {

	/**
	 * METHODS MENU: getRandomUppercaseLetters getRandomLowercaseLetters
	 * getRandomSpecialChars getRandomNumbers generatePassword encryptText
	 * decryptText
	 */

	public static void main(String[] args) {
		PasswordGenerator pg = new PasswordGenerator();
		System.out.println("------getRandomUppercaseLetters-----");
		System.out.println(pg.getRandomUppercaseLetters(3));

		System.out.println("------getRandomLowercaseLetters-----");
		System.out.println(pg.getRandomLowercaseLetters(3));

		System.out.println("------getRandomSpecialChars-----");
		System.out.println(pg.getRandomSpecialChars(3));

		System.out.println("------getRandomNumbers-----");
		System.out.println(pg.getRandomNumbers(3));

		System.out.println("------generatePassword-----");
		System.out.println(pg.generatePassword(2, 5, 2, 3));

		System.out.println("------encryptText-----");
		System.out.println(pg.encryptText("HELLO"));

		System.out.println("------decryptText-----");
		System.out.println(pg.decryptText("HELLO"));
		
		System.out.println("------encryptChar-----");
		System.out.println(pg.encryptChar("H"));
		

	}

	String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
	String specialChars = "!@#$%^&*(_";
	String numbers = "0123456789";
	
	String upperCipherAlphabet = "PHQGIUMEAYLNOFDXJKRCVSTZWB";
	String lowerCipherAlphabet = "phqgiumeaylnofdxjkrcvstzwb";
	
	NumbersUtil numsUtil = new NumbersUtil();

	/**
	 * Method that accepts a number and returns that many random 
	 * letters taken from upperCaseLetters variable above
	 * 
	 * @param count
	 * @return String
	 */
	public String getRandomUppercaseLetters(int count) {
		
		String	randomStr ="";
		
		for(int i=1; i<=count;i++) {
			
		int index=numsUtil.getRandomInt(upperCaseLetters.length());

			
		randomStr += upperCaseLetters.charAt(index) + "";
		
		
		}
		return randomStr;
		
		
	}
	
	/**
	 * Method that accepts a number and returns that many random 
	 * letters taken from lowerCaseLetters variable above
	 * 
	 * @param count
	 * @return String
	 */

	public String getRandomLowercaseLetters(int count) {
		
String	randomStr ="";
		
		for(int i=1; i<=count;i++) {
			
		int index=numsUtil.getRandomInt(lowerCaseLetters.length());

			
		randomStr += lowerCaseLetters.charAt(index) + "";
		
		
		}
		return randomStr;
		
		
		
	}
	/**
	 * Method that accepts a number and returns that many random 
	 * characters taken from specialChars variable above
	 * 
	 * @param count
	 * @return String
	 */
	public String getRandomSpecialChars(int count) {
		
		String	randomStr ="";
		
		for(int i=1; i<=count;i++) {
			
		int index=numsUtil.getRandomInt(specialChars.length());

			
		randomStr += specialChars.charAt(index) + "";
		
		
		}
		return randomStr;
		
		
		
	}
	
	/**
	 * Method that accepts a number and returns that many random 
	 * numbers taken from numbers variable above
	 * 
	 * @param count
	 * @return String
	 */

	public String getRandomNumbers(int count) {
		
		String	randomStr ="";
		
		for(int i=1; i<=count;i++) {
			
		int index=numsUtil.getRandomInt(numbers.length());

			
		randomStr += numbers.charAt(index) + "";
		
		
		}
		return randomStr;
		
	}

	/**
	 * Write a method that returns a password which is 
	 * mix of uppercase and lowercase letters and special characters,numbers.
	 * This method calls 4 other methods.
	 * 
	 * @param upper - how many uppercase letters -> pass to getRandomUppercaseLetters
	 * @param lower - how many lowercase letters -> pass to getRandomLowercaseLetters
	 * @param special - how many special characters -> pass to getRandomSpecialChars
	 * @param num - how many numbers -> pass to getRandomNumbers
	 * @return String - generated password by using methods above
	 */
	
	public String generatePassword(int upper, int lower, int special, int num) {
		
//			getRandomLowercaseLetters(lower);
//			
//			getRandomUppercaseLetters(upper);
//			
//			getRandomSpecialChars(special);
//			
//			getRandomNumbers(num);
			
			String passport = getRandomLowercaseLetters(lower) +""+getRandomUppercaseLetters(upper)+ ""+getRandomSpecialChars(special) +""+getRandomNumbers(num);
			
		
		
		
	
		return passport;
		
		
	
	}

	
	
	/**
	    Accepts a character and returns encrypted version.
	    Take a character and covert to corresponding character by index
	    upperCaseLetters -> upperCipherAlphabet
		lowerCaseLetters -> lowerCipherAlphabet
		specialChars -> numbers
		numbers -> specialChars
	 * 
	 * 
	 * @param sChar - character to encrypt
	 * @return
	 */
	public String encryptChar(String sChar) {
		
		String enc="";
		if(upperCaseLetters.contains(sChar)) {
			
			int pos= upperCaseLetters.indexOf(sChar);
			enc= upperCipherAlphabet.charAt(pos)+"";
		}else if(lowerCaseLetters.contains(sChar)) {
			
			int pos= lowerCaseLetters.indexOf(sChar);
			enc= lowerCipherAlphabet.charAt(pos)+"";
		}else if(specialChars.contains(sChar)) {
					
					int pos= specialChars.indexOf(sChar);
					enc= numbers.charAt(pos)+"";
		}else if(numbers.contains(sChar)) {
			
			int pos= numbers.indexOf(sChar);
			enc= specialChars.charAt(pos)+"";
		}else if (sChar.equals(" ")){
			
			enc=" ";
			
		}else {
			System.out.println("FATAL ERROR.Cannot Encrypt!"+sChar);
			
			System.exit(0);
		}
		
		
		return enc; 

	}
	
	public String decryptChar(String sChar) {
		
		String decr="";
		if(upperCaseLetters.contains(sChar)) {
			
			int pos= upperCaseLetters.indexOf(sChar);
			decr= upperCipherAlphabet.charAt(pos)+"";
		}else if(lowerCaseLetters.contains(sChar)) {
			
			int pos= lowerCaseLetters.indexOf(sChar);
			decr= lowerCipherAlphabet.charAt(pos)+"";
		}else if(specialChars.contains(sChar)) {
					
					int pos= specialChars.indexOf(sChar);
					decr= numbers.charAt(pos)+"";
		}else if(numbers.contains(sChar)) {
			
			int pos= numbers.indexOf(sChar);
			decr= specialChars.charAt(pos)+"";
		}else if (sChar.equals(" ")){
			
			decr=" ";
			
		}else {
			System.out.println("FATAL ERROR.Cannot Encrypt!"+sChar);
			
			System.exit(0);
		}
		return decr;
		
	}
	/**
	 *  Accepts a text and returns encrypted version.
	 *  Take each character and covert to corresponding character by index
	    upperCaseLetters -> upperCipherAlphabet
		lowerCaseLetters -> lowerCipherAlphabet
		specialChars -> numbers
		numbers -> specialChars
	 * 
	 * 
	 * @param password
	 * @return
	 */
	public String encryptText(String text) {


		String encr="";
		
		for(int i =0; i<text.length();i++) {
			encr+= encryptChar(text.charAt(i)+"");
			
//		if(upperCaseLetters.contains(text.charAt(i)+"")) {
//			
//			int pos= upperCaseLetters.indexOf(text.charAt(i));
//			encr+= upperCipherAlphabet.charAt(pos)+"";
//		}else if(lowerCaseLetters.contains(text.charAt(i)+"")) {
//			
//			int pos= lowerCaseLetters.indexOf(text.charAt(i));
//			encr+= lowerCipherAlphabet.charAt(pos)+"";
//		}else if(specialChars.contains(text.charAt(i)+"")) {
//					
//					int pos= specialChars.indexOf(text.charAt(i));
//					encr+= numbers.charAt(pos)+"";
//		}else if(numbers.contains(text.charAt(i)+"")) {
//			
//			int pos= numbers.indexOf(text.charAt(i));
//			encr+= specialChars.charAt(pos)+"";
//		}else if (text.equals(" ")){
//			
//			encr=" ";
//			
//		}else {
//			System.out.println("FATAL ERROR.Cannot Encrypt!"+text);
//			
//			System.exit(0);
//		}
		
		}
		
		return encr;
	}
	
	/**
	    Accepts a text and returns decrypted version.
	    Take each character and covert to corresponding character by index
	    upperCipherAlphabet -> upperCaseLetters
		lowerCipherAlphabet -> lowerCaseLetters
		numbers -> specialChars
		specialChars -> numbers
	 * 
	 * 
	 * @param encryptedText - characters to decrypt
	 * @return
	 */
	public String decryptText(String encryptedText) {
		
		encryptText(encryptedText);
		
		String encre="";
		
		for(int i =0; i<encryptText(encryptedText).length();i++) {
			
			//encre+= encryptText(encryptedText.charAt(i)+"");
			
			
		if(upperCipherAlphabet.contains(encryptText(encryptedText).charAt(i)+"")) {
			
			int pos= upperCipherAlphabet.indexOf(encryptText(encryptedText).charAt(i));
			encre+= upperCaseLetters.charAt(pos)+"";
		}else if(lowerCipherAlphabet.contains(encryptText(encryptedText).charAt(i)+"")) {
			
			int pos= lowerCipherAlphabet.indexOf(encryptText(encryptedText).charAt(i));
			encre+= lowerCaseLetters.charAt(pos)+"";
		}else if(numbers.contains(encryptText(encryptedText).charAt(i)+"")) {
					
					int pos= numbers.indexOf(encryptText(encryptedText).charAt(i));
					encre+= specialChars.charAt(pos)+"";
		}else if(specialChars.contains(encryptText(encryptedText).charAt(i)+"")) {
			
			int pos= specialChars.indexOf(encryptText(encryptedText).charAt(i));
			encre+= numbers.charAt(pos)+"";
		}else if (encryptText(encryptedText).equals(" ")){
			
			encre=" ";
			
		}else {
			System.out.println("FATAL ERROR.Cannot Encrypt!"+encryptText(encryptedText));
			
			System.exit(0);
		}
		
		}
		
		return encre;
		
	}
}
