package application;

import chesspieces.ChessPiece;
import javafx.scene.Group;

public abstract class CheckMove {
	private Boolean valid;
	private Boolean inCheck;
	
	public CheckMove() {
		valid=false;
		inCheck=false;
	}
	
//	private Boolean isValid(ChessPiece piece) {
//		
//		return valid;
//	}
	
	public abstract Boolean isValid(ChessPiece piece, int dest_x, int dest_y, Group tileGroup);
	
	private Boolean inCheck() {
		return inCheck;
	}
	
	public void move() {
		
	}
}
