package application;

import chesspieces.ChessPiece;

public abstract class CheckMove {
	private Boolean valid;
	private Boolean inCheck;
	
	public CheckMove() {
		valid=false;
		inCheck=false;
	}
	
	private Boolean isValid(ChessPiece piece) {
		
		return valid;
	}
	
	private Boolean inCheck() {
		return inCheck;
	}
	
	public void move() {
		
	}
}
