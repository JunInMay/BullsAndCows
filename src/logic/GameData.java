package logic;

class GameData {
	private int balls = 0;
	private int strikes = 0;
	private int guessTimes = 0;
	private int guessLength = 4; // 추측할 길이
	
	public GameData(){
		initialize();
	}
	public int getGuessLength() {
		return guessLength;
	}
	public void setGuessLength(int length) {
		this.guessLength = length;
	}
	public int getBalls() {
		return balls;
	}
	public void setBalls(int balls) {
		this.balls = balls;
	}
	public void setStrikes(int strikes) {
		this.strikes = strikes;
	}
	public int getStrikes() {
		return strikes;
	}
	public void initialize() {
		this.balls = 0;
		this.strikes = 0;
		this.guessTimes = 0;
	}
	
}