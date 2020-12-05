package application;

public class CheckMove {
	private Boolean valid;
	private Boolean inCheck;
	
	public CheckMove() {
		valid=false;
		inCheck=false;
	}
	
	private Boolean isValid() {
		return valid;
	}
	
	private Boolean inCheck() {
		return inCheck;
	}
	
	public void move() {
		
	}
}
