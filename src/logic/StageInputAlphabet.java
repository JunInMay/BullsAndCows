package logic;

public enum StageInputAlphabet {
	H("h"), A("a");
	
	private String lowerValue;
	private String upperValue;
	
	private StageInputAlphabet(String value) {
		this.lowerValue = value;
		this.upperValue = value.toUpperCase();
	}

	public String getLowerValue() {
		return lowerValue;
	}

	public String getUpperValue() {
		return upperValue;
	}
	
	public boolean isSame(String s) {
		if (lowerValue.equals(s) || upperValue.contentEquals(s)) {
			return true;			
		} else {
			return false;
		}
		
		
	}
	
}
