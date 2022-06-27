package logic;

import customException.DeficientInputLengthException;
import customException.IntegerInputException;

public class Play{
	private Answer answer;
	private String inputText;
	private int guessTimes = 0;
	private boolean havingError = false;
	private boolean stageStarted = false;
	private boolean menuSelected = false;
	
	private MenuOption mo;
	
	public Play(){
	}
	
	public Answer getAnswer() {
		return answer;
	}
	
	public void setInputText(String inputText) {
		this.inputText = inputText;
	}
	
	public void stageStart() {
//		tp.printStageStart();
		answer = new Answer();
		stageStarted = true;
	}
	
	public void stageEnd() {
		
	}
	
	public void guess() {
		if (!stageStarted) {
			stageStart();
		}
//		validateStageInput();
		answer.checkAnswer(inputText);
		printLog();
		if (answer.isComplete()) {
//			tp.printGameComplete();
			stageStarted = false;
		} else {
//			tp.printRepeatAgain();
		}
	}
	
	/*
	 * ó���� �޴��� �ְ�, �޴����� ���� ����
	 */
	public void menuFlow() {
		mo = mo.STAGE;
	}
	
	/*
	 * �Է°��� ���� �α� ���
	 */
	public void printLog() {
		System.out.println("Input : " + ToolBox.intArrayToString(ToolBox.stringToArrayInt(inputText)));
		System.out.println("Balls : " + answer.getBalls() + ", Strikes : " + answer.getStrikes() + ", Length : " + answer.getGuessLength());
		System.out.println("answer : " + ToolBox.intArrayToString(answer.getAnswer()));
	}
	
	
	
	/*
	 * ������ �� �Է°� ó��
	 */
	public void validateStageInput() throws IntegerInputException, DeficientInputLengthException {
		Validator.integerCheck(inputText);
		Validator.lengthCheck(inputText, answer.getGuessLength());
	}

}
