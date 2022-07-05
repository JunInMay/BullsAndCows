package customException;

public class WrongStageInputAlphabetException extends Exception {
	public WrongStageInputAlphabetException() {
	}
	public WrongStageInputAlphabetException(String message) {
		super(message);
	}
}
