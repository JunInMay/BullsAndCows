package logic;

import customException.DeficientInputLengthException;
import customException.IntegerInputException;

public class Validator {
	public static void lengthCheck(String inputText, int length) throws DeficientInputLengthException {
		if (inputText.length() != length) {
			throw new DeficientInputLengthException();
		}
	}
	public static void integerCheck(String inputText) throws IntegerInputException {
		String[] inputTextArray = inputText.split("");
		
		for (char character : inputText.toCharArray()) {
			int asciiCharacter = (int) character;
			if (asciiCharacter < 48 || asciiCharacter > 57) {
				throw new IntegerInputException();
			}
		}
	}
	
	/*
	 * 추측할 때 입력값 처리 - 사용안할듯 -> 추후 확정되면 제거
	 */
	public static void validateStageInput(String inputText, int length) throws IntegerInputException, DeficientInputLengthException {
		Validator.integerCheck(inputText);
		Validator.lengthCheck(inputText, length);
	}
}
