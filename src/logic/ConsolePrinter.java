package logic;

import java.util.Arrays;
import java.util.Comparator;

public class ConsolePrinter {
	public static void printWelcome() {
		System.out.println("��������������������������������������������\n"
						 + "��   Bulls And Cows   ��\n"
						 + "��       Welcome      ��\n"
						 + "��������������������������������������������\n");
	}
	public static void printMenu() {
		ConsoleMenuOption[] moList = ConsoleMenuOption.values();
		Arrays.sort(moList, new Comparator<ConsoleMenuOption>() {
			public int compare(ConsoleMenuOption a, ConsoleMenuOption b) {
				return a.getMenuIndex() - b.getMenuIndex();
			}
		});
		int optionLength = ConsoleMenuOption.values().length;
			
		String[] menuLines = new String[Math.round(moList.length/2.0f)];
		String line = "";
		for (int i=0; i<moList.length; i++) {
			if (i%2 == 0) {
				line = "*   ";
			} else {
				line += "                    ";
			}
			line += moList[i].getMenuIndex() + ". " + moList[i].getValue();
			
			if (i%2 != 0) {
				menuLines[i/2] = line + "\n";
				line = "";
			}
		}
		
		if (!line.equals("")) {
			menuLines[menuLines.length-1] = line + "\n";
		}
		
		String menuText = "";
		menuText += "<<<<<<<<<< �޴��� �������ּ���. >>>>>>>>>>\n";
		for (String l : menuLines) {
			menuText += l;
		}
		menuText += "*************************************";
		
		System.out.println(menuText);
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
		for (StageInputAlphabetOption s : StageInputAlphabetOption.values()) {
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
	public static void printHistoryStart() {
		System.out.println("\n************************�����丮�� ����մϴ�.************************");
	}
	public static void printHistoryEnd() {
		System.out.println("***************************�����丮 ����****************************\n");
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