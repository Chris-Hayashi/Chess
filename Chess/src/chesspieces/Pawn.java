package chesspieces;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import application.Tiles;

public class Pawn extends ChessPiece {

	public Pawn(Boolean isWhite, int x, int y) {
		super(isWhite, x, y);
	}

	@Override
	public InputStream display() {
		InputStream stream;
		if (getWhite()) {
			// display white Pawn
			try {
				stream = new FileInputStream("resources\\Sprites\\white_pawn.png");
				return stream;

			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			// display black Pawn
			try {
				stream = new FileInputStream("resources\\Sprites\\black_pawn.png");
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


		// conditions for white piece
		if (getWhite() == true) {
			// initial position
			if ((getY() == 6) && (Math.abs(dest_y - getY()) == 2) && (dest_x == getX()) && (tile.getPiece() == null)) {
				setX(dest_x);
				setY(dest_y);
				return true;
			}
			// moving up 1 space
			else if ((dest_y == getY() - 1) && (dest_x == getX() && (tile.getPiece() == null))) {
				setX(dest_x);
				setY(dest_y);
				return true;
			}
			// capturing a piece
			else if (tile.getPiece() != null) {
				if ((dest_y == getY() - 1) && (Math.abs(dest_x - getX()) == 1)
						&& tile.getPiece().getWhite() != piece.getWhite()) {
					setX(dest_x);
					setY(dest_y);
					return true;
				}
			}
			return false;
		}
		// conditions for black piece
		else {

			// initial position
			if ((getY() == 1) && (Math.abs(dest_y - getY()) == 2) && (dest_x == getX()) && (tile.getPiece() == null)) {
				setX(dest_x);
				setY(dest_y);
				return true;
			}
			// moving up 1 space
			else if ((dest_y == getY() + 1) && (dest_x == getX()) && (tile.getPiece() == null)) {
				setX(dest_x);
				setY(dest_y);
				return true;
			}
			// capturing a piece
			else if (tile.getPiece() != null) {
				if ((dest_y == getY() + 1) && (Math.abs(dest_x - getX()) == 1)
						&& tile.getPiece().getWhite() != piece.getWhite()) {
					setX(dest_x);
					setY(dest_y);
					return true;
				}
			}
			return false;
		}
	}

}
