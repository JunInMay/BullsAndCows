package logic;

import java.util.ArrayList;

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
	
	public String getAnswer() {
		return ToolBox.intArrayToString(answer.getAnswer());
	}
	
	public void setInputText(String inputText) {
	}
	
	public boolean setGameLength(int length) {
		boolean result = false;
		setGuessLength(length);
		result = true;
		return result;
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
	public ArrayList<History> getHistoryList(){
		return historyList;
	}
	
	/*
	 * 처음에 메뉴를 주고, 메뉴에서 동작 선택
	 */
	public void menuFlow() {
		mo = mo.STAGE;
	}
	
	
	
	
	
	
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
