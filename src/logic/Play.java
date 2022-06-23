package logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Play{
	private Answer answer;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private String inputText;
	private int guessTimes = 0;
	private boolean havingError = false;
	
	public Play(){
		answer = new Answer();
	}
	public Play(String answer){
		int[] answerArray = ToolBox.stringToArrayInt(answer);
		this.answer = new Answer(answerArray);
	}
	
	public void reset() {
		this.answer = new Answer();
	}
	
	/*
	 * ����� �Է��� ����� ���ϱ�
	 */
	public void getInput() {
		try {
			inputText = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			inputText = null;
		}
		this.answer.checkAnswer(inputText);
	}
	
	public void guess() {
		if (guessTimes == 0 && !havingError) {
			gameStart();
		}
		try {
			getInput();
			havingError = false;
			printLog();
			if (isComplete()) {
				gameComplete();
			} else {
				repeatAgain();
			}
		} catch (NumberFormatException e){
			integerInputError();
			havingError = true;
		}
	}
	
	/*
	 * �Է°��� ���� �α� ���
	 */
	public void printLog() {
		System.out.println("Input : " + ToolBox.intArrayToString(ToolBox.stringToArrayInt(inputText)));
		System.out.println("Balls : " + answer.getBalls() + ", Strikes : " + answer.getStrikes() + ", Length : " + answer.getGuessLength());
		System.out.println("answer : " + ToolBox.intArrayToString(answer.getAnswer()));
	}
	public void integerInputError() {
		System.out.println("0~9������ ������ �Է����ּ���.");
	}
	public boolean isComplete() {
		return answer.getStrikes() == answer.getGuessLength();
	}
	
	public void gameStart() {
		System.out.println("������ ���۵ƽ��ϴ�. ���� ���纸����.");
	}

	public void gameComplete() {
		System.out.println("������ ������ϴ�. \n������ ����ƽ��ϴ�.");
	}
	
	public void repeatAgain() {
		System.out.println("�ٽ� �Է����ּ���.");
	}

}
