package logic;

import java.util.HashMap;
import java.util.Map;

public enum ConsoleMenuOption {
	STAGE(1, "게임 시작"),
	EXIT(2, "게임 종료");
	
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
}
