package logic;

import java.util.HashMap;
import java.util.Map;

public enum ConsoleMenuOption implements Comparable<ConsoleMenuOption>{
	STAGE(1, "게임 시작")
	, SET_GAME_LENGTH(3, "게임 길이 설정")
	, EXIT(2, "게임 종료")
//	, test(4, "asdf")
	;
	
	private final int menuIndex;
	private final String value;
	private static final Map<Integer, ConsoleMenuOption> MENU_INDEX_MAP = new HashMap<>();
	static {
        for (ConsoleMenuOption e: values()) {
            MENU_INDEX_MAP.put(e.menuIndex, e);
        }
    }
	private ConsoleMenuOption(int number, String value) {
		this.menuIndex = number;
		this.value = value;
	}
	public static ConsoleMenuOption valueOfIndex(int index) {
		return MENU_INDEX_MAP.get(index);
	}
	
	public int getMenuIndex() {
		return menuIndex;
	}
	
	public String getValue() {
		return value;
	}
}
