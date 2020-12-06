package chesspieces;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import application.Tiles;

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
				stream = new FileInputStream("resources\\Sprites\\white_queen.png");
				return stream;

			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			// display black rook
			try {
				stream = new FileInputStream("resources\\Sprites\\black_queen.png");
				return stream;
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		return null;
	}

	@Override
	public Boolean isValid(ChessPiece piece, int dest_x, int dest_y, ArrayList<Tiles> tileList, Tiles tile) {
		if(tile.getPiece()!=null) {
			if (piece.getWhite()==tile.getPiece().getWhite()){
				return false;
			}
		}
		if (!checkPath(getX(), getY(), dest_x, dest_y, tileList))
			return false;
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
