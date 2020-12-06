package chesspieces;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import application.Tiles;

public class King extends ChessPiece {
	public King(Boolean isWhite, int x, int y) {
		super(isWhite, x, y);
	}

	@Override
	public InputStream display() {
		InputStream stream;
		if (getWhite()) {
			// display white King
			try {
				stream = new FileInputStream("resources\\Sprites\\white_king.png");
				return stream;

			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			// display black King
			try {
				stream = new FileInputStream("resources\\Sprites\\black_king.png");
				return stream;
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return null;
	}

	@Override
	public Boolean isValid(ChessPiece piece, int dest_x, int dest_y, ArrayList<Tiles> tileList, Tiles tile) {
		// if two tiles selected contains the same color piece then move is invalid
		if (tile.getPiece() != null) {
			if (piece.getWhite() == tile.getPiece().getWhite()) {
				return false;
			}
		}
		if (!checkPath(getX(), getY(), dest_x, dest_y, tileList))
			return false;
		// checks for moving one tile in any direction
		if (dest_x == getX() + 1 || dest_x == getX() || dest_x == getX() - 1) {
			if (dest_y == getY() + 1 || dest_y == getY() || dest_y == getY() - 1) {
				if (dest_x == getX() && dest_y == getY()) {
					return false;
				} else {
					setX(dest_x);
					setY(dest_y);
					return true;
				}
			}
		}
		return false;
	}
}
