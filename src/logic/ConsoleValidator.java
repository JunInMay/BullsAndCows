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
	 * ������ �� �Է°� ó�� - �����ҵ� -> ���� Ȯ���Ǹ� ���� -> ����ҵ�
	 */
	public static void validateStageInput(String inputText, int length) throws WrongStageInputAlphabetException, GuessNumberException {
		try {
			try {
				integerCheck(inputText);
				lengthCheck(inputText, length);
			} catch (IntegerInputException e) {
				throw new GuessNumberException(e);
			} catch (DeficientInputLengthException e) {
				throw new GuessNumberException(e);
			}
		} catch (GuessNumberException e) {
			if (inputText.length() == 1) {
				System.out.println(e.getMainException().getClass().toString());
				stageInputAlphabetCheck(inputText);
			} else {
				throw e;
			}
		}
	}
}
