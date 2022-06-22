package logic;

class GameData {
	private String answer;
	private int balls = 0;
	private int strikes = 0;
	
	public GameData(){
		this.balls = 0;
		this.strikes = 0;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
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
}