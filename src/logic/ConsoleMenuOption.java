package logic;

import java.util.HashMap;
import java.util.Map;

public enum ConsoleMenuOption {
	STAGE(1),
	EXIT(2);
	
	private final int menuIndex;
	private static final Map<Integer, ConsoleMenuOption> MENU_INDEX_MAP = new HashMap<>();
	static {
        for (ConsoleMenuOption e: values()) {
            MENU_INDEX_MAP.put(e.menuIndex, e);
        }
    }
	private ConsoleMenuOption(int number) {
		this.menuIndex = number;
	}
	
	public static ConsoleMenuOption valueOfIndex(int index) {
		return MENU_INDEX_MAP.get(index);
	}
}
