package chesspieces;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import application.Tiles;
import javafx.scene.Group;

public class Bishop extends ChessPiece {
	public Bishop(Boolean isWhite, int x, int y) {
		super(isWhite, x, y);
	}

	@Override
	public InputStream display() {
		InputStream stream;
		if (getWhite()) {
			// display white rook
			try {
				stream = new FileInputStream("/Users/yasuo/git/Chess/Chess/resources/Sprites/white_bishop.png");
				return stream;
			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			// display black rook
			try {
				stream = new FileInputStream("/Users/yasuo/git/Chess/Chess/resources/Sprites/black_bishop.png");
				return stream;
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return null;
	}
	
	@Override
	public Boolean isValid(ChessPiece piece, int dest_x, int dest_y, ArrayList<Tiles> tileList) {
		if (!checkPath(getX(), getY(), dest_x, dest_y, tileList))
			return false;
		int diagonal = dest_x - getX();
		
		int tempX = getX();
		int tempY = getY();
		for (int i = 1; i < (Math.abs(dest_x - getX()) + 1); i++) {
//			for (int j )
		}
		
		if ((Math.abs(dest_y - getY()) - Math.abs(dest_x - getX())) == 0) {
			setX(dest_x);
			setY(dest_y);
			return true;
		}
		else if(dest_y == getY() - diagonal && dest_y != getY()){
			setX(dest_x);
			setY(dest_y);
			return true;
		}
		return false;
	}

	
}
