package logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Play{
	private Answer answer;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private String inputText;
	private int guessTimes = 0;
	
	public Play(){
		answer = new Answer();
	}
	public Play(int answer){
		int[] answerArray = ToolBox.intToArrayInt(answer);
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
		if (guessTimes == 0) {
			gameStart();
		}
		getInput();
		printLog();
		if (isComplete()) {
			gameComplete();
		} else {
			repeatAgain();
		}
	}
	
	/*
	 * �Է°��� ���� �α� ���
	 */
	public void printLog() {
		System.out.println("Input : " + ToolBox.intArrayToString(ToolBox.intToArrayInt(Integer.parseInt(inputText))));
		System.out.println("Balls : " + answer.getBalls() + ", Strikes : " + answer.getStrikes() + ", Length : " + answer.getGuessLength());
		System.out.println("answer : " + ToolBox.intArrayToString(answer.getAnswer()));
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
