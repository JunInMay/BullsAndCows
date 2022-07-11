package customException;

public class InappropriateStageLengthInputException extends Exception{
	public InappropriateStageLengthInputException() {
	}
	public InappropriateStageLengthInputException(String message) {
		super(message);
	}
}
