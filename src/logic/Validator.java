package logic;

import customException.DeficientInputLengthException;
import customException.GuessNumberException;
import customException.IntegerInputException;
import customException.WrongStageInputAlphabetException;

public class Validator {
	private static final Exception WrongStageInputAlphabetException = null;

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

	public static boolean stageInputAlphabetCheck(String inputText) throws WrongStageInputAlphabetException {
		boolean isStageInputAlphabet = false;
		for (StageInputAlphabet e : StageInputAlphabet.values()) {
			if (e.isSame(inputText)) {
				System.out.println("inputText : " + inputText + " e : " + e.getLowerValue());
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
			System.out.println("inputTextLength : " + inputText.length());
			System.out.println("isIntegerInputException? : " + e.getMainException().getClass().equals(IntegerInputException.class.getClass()));
			if (inputText.length() == 1) {
				System.out.println(e.getMainException().getClass().toString());
				stageInputAlphabetCheck(inputText);
			} else {
				throw e;
			}
		}
	}
}
