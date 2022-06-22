package logic;

public class ToolBox {
	/*
	 * ������ ���� �迭�� �����
	 */
	public static int[] intToArrayInt(int number) {
		String tempString = Integer.toString(number);
		int[] intArray = new int[tempString.length()];
		for (int i = 0; i < tempString.length(); i++) {
			intArray[i] = Integer.parseInt(Character.toString(tempString.charAt(i)));
		}
		return intArray;
	}
	
	/*
	 * ���� �迭�� ���� ���� 1ĭ�� �Բ� �����ϱ�
	 */
	public static String intArrayToString(int[] array) {
		String result = "";
		for (int i = 0; i < array.length; i++) {
			result += Integer.toString(array[i]) + " ";
		}
		return result;
	}
}
