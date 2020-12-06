package chesspieces;

import java.io.FileInputStream;
import java.io.InputStream;

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
				stream = new FileInputStream("resources\\Sprites\\white_bishop.png");
				return stream;
			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			// display black rook
			try {
				stream = new FileInputStream("resources\\Sprites\\black_bishop.png");
				return stream;
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return null;
	}
	
	@Override
	public Boolean isValid(ChessPiece piece, int dest_x, int dest_y) {
		int diagonal = dest_x - getX();
		
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
