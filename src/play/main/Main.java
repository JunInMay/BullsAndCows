package play.main;

import logic.Answer;
import logic.Play;

/*
 * TODO List
 * - 게임 반복 진행
 * - 입력 validation (띄어쓰기 등)
 * - 히스토리 저장(B, S 내역)
 * - 
 */

public class Main {

	public static void main(String[] args) {
		
		Play game = new Play();
		while (true) {
			game.run();
		}
		
		
	}

}
