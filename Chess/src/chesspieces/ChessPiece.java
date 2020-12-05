package chesspieces;

import java.io.InputStream;

import javafx.scene.image.ImageView;

public abstract class ChessPiece {
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

	
	public void move() {
		
	}
	public abstract InputStream display();
}
