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
	 * ����� �Է��� ����� ���ϱ�
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
	 * ó���� �޴��� �ְ�, �޴����� ���� ����
	 */
	public void menuFlow() {
		mo = mo.Stage;
	}
	
	/*
	 * �Է°��� ���� �α� ���
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
