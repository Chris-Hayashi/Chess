package chesspieces;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import application.Tiles;

public class Knight extends ChessPiece {
	public Knight(Boolean isWhite, int x, int y) {
		super(isWhite, x, y);
	}

	@Override
	public InputStream display() {
		InputStream stream;
		if (getWhite()) {
			// display white Knight
			try {
				stream = new FileInputStream("resources\\Sprites\\white_knight.png");
				return stream;

			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			// display black Knight
			try {
				stream = new FileInputStream("resources\\Sprites\\black_knight.png");
				return stream;
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return null;
	}

	public Boolean isValid(ChessPiece piece, int dest_x, int dest_y, ArrayList<Tiles> tileList, Tiles tile) {
		// if two tiles selected contains the same color piece then move is invalid
		if (tile.getPiece() != null) {
			if (piece.getWhite() == tile.getPiece().getWhite()) {
				return false;
			}
		}
		if (dest_x == getX() + 2 || dest_x == getX() - 2) {
			if (dest_y == getY() + 1 || dest_y == getY() - 1) {
				setX(dest_x);
				setY(dest_y);
				return true;
			}
		} else if (dest_y == getY() + 2 || dest_y == getY() - 2) {
			if (dest_x == getX() + 1 || dest_x == getX() - 1) {
				setX(dest_x);
				setY(dest_y);
				return true;
			}
		}
		return false;
	}
}
