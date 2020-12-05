package application;

import chesspieces.ChessPiece;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tiles extends Rectangle{
	private ChessPiece piece;
	
	public Tiles(boolean color, int x, int y,ChessPiece piece){	//creating an individual tile
		this.piece=piece;
		setWidth(BoardUI.Size);
		setHeight(BoardUI.Size);
		
		relocate(x * BoardUI.Size + BoardUI.Board_X, y * BoardUI.Size + BoardUI.Board_Y); //setting the position of the chessboard
		
		setFill(color ? Color.valueOf("#F0F8FF") : Color.valueOf("#4682B4"));
		
		if (piece != null) {
			piece.display();
		}
		
	}
	
	
	
	public void setPiece(ChessPiece piece) {
		this.piece=piece;
	}
	
	public ChessPiece getPiece() {
		return piece;
	}
}
