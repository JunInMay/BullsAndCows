package customException;

public class GuessNumberException extends Exception{
	Exception e;
	
	public GuessNumberException() {
	}
	public GuessNumberException(String message) {
		super(message);
	}
	public GuessNumberException(Exception e) {
		this.e = e;
	}
	
	public Exception getMainException() {
		return this.e;
	}
}
