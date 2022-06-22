package logic;

public class Answer extends GameData{

	public Answer(String answer) {
		super();
		setAnswer(answer);
	}
	

	
	public void check(String inputText) {
		String[] splittedText = inputText.split("");
		System.out.println(splittedText[0]);
		System.out.println(splittedText[1]);
		System.out.println(splittedText[2]);
		System.out.println(splittedText[3]);
		
	}
	

}
