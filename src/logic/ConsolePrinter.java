package logic;

public class ConsolePrinter {
	public static void printWelcome() {
		System.out.println("┌────────────────────┐\n"
						 + "│   Bulls And Cows   │\n"
						 + "│       Welcome      │\n"
						 + "└────────────────────┘\n");
	}
	public static void printMenu() {
		System.out.println("게임이 시작됐습니다. 동작을 선택하세요.\n1. 게임 시작 2. 게임 종료");
	}
	public static void printStageStart() {
		System.out.println("숫자야구 게임이 시작됐습니다. 답을 맞춰보세요.");
	}

	public static void printGameComplete() {
		System.out.println("*********************************\n"
						 + "                                         \n"
						 + "              정답입니다! 축하합니다!         \n"
						 + "                메뉴로 돌아갑니다.           \n"
						 + "                                         \n"
						 + "*********************************\n");
	}
	
	public static void printRepeatAgain() {
		System.out.println("다시 입력해주세요.");
	}
	
	public static void printIntegerInputException() {
		System.out.println(String.format("입력 오류 : 0~9까지의 정수를 입력해주세요."));
	}
	
	public static void printGuessNumberException(int guessLength) {
		System.out.println(String.format("입력 오류 : 0~9까지의 정수를 %d개 입력해주세요.", guessLength));
	}
	public static void printWrongStageInputAlphabetException() {
		String candidates = "";
		for (StageInputAlphabet s : StageInputAlphabet.values()) {
			candidates += s.name() + ", ";
		}
		candidates = candidates.substring(0, candidates.length()-2);
		System.out.println(String.format("입력 오류 : 0~9까지의 정수 혹은 대소문자 구분없이 알파벳 %s만 입력 가능합니다.", candidates));
	}
	public static void printStageInput(int guessLength) {
		System.out.println(String.format("0~9까지의 정수를 %d개 입력해주세요.", guessLength));
	}
	public static void printGuessResult(int order, String inputText, int balls, int strikes) {
		System.out.println(String.format("%d번째 추측, 입력한 숫자 : %s, 볼 : %d, 스트라이크 : %d", order, inputText, balls, strikes));
	}
}

/*
 * 테스트용 enum 클래스
 * 의문
 * - "0~9까지의 정수 %d개"문자열에 정수를 포매팅을 하고 싶은데... enum일 경우 여기에 정수 값을 어떻게 줘야 하지?
 */
enum GameStatusText {
	StageStart("게임이 시작됐습니다. 답을 맞춰보세요."),
	GameComplete("정답을 맞췄습니다. \n게임이 종료됐습니다."),
	RepeatAgain("다시 입력해주세요."),
	IntegerInputError("0~9까지의 정수 %d개를 입력해주세요.");
	
	
	private final String value;
	
	private GameStatusText(String value){
		this.value = value;
	}
	private GameStatusText(String value, Object param) {
		this.value = String.format(value, param);
	}
}