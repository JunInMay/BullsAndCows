package logic;

import java.util.ArrayList;
import java.util.Random;

public class Answer extends GameData{

	public Answer(int[] answer) {
		super();
		setAnswer(answer);
	}
	public Answer(int answer) {
		super();
		setAnswer(ToolBox.intToArrayInt(answer));
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
		setAnswer(ToolBox.intToArrayInt(1234));
		ArrayList<Integer> tempArray = new ArrayList<Integer>();
		Random rand = new Random(System.currentTimeMillis());
		int iteratedCount = 0;
		while (tempArray.size() < getGuessLength()) {
			int randomElement = rand.nextInt(10);
			boolean isExist = false;
			for (int i = 0; i < tempArray.size(); i++) {
				if (randomElement == tempArray.get(i)) {
					isExist = true;
					break;
				}
			}
			if (!isExist) {
				tempArray.add(randomElement);
			}
			iteratedCount ++;
			
		}
		System.out.println("asdf");
		System.out.println(tempArray);
		System.out.println(iteratedCount);
		tempArray.toArray();
		setAnswer(tempArray.toArray());
		
		
	}
	
	/*
	 * ���� �ؽ�Ʈ�� ������ ��ġ�ϴ��� Ȯ���ϴ� �޼ҵ�
	 */
	public void checkAnswer(String inputText) {
		int[] splittedInput = ToolBox.intToArrayInt(Integer.parseInt(inputText));
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
