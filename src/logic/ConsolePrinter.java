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
		System.out.println("������ ������ϴ�. \n������ ����ƽ��ϴ�.");
	}
	
	public static void printRepeatAgain() {
		System.out.println("�ٽ� �Է����ּ���.");
	}
	
	public static void printIntegerInputError() {
		System.out.println(String.format("0~9������ ������ �Է����ּ���."));
	}
	
	public static void printDeficientGuessNumberLength(int guessLength) {
		System.out.println(String.format("������ %d�� �Է����ּ���.", guessLength));
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