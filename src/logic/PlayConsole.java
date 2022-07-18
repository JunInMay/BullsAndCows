package logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.acl.LastOwnerException;
import java.text.Format;
import java.util.ArrayList;
import java.util.Arrays;

import customException.DeficientInputLengthException;
import customException.GuessNumberException;
import customException.IntegerInputException;
import customException.WrongStageInputAlphabetException;

public class PlayConsole {
	private Play play;
	private BufferedReader br;
	private String inputText;
	private ConsoleMenuOption mo;
	private ConsoleFlow flow;

	public PlayConsole() {
		play = new Play();
		br = new BufferedReader(new InputStreamReader(System.in));
		flow = ConsoleFlow.INITIAL_START;
	}

	public void run() {
		while (flow != ConsoleFlow.GAME_END) {
			try {
				switch (flow) {
				case INITIAL_START:
					ConsolePrinter.printWelcome();
					flow = ConsoleFlow.MENU_SELECT;
					break;
				// ���ӽ���/���� �޴��� ���� ���� ����
				case MENU_SELECT:
					selectMenu();
					switch (mo) {
					case STAGE:
						flow = ConsoleFlow.STAGE_START;
						break;
					case EXIT:
						flow = ConsoleFlow.GAME_END;
						break;
					case SET_GAME_LENGTH:
						flow = ConsoleFlow.SET_GAME_LENGTH;
						break;
					default:
						break;
					}
					deselectMenuOption();
					break;
				case SET_GAME_LENGTH:
					setGameLength();
					flow = ConsoleFlow.MENU_SELECT;
					break;
				case STAGE_START:
					stageStart();
					flow = ConsoleFlow.STAGE_INPUT;
					break;
				case STAGE_INPUT:
					stageInput();
					if (isStageInputAlphabetSelected()) {
						switch (StageInputAlphabetOption.valueOf(inputText.toUpperCase())) {
						case A:
							showAnswer();
							break;
						case H:
							showHistory();
							break;
						}
					} else {
						boolean stageResult = stageGuess();
						if (stageResult) {
							flow = ConsoleFlow.STAGE_COMPLETE;
						}
					}
					break;
				case STAGE_COMPLETE:
					stageComplete();
					flow = ConsoleFlow.MENU_SELECT;
					break;
				}
			} catch (GuessNumberException e) {
				Class mainExceptionClass = e.getMainException().getClass();
				
				if (mainExceptionClass.equals(IntegerInputException.class)) {
					ConsolePrinter.printIntegerInputException();
				} else if (mainExceptionClass.equals(DeficientInputLengthException.class)) {
					ConsolePrinter.printDeficientInputLengthException(play.getGuessLength());
				} else if (mainExceptionClass.equals(WrongStageInputAlphabetException.class)) {
					ConsolePrinter.printWrongStageInputAlphabetException();
				}
			} 
		}
	}

	private void setGameLength() {
		ConsolePrinter.printSetGameLength();
		getInput();
		ConsoleValidator.validateSetLengthInput(inputText);
		this.play.setGuessLength(Integer.parseInt(inputText));
	}

	/*
	 * ġƮ
	 */
	public void printLog() {
		System.out.println("Input : " + ToolBox.intArrayToString(ToolBox.stringToArrayInt(inputText)));
		System.out.println("Balls : " + play.getBalls() + ", Strikes : " + play.getStrikes() + ", Length : "
				+ play.getGuessLength());
		System.out.println("answer : " + play.getAnswer());
	}

	private void stageStart() {
		this.play = new Play();
		play.stageStart();
		ConsolePrinter.printStageStart();
	}

	private void stageInput() throws GuessNumberException {
		ConsolePrinter.printStageInput(play.getGuessLength());
		getInput();
		ConsoleValidator.validateStageInput(inputText, play.getGuessLength());
	}
	private void showHistory() {
		ArrayList<History> historyList = play.getHistoryList();
		int balls, strikes, order;
		String guessedNumber;
		
		if (historyList.size() > 0) {
			ConsolePrinter.printHistoryStart();
			for (History history : historyList) {
				balls = history.getBalls();
				strikes = history.getStrikes();
				order = history.getOrder();
				guessedNumber = history.getInputText();
				ConsolePrinter.printGuessResult(order, guessedNumber, balls, strikes);
			}
			ConsolePrinter.printHistoryEnd();
		}
	}
	private void showAnswer() {
		System.out.println("Answer : " + play.getAnswer());
	}

	private boolean isStageInputAlphabetSelected() {
		boolean result = false;
		try {
			result = ConsoleValidator.stageInputAlphabetCheck(inputText);
		} catch (WrongStageInputAlphabetException e){
		}
			finally {
		}
			return result;
	}

	private boolean stageGuess() {
		boolean result = play.guess(inputText);
		// printLog();
		History latestHistory = play.getLatestHistory();
		ConsolePrinter.printGuessResult(latestHistory.getOrder(), latestHistory.getInputText(),
				latestHistory.getBalls(), latestHistory.getStrikes());

		return result;
	}

	private void stageComplete() {
		ConsolePrinter.printGameComplete();
	}

	public void getInput() {
		try {
			inputText = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			inputText = null;
		}
	}

	private void selectMenu() {
		ConsolePrinter.printMenu();
		getInput();
		selectMenuOption(Integer.parseInt(inputText));
	}

	public void selectMenuOption(int select) {
		this.mo = ConsoleMenuOption.valueOfIndex(select);
	}

	public void deselectMenuOption() {
		this.mo = null;
	}
}
