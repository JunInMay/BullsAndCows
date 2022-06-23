package logic;

import java.util.ArrayList;
import java.util.Random;

public class Answer extends GameData{

	public Answer(int[] answer) {
		super();
		setAnswer(answer);
	}
	public Answer(String answer) {
		super();
		setAnswer(ToolBox.stringToArrayInt(answer));
	}
	/*
	 * TODO 인자가 없다면, 랜덤으로 정답 생성 기능 진행
	 * 임시로 1234
	 */
	public Answer() {
		super();
		generateRandomAnswer();
	}
	
	/*
	 * TODO 랜덤으로 정답 생성 기능
	 */
	public void generateRandomAnswer() {
		setAnswer(ToolBox.stringToArrayInt("1234"));
		ArrayList<Integer> tempArrayList = new ArrayList<Integer>();
		Random rand = new Random(System.currentTimeMillis());
		while (tempArrayList.size() < getGuessLength()) {
			int randomElement = rand.nextInt(10);
			boolean isExist = false;
			for (int i = 0; i < tempArrayList.size(); i++) {
				if (randomElement == tempArrayList.get(i)) {
					isExist = true;
					break;
				}
			}
			if (!isExist) {
				tempArrayList.add(randomElement);
			}	
		}
		int[] tempArray = new int[getGuessLength()];
		
		int index = 0;
		for (Integer number : tempArrayList) {
			tempArray[index++] = number;
		}

		System.out.println("asdf");
		System.out.println(tempArrayList);
		tempArrayList.toArray();
		setAnswer(tempArray);
		
	}
	
	/*
	 * 들어온 텍스트와 정답이 일치하는지 확인하는 메소드
	 */
	public void checkAnswer(String inputText) {
		int[] splittedInput = ToolBox.stringToArrayInt(inputText);
		int[] splittedAnswer = getAnswer();
		int balls = 0;
		int strikes = 0;
		
		for (int i=0; i<getGuessLength(); i++) {
			for (int j=0; j<getGuessLength(); j++) {
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
		this.setBalls(balls);
		this.setStrikes(strikes);
		
	}
}
