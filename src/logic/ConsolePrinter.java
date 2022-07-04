package logic;

public class ConsolePrinter {
	public static void printWelcome() {
		System.out.println("��������������������������������������������\n"
						 + "��   Bulls And Cows   ��\n"
						 + "��       Welcome      ��\n"
						 + "��������������������������������������������\n");
	}
	public static void printMenu() {
		System.out.println("������ ���۵ƽ��ϴ�. ������ �����ϼ���.\n1. ���� ���� 2. ���� ����");
	}
	public static void printStageStart() {
		System.out.println("���ھ߱� ������ ���۵ƽ��ϴ�. ���� ���纸����.");
	}

	public static void printGameComplete() {
		System.out.println("*********************************\n"
						 + "                                         \n"
						 + "              �����Դϴ�! �����մϴ�!         \n"
						 + "                �޴��� ���ư��ϴ�.           \n"
						 + "                                         \n"
						 + "*********************************\n");
	}
	
	public static void printRepeatAgain() {
		System.out.println("�ٽ� �Է����ּ���.");
	}
	
	public static void printIntegerInputException() {
		System.out.println(String.format("�Է� ���� : 0~9������ ������ �Է����ּ���."));
	}
	
	public static void printGuessNumberException(int guessLength) {
		System.out.println(String.format("�Է� ���� : 0~9������ ������ %d�� �Է����ּ���.", guessLength));
	}
	public static void printWrongStageInputAlphabetException() {
		String candidates = "";
		for (StageInputAlphabet s : StageInputAlphabet.values()) {
			candidates += s.name() + ", ";
		}
		candidates = candidates.substring(0, candidates.length()-2);
		System.out.println(String.format("�Է� ���� : 0~9������ ���� Ȥ�� ��ҹ��� ���о��� ���ĺ� %s�� �Է� �����մϴ�.", candidates));
	}
	public static void printStageInput(int guessLength) {
		System.out.println(String.format("0~9������ ������ %d�� �Է����ּ���.", guessLength));
	}
	public static void printGuessResult(int order, String inputText, int balls, int strikes) {
		System.out.println(String.format("%d��° ����, �Է��� ���� : %s, �� : %d, ��Ʈ����ũ : %d", order, inputText, balls, strikes));
	}
}

/*
 * �׽�Ʈ�� enum Ŭ����
 * �ǹ�
 * - "0~9������ ���� %d��"���ڿ��� ������ �������� �ϰ� ������... enum�� ��� ���⿡ ���� ���� ��� ��� ����?
 */
enum GameStatusText {
	StageStart("������ ���۵ƽ��ϴ�. ���� ���纸����."),
	GameComplete("������ ������ϴ�. \n������ ����ƽ��ϴ�."),
	RepeatAgain("�ٽ� �Է����ּ���."),
	IntegerInputError("0~9������ ���� %d���� �Է����ּ���.");
	
	
	private final String value;
	
	private GameStatusText(String value){
		this.value = value;
	}
	private GameStatusText(String value, Object param) {
		this.value = String.format(value, param);
	}
}