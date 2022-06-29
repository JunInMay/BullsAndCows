package logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PlayConsole {
	private Play play;
	private BufferedReader br;
	private String inputText;
	private ConsoleMenuOption mo;
	private ConsoleFlow flow = ConsoleFlow.INITIAL_START;
	
	public PlayConsole() {
		this.play = new Play();
		this.br = new BufferedReader(new InputStreamReader(System.in)); 
	}
	
	public void run(){
		while (flow != ConsoleFlow.GAME_END) {
			switch (flow) {
				case INITIAL_START:
					ConsolePrinter.printWelcome();
					flow = ConsoleFlow.MENU_SELECT;
					break;
				// 게임시작/종료 메뉴를 고르지 않은 상태
				case MENU_SELECT:
					selectMenu();
					switch (mo) {
						case STAGE:
							flow = ConsoleFlow.STAGE_START;
							break;
						case EXIT:
							flow = ConsoleFlow.GAME_END;
							break;
					}
					deselectMenuOption();
					break;
				case STAGE_START:
					stageStart();
					flow = ConsoleFlow.STAGE_INPUT;
					break;
				case STAGE_INPUT:
					System.out.println(Arrays.toString(play.getAnswer().getAnswer()));
					System.out.println("STAGEINPUT CHECK중 " + "Balls : " + play.getBalls() + ", Strikes : " + play.getStrikes() + ", Length : " + play.getGuessLength());
					if (stageInput()) {
						flow = ConsoleFlow.STAGE_COMPLETE;
						break;
					} else {
						System.out.println("틀림" + flow.name());
						break;
					}
				
			}
		}
	}
	public void printLog() {
		System.out.println("Input : " + ToolBox.intArrayToString(ToolBox.stringToArrayInt(inputText)));
		System.out.println("Balls : " + play.getBalls() + ", Strikes : " + play.getStrikes() + ", Length : " + play.getGuessLength());
		System.out.println("answer : " + ToolBox.intArrayToString(play.getAnswer().getAnswer()));
	}
	

	private void stageStart() {
		play.stageStart();
		ConsolePrinter.printStageStart();
	}
	private boolean stageInput() {
		ConsolePrinter.printStageInput(play.getGuessLength());
		getInput();
		boolean result = play.guess(inputText);
		printLog();
		return result;
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
