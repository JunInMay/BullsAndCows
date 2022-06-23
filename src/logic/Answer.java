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
	 * TODO ���ڰ� ���ٸ�, �������� ���� ���� ��� ����
	 * �ӽ÷� 1234
	 */
	public Answer() {
		super();
		generateRandomAnswer();
	}
	
	/*
	 * TODO �������� ���� ���� ���
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
	 * ���� �ؽ�Ʈ�� ������ ��ġ�ϴ��� Ȯ���ϴ� �޼ҵ�
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
