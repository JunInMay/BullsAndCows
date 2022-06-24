package logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import customException.DeficientInputLengthException;

public class Play{
	private Answer answer;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private String inputText;
	private int guessTimes = 0;
	private boolean havingError = false;
	private boolean stageStarted = false;
	private boolean menuSelected = false;
	private TextPrinter tp = new TextPrinter();
	private MenuOption mo;
	
	public Play(){
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
	}
	
	public void stageStart() {
		tp.printStageStart();
		answer = new Answer();
		stageStarted = true;
	}
	
	public void stageEnd() {
		
	}
	
	public void run() {
		havingError = false;
		if (!stageStarted) {
			stageStart();
		}
		getInput();
		validateStageInput();
		answer.checkAnswer(inputText);
		printLog();
		if (isComplete()) {
			tp.printGameComplete();
			stageStarted = false;
		} else {
			tp.printRepeatAgain();
		}
	}
	
	/*
	 * 처음에 메뉴를 주고, 메뉴에서 동작 선택
	 */
	public void menuFlow() {
		mo = mo.Stage;
	}
	
	/*
	 * 입력값에 따른 로그 출력
	 */
	public void printLog() {
		System.out.println("Input : " + ToolBox.intArrayToString(ToolBox.stringToArrayInt(inputText)));
		System.out.println("Balls : " + answer.getBalls() + ", Strikes : " + answer.getStrikes() + ", Length : " + answer.getGuessLength());
		System.out.println("answer : " + ToolBox.intArrayToString(answer.getAnswer()));
	}
	
	public boolean isComplete() {
		return answer.getStrikes() == answer.getGuessLength();
	}
	
	public void validateStageInput() {
		try {
			Validator.integerCheck(inputText);
			Validator.lengthCheck(inputText, answer.getGuessLength());
		} catch (NumberFormatException e){
			tp.printIntegerInputError();
			havingError = true;
		} catch (DeficientInputLengthException e) {
			tp.printDeficientGuessNumberLength(answer.getGuessLength());
			havingError = true;
		}
	}
}

enum MenuOption{
	Stage, Exit
}
