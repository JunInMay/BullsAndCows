package customException;

public class DeficientInputLengthException extends Exception{
	public DeficientInputLengthException() {
	}
	public DeficientInputLengthException(String message){
		super(message);
	}
}
