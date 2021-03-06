package logic;

import customException.DeficientInputLengthException;
import customException.GuessNumberException;
import customException.IntegerInputException;
import customException.WrongStageInputAlphabetException;

public class ConsoleValidator extends Validator{
	public static boolean stageInputAlphabetCheck(String inputText) throws WrongStageInputAlphabetException {
		boolean isStageInputAlphabet = false;
		for (StageInputAlphabetOption e : StageInputAlphabetOption.values()) {
			if (e.isSame(inputText)) {
				isStageInputAlphabet = true;
				break;
			}
		}

		if (!isStageInputAlphabet) {
			throw new WrongStageInputAlphabetException();
		}
		return isStageInputAlphabet;
	}
	
	/*
	 * 추측할 때 입력값 처리 - 사용안할듯 -> 추후 확정되면 제거 -> 사용할듯
	 */
	public static void validateStageInput(String inputText, int length) throws GuessNumberException {
		try {
			try {
				integerCheck(inputText);
				lengthCheck(inputText, length);
			} catch (IntegerInputException | DeficientInputLengthException e) {
				throw new GuessNumberException(e);
			}
		} catch (GuessNumberException e) {
			if (inputText.length() == 1) {
				try {
//				System.out.println(e.getMainException().getClass().toString());
				stageInputAlphabetCheck(inputText);
				} catch (WrongStageInputAlphabetException e2) {
					throw new GuessNumberException(e2);
				}
			} else {
				throw e;
			}
		}
	}
	
	public static void validateSetLengthInput(String inputText) {
	}
}
