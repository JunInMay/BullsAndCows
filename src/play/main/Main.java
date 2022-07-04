package play.main;

import logic.PlayConsole;

/*
 * TODO List
 * - 입력 validation (띄어쓰기 등)
 * - 히스토리 저장(B, S 내역)
 * - 
 */

public class Main {

	public static void main(String[] args) {
		
		PlayConsole game = new PlayConsole();
		game.run();
		
		
	}

}
