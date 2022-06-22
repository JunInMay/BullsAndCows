package play.main;

import logic.Answer;
import logic.Play;

public class Main {

	public static void main(String[] args) {
//		Answer a = new Answer();
//		a.checkAnswer("2341");
//		a.checkAnswer("5132");
//		String history = "";
		
		Play game = new Play();
		while (!game.isComplete()) {
			game.guess();
		}
		
		
	}

}
