package chesspieces;

import java.io.InputStream;
import java.util.ArrayList;

import application.CheckMove;
import application.Tiles;
import javafx.scene.Group;
import javafx.scene.image.ImageView;

public abstract class ChessPiece extends CheckMove {
	
	private int current_x;
	private int current_y;
	private Boolean isWhite;
	
	// Constructor
	ChessPiece(Boolean isWhite, int x, int y) {
		this.isWhite = isWhite;
		this.current_x = x;
		this.current_y = y;
	}
	
	// Get Piece Color
	public Boolean getWhite() {
		return isWhite;
	}
	
	// Get X coordinate
	public int getX() {
		return current_x;
	}
	
	//Get Y Coordinate
	public int getY() {
		return current_y;
	}
	
	// Set X coordinate
	public void setX(int dest_x) {
		this.current_x = dest_x;
	}
	
	// Set Y coordinate
	public void setY(int dest_y) {
		this.current_y = dest_y;
	}
	
	// Move Piece
	public Boolean move(int dest_x, int dest_y, ArrayList<Tiles> tileList) {
		return isValid(this, dest_x, dest_y, tileList);
	}
	public abstract InputStream display();
}
