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
		System.out.println("정답을 맞췄습니다. \n게임이 종료됐습니다.");
	}
	
	public static void printRepeatAgain() {
		System.out.println("다시 입력해주세요.");
	}
	
	public static void printIntegerInputError() {
		System.out.println(String.format("0~9까지의 정수를 입력해주세요."));
	}
	
	public static void printDeficientGuessNumberLength(int guessLength) {
		System.out.println(String.format("정수를 %d개 입력해주세요.", guessLength));
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