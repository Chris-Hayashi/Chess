package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tiles extends Rectangle{
	public Tiles(boolean color, int x, int y){	//creating an individual tile
		setWidth(BoardUI.Size);
		setHeight(BoardUI.Size);
		
		relocate(x * BoardUI.Size + BoardUI.Board_X, y * BoardUI.Size + BoardUI.Board_Y); //setting the position of the chessboard
		
		setFill(color ? Color.valueOf("#F0F8FF") : Color.valueOf("#4682B4"));
	}
}
