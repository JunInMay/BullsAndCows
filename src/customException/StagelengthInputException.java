package customException;

public class StagelengthInputException extends Exception{
	Exception e;
	
	public StagelengthInputException() {	
	}
	public StagelengthInputException(String message) {
		super(message);
	}
	public StagelengthInputException(Exception e) {
		this.e = e;
	}
	
	public Exception getException() {
		return e;
	}
	
}
