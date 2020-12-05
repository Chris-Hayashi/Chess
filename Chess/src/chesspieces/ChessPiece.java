package chesspieces;

import java.io.InputStream;

import application.CheckMove;
import javafx.scene.image.ImageView;

public abstract class ChessPiece extends CheckMove {
	public Boolean isWhite;
	
	ChessPiece(Boolean isWhite, int x, int y) {
		this.isWhite = isWhite;
	}
	
//	public String getName() {
//		
//	}
//	
//	public Boolean isWhite() {
//		
//	}
//	
//	public Boolean getDiag() {
//		
//	}
//	
//	public Boolean getStraight() {
//		
//	}
//	public int getSq() {
//		
//	}
	/*
	private Boolean checkMove() {
		CheckMove checkMove = new CheckMove();
		return checkMove.isValid();
	}*/
	
	public void move() {
		// if move is valid
		checkMove();
			//move piece
	}
	public abstract InputStream display();
}
