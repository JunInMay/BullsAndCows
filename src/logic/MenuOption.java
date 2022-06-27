package logic;

import java.util.HashMap;
import java.util.Map;

public enum MenuOption {
	STAGE(1),
	EXIT(2);
	
	private final int menuIndex;
	private static final Map<Integer, MenuOption> MENU_INDEX_MAP = new HashMap<>();
	static {
        for (MenuOption e: values()) {
            MENU_INDEX_MAP.put(e.menuIndex, e);
        }
    }
	private MenuOption(int number) {
		this.menuIndex = number;
	}
	
	public static MenuOption valueOfIndex(int index) {
		return MENU_INDEX_MAP.get(index);
	}
}
