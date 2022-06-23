package logic;

public class ToolBox {
	/*
	 * ������ ���� �迭�� �����
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
