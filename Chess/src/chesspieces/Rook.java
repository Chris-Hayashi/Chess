package chesspieces;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import application.Tiles;

public class Rook extends ChessPiece {
	public Rook(Boolean isWhite, int x, int y) {
		super(isWhite, x, y);
	}

	@Override
	public InputStream display() {
		InputStream stream;
		if (getWhite()) {
			// display white Rook
			try {
				stream = new FileInputStream("resources\\Sprites\\white_rook.png");
				return stream;

			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			// display black Rook
			try {
				stream = new FileInputStream("resources\\Sprites\\black_rook.png");
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
		// moving along y axis
		if (dest_x == getX() && dest_y != getY()) {
			setX(dest_x);
			setY(dest_y);
			return true;
		}
		// moving along x axis
		else if (dest_y == getY() && dest_x != getX()) {
			setX(dest_x);
			setY(dest_y);
			return true;
		}
		return false;
	}
}
