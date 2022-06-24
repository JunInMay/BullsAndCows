package logic;

import customException.DeficientInputLengthException;

public class Validator {
	public static void lengthCheck(String inputText, int length) throws DeficientInputLengthException {
		if (inputText.length() != length) {
			throw new DeficientInputLengthException();
		}
	}
	public static void integerCheck(String inputText) {
		String[] inputTextArray = inputText.split("");
		
		for (char character : inputText.toCharArray()) {
			int asciiCharacter = (int) character;
			if (asciiCharacter < 48 || asciiCharacter > 57) {
				throw new NumberFormatException();
			}
		}
	}
}