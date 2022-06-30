package logic;

public class History {
	private int balls;
	private int strikes;
	private int order;
	private String inputText;
	
	public History() {
		this(0, 0, 0, "");
	}
	public History(int balls, int strikes, int order, String inputText) {
		this.balls = balls;
		this.strikes = strikes;
		this.order = order;
		this.inputText = inputText;
	}
	
	public int getBalls() {
		return balls;
	}
	public void setBalls(int balls) {
		this.balls = balls;
	}
	public int getStrikes() {
		return strikes;
	}
	public void setStrikes(int strikes) {
		this.strikes = strikes;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getInputText() {
		return inputText;
	}
	public void setInputText(String inputText) {
		this.inputText = inputText;
	}

	public String toString() {
		return "order : " + order +
				", input text : " + inputText +
				", balls : " + balls +
				", strikes : " + strikes;
	}
}
