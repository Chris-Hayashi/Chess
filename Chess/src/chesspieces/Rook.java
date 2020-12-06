package chesspieces;

import java.io.FileInputStream;
import java.io.InputStream;

import javafx.scene.Group;

public class Rook extends ChessPiece {
	public Rook(Boolean isWhite, int x, int y) {
		super(isWhite, x, y);
	}
	
	@Override
	public InputStream display() {
		InputStream stream;
		if (getWhite()) {
			//display white rook
			try {
				stream = new FileInputStream("/Users/yasuo/git/Chess/Chess/resources/Sprites/white_rook.png");
				return stream;		
				
			} catch (Exception e) {
				System.out.println(e);
			}		
		}
		else {
			//display black rook
			try {
				stream = new FileInputStream("/Users/yasuo/git/Chess/Chess/resources/Sprites/black_rook.png");
				return stream;
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return null;
	}
	
	@Override
	public Boolean isValid(ChessPiece piece, int dest_x, int dest_y, Group tileGroup) {
		if(dest_x == getX() && dest_y != getY()){
			setX(dest_x);
			setY(dest_y);
			return true;
		}
		else if(dest_y == getY() && dest_x != getX()){
			setX(dest_x);
			setY(dest_y);
			return true;
		}
		return false;
	}
}
