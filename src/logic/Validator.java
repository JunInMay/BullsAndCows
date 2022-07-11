package logic;

import customException.DeficientInputLengthException;
import customException.GuessNumberException;
import customException.InappropriateStageLengthInputException;
import customException.IntegerInputException;
import customException.WrongStageInputAlphabetException;

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

	public static void setLengthCheck(int length) throws InappropriateStageLengthInputException {
		int validationLength = Integer.parseInt(ConstantSettings.MAX_STAGE_LENGTH.getValue());
		
		if (length <= 1 && validationLength < length) {
			throw new InappropriateStageLengthInputException();
		}
	}
	
}
