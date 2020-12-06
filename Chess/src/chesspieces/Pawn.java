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
			// display white rook
			try {
				stream = new FileInputStream("resources\\Sprites\\white_pawn.png");
				return stream;

			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			// display black rook
			try {
//				stream = new FileInputStream("/Users/yasuo/git/Chess/Chess/resources/Sprites/black_pawn.png");
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
		if(tile.getPiece()!=null) {
			if (piece.getWhite()==tile.getPiece().getWhite()){
				return false;
			}
		}
		if (!checkPath(getX(), getY(), dest_x, dest_y, tileList))
			return false;
		if(getWhite() == true) {
			if((getY() == 6) && (Math.abs(dest_y - getY()) == 2) && (dest_x == getX())){
				setX(dest_x);
				setY(dest_y);
				return true;
			}
			else if((dest_y == getY() - 1) && (dest_x == getX() && (tile.getPiece() == null))) {
					setX(dest_x);
					setY(dest_y);
					return true;
			}
			else if(tile.getPiece()!=null) {
				if ((dest_y==getY()-1)&&(Math.abs(dest_x-getX())==1)&&tile.getPiece().getWhite()!=piece.getWhite()) {
					setX(dest_x);
					setY(dest_y);
					return true;
				}
			}
			return false;
		}
		else {
			if((getY() == 1) && (Math.abs(dest_y - getY()) == 2) && (dest_x == getX())){
				setX(dest_x);
				setY(dest_y);
				return true;
			}
			else if((dest_y == getY() + 1) && (dest_x == getX()) && (tile.getPiece() == null)) {
					setX(dest_x);
					setY(dest_y);
					return true;
			}
			else if(tile.getPiece()!=null) {
				if ((dest_y==getY()+1)&&(Math.abs(dest_x-getX())==1)&&tile.getPiece().getWhite()!=piece.getWhite()) {
					setX(dest_x);
					setY(dest_y);
					return true;
				}
			}
			return false;
		}
	}
	
}
