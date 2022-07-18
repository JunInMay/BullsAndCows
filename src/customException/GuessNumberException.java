package customException;

public class GuessNumberException extends Exception{
	Exception mainException;
	
	public GuessNumberException() {
	}
	public GuessNumberException(String message) {
		super(message);
	}
	public GuessNumberException(Exception e) {
		this.mainException = e;
	}
	
	public Exception getMainException() {
		return mainException;
	}
}
