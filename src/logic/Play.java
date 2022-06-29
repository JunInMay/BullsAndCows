package logic;

import java.util.Arrays;

import customException.DeficientInputLengthException;
import customException.IntegerInputException;

public class Play extends GameData{
	private Answer answer;
	private int guessTimes = 0;
	private boolean havingError = false;
	private boolean stageStarted = false;
	private boolean menuSelected = false;
	
	private ConsoleMenuOption mo;
	
	public Play(){
	}
	
	public Answer getAnswer() {
		return answer;
	}
	
	public void setInputText(String inputText) {
	}
	
	public void stageStart() {
//		tp.printStageStart();
		answer = new Answer(getGuessLength());
//		stageStarted = true;
	}
	
	public void stageEnd() {
		
	}
	
	/*
	 * 입력 값을 받아서 답이 맞는지, 아닌지 출력
	 */
	public boolean guess(String inputText) {
//		if (!stageStarted) {
//			stageStart();
//		}
//		validateStageInput();
		checkAnswer(inputText);
		return isComplete();
//		if (isComplete()) {
////			tp.printGameComplete();
//			stageStarted = false;
//		} else {
////			tp.printRepeatAgain();
//		}
	}
	
	/*
	 * 처음에 메뉴를 주고, 메뉴에서 동작 선택
	 */
	public void menuFlow() {
		mo = mo.STAGE;
	}
	
	/*
	 * 입력값에 따른 로그 출력
	 */
	
	
	
	
	/*
	 * 정답 확인
	 */
	public boolean isComplete() {
		return getStrikes() == getGuessLength();
	}
	
	/*
	 * 들어온 텍스트와 정답이 일치하는지 확인
	 */
	public void checkAnswer(String inputText) {
		int[] splittedInput = ToolBox.stringToArrayInt(inputText);
		int[] splittedAnswer = answer.getAnswer();
		System.out.println(inputText + " 여ㅛ기요 " + Arrays.toString(splittedAnswer));
		int balls = 0;
		int strikes = 0;
		
		boolean hasBreak = false;
		for (int i = 0; i < getGuessLength(); i++) {
			for (int j = 0; j < getGuessLength(); j++) {
				if (splittedInput[j] == splittedAnswer[i]) {
					hasBreak = true;
					if (i == j) {
						strikes++;
						break;
					}
					balls++;
					break;
				}
			}
			if (hasBreak) {
				break;
			}
		}
		setBalls(balls);
		setStrikes(strikes);
		System.out.println(balls + " " + strikes);
	}

}
