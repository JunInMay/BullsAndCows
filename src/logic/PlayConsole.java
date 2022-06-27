package logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayConsole {
	private Play play = new Play();
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private String inputText;
	private MenuOption mo;
	private ConsoleFlow flow = ConsoleFlow.INITIAL_START;
	
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
					break;
				
			}
		}
	}
	
	

	private void stageStart() {
		play.stageStart();
		ConsolePrinter.printStageStart();
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
		this.mo = MenuOption.valueOfIndex(select);
	}
	public void deselectMenuOption() {
		this.mo = null;
	}
}
