package logic;

import java.util.ArrayList;
import java.util.Arrays;

import customException.DeficientInputLengthException;
import customException.IntegerInputException;

public class Play extends GameData{
	private Answer answer;
	private int guessTimes;
	private ArrayList<History> historyList;
	private boolean havingError = false;
	private boolean stageStarted = false;
	private boolean menuSelected = false;
	
	private ConsoleMenuOption mo;
	
	public Play(){
		historyList = new ArrayList<History>();
		guessTimes = 0;
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
	 * �Է� ���� �޾Ƽ� ���� �´���, �ƴ��� ���
	 */
	public boolean guess(String inputText) {
//		if (!stageStarted) {
//			stageStart();
//		}
//		validateStageInput();
		checkAnswer(inputText);
		guessTimes++;
		History history = new History(getBalls(), getStrikes(), guessTimes, inputText);
		historyList.add(history);
		return isComplete();
//		if (isComplete()) {
////			tp.printGameComplete();
//			stageStarted = false;
//		} else {
////			tp.printRepeatAgain();
//		}
	}
	
	public History getLatestHistory() {
		return historyList.get(historyList.size()-1); 
	}
	
	/*
	 * ó���� �޴��� �ְ�, �޴����� ���� ����
	 */
	public void menuFlow() {
		mo = mo.STAGE;
	}
	
	
	
	
	
	
	/*
	 * ���� Ȯ��
	 */
	public boolean isComplete() {
		return getStrikes() == getGuessLength();
	}
	
	/*
	 * ���� �ؽ�Ʈ�� ������ ��ġ�ϴ��� Ȯ��
	 */
	public void checkAnswer(String inputText) {
		int[] splittedInput = ToolBox.stringToArrayInt(inputText);
		int[] splittedAnswer = answer.getAnswer();
		int balls = 0;
		int strikes = 0;
		boolean hasBreak = false;
		for (int i = 0; i < getGuessLength(); i++) {
			for (int j = 0; j < getGuessLength(); j++) {
				if (splittedInput[j] == splittedAnswer[i]) {
					if (i == j) {
						strikes++;
						break;
					}
					balls++;
					break;
				}
			}
		}
		setBalls(balls);
		setStrikes(strikes);
	}

}
