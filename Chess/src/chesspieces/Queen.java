package chesspieces;

import java.io.FileInputStream;
import java.io.InputStream;

import javafx.scene.Group;

public class Queen extends ChessPiece {

	public Queen(Boolean isWhite, int x, int y) {
		super(isWhite, x, y);
	}

	@Override
	public InputStream display() {
		InputStream stream;
		if (getWhite()) {
			// display white rook
			try {
				stream = new FileInputStream("/Users/yasuo/git/Chess/Chess/resources/Sprites/white_queen.png");
				return stream;

			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			// display black rook
			try {
				stream = new FileInputStream("/Users/yasuo/git/Chess/Chess/resources/Sprites/black_queen.png");
				return stream;
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		return null;
	}

	@Override
	public Boolean isValid(ChessPiece piece, int dest_x, int dest_y, Group tileGroup) {
		int diagonal = dest_x - getX();

		if ((Math.abs(dest_y - getY()) - Math.abs(dest_x - getX())) == 0) {
			setX(dest_x);
			setY(dest_y);
			return true;
		} else if (dest_y == getY() - diagonal && dest_y != getY()) {
			setX(dest_x);
			setY(dest_y);
			return true;
		} else if (dest_x == getX() && dest_y != getY()) {
			setX(dest_x);
			setY(dest_y);
			return true;
		} else if (dest_y == getY() && dest_x != getX()) {
			setX(dest_x);
			setY(dest_y);
			return true;
		}
		return false;
	}

}
