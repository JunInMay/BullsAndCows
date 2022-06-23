package logic;

public class ToolBox {
	/*
	 * 정수를 정수 배열로 만들기
	 */
	public static int[] stringToArrayInt(String text) throws NumberFormatException{
		String[] tempStringArray = text.split("");
		int[] intArray = new int[tempStringArray.length];
		for (int i = 0; i < tempStringArray.length; i++) {
			intArray[i] = Integer.parseInt(tempStringArray[i]);
		}
		return intArray;
	}
	
	/*
	 * 정수 배열의 값을 공백 1칸과 함께 나열하기
	 */
	public static String intArrayToString(int[] array) {
		String result = "";
		for (int i = 0; i < array.length; i++) {
			result += Integer.toString(array[i]) + " ";
		}
		return result;
	}
}
