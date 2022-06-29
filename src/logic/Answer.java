package logic;

import java.util.ArrayList;
import java.util.Random;

public class Answer{
	private int[] answer;

	public int[] getAnswer() {
		return answer;
	}
	public void setAnswer(int[] answer) {
		this.answer = answer;
	}
	public Answer(int[] answer) {
		this.answer = answer;
	}
	public Answer(String answer) {
		this(ToolBox.stringToArrayInt(answer));
	}
	public Answer(int length) {
		this.answer = generateRandomAnswer(length);
	}
	
	public void Reset() {
	}
	
	public int[] generateRandomAnswer(int length) {
		ArrayList<Integer> tempArrayList = new ArrayList<Integer>();
		Random rand = new Random(System.currentTimeMillis());
		while (tempArrayList.size() < length) {
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
		int[] tempArray = new int[length];
		
		int index = 0;
		for (Integer number : tempArrayList) {
			tempArray[index++] = number;
		}

		System.out.println(tempArrayList);
		tempArrayList.toArray();
		return tempArray;		
	}
	
	
	
	
}
