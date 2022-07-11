package logic;

public enum ConstantSettings {
	MAX_STAGE_LENGTH("1");
	
	private final String value;
	
	private ConstantSettings(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
