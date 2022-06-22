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
	 * 사용자 입력을 정답과 비교하기
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
	 * 입력값에 따른 로그 출력
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
		System.out.println("게임이 시작됐습니다. 답을 맞춰보세요.");
	}

	public void gameComplete() {
		System.out.println("정답을 맞췄습니다. \n게임이 종료됐습니다.");
	}
	
	public void repeatAgain() {
		System.out.println("다시 입력해주세요.");
	}

}
