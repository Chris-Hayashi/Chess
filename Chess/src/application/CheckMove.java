package application;

import java.util.ArrayList;

import chesspieces.ChessPiece;
import javafx.scene.Group;

public abstract class CheckMove {
	private Boolean valid;
	private Boolean inCheck;

	public CheckMove() {
		valid = false;
		inCheck = false;
	}

//	private Boolean isValid(ChessPiece piece) {
//		
//		return valid;
//	}

	public abstract Boolean isValid(ChessPiece piece, int dest_x, int dest_y, ArrayList<Tiles> tileList);

	private Boolean inCheck() {
		return inCheck;
	}

//	public void move() {
//		
//	}

	public Boolean checkPath(int startX, int startY, int destX, int destY, ArrayList<Tiles> tileList) {
		int difX = destX - startX;
		int difY = destY - startY;
		if (difX != 0) { // left and right
			if (difX > 0) { // right
				if (difY > 0) { // Bottom Right Diagonal
					for (int i = 1; i < Math.abs(difX); i++) {
						// startX + i, startY + i
						for (int j = 0; j < tileList.size(); j++) {
							Tiles tempTile = tileList.get(j);
							if (tempTile.get_X() == startX + i && tempTile.get_Y() == startY + i)
								if (tempTile.getPiece() != null)
									return true;
						}
						// is (6)(6) == null? else return false
					}
				} else if (difY < 0) { // right above
					for (int i = 1; i < Math.abs(difX); i++) {
						// startX + a, startY - a
						for (int j = 0; j < tileList.size(); j++) {
							Tiles tempTile = tileList.get(j);
							if (tempTile.get_X() == startX + i && tempTile.get_Y() == startY - i)
								if (tempTile.getPiece() != null)
									return true;
						}
					}
				} else if (difY == 0) { // right straight
					for (int i = 1; i < Math.abs(difX); i++) {
						// startX + a, startY
						for (int j = 0; j < tileList.size(); j++) {
							Tiles tempTile = tileList.get(j);
							if (tempTile.get_X() == startX + i && tempTile.get_Y() == startY)
								if (tempTile.getPiece() != null)
									return true;
						}
					}
				}
			} else if (difX < 0) { // left
				if (difY > 0) { // left below
					for (int i = 0; i < Math.abs(difX); i++) {
						// startX - a, startY + a
						for (int j = 0; j < tileList.size(); j++) {
							Tiles tempTile = tileList.get(j);
							if (tempTile.get_X() == startX - i && tempTile.get_Y() == startY + i)
								if (tempTile.getPiece() != null)
									return true;
						}
					}
				} else if (difY < 0) { // left above
					for (int i = 0; i < Math.abs(difX); i++) {
						// startX - a, startY - a
						for (int j = 0; j < tileList.size(); j++) {
							Tiles tempTile = tileList.get(j);
							if (tempTile.get_X() == startX - i && tempTile.get_Y() == startY - i)
								if (tempTile.getPiece() != null)
									return true;
						}
					}
				} else if (difY == 0) { // left straight
					for (int i = 0; i < Math.abs(difX); i++) {
						// startX - a, startY
						for (int j = 0; j < tileList.size(); j++) {
							Tiles tempTile = tileList.get(j);
							if (tempTile.get_X() == startX - i && tempTile.get_Y() == startY)
								if (tempTile.getPiece() != null)
									return true;
						}
					}
				}
			} else if (difX == 0) { // up and down
				if (difY > 0) { // down straight
					for (int i = 0; i < Math.abs(difY); i++) {
						// startX, startY + a
						for (int j = 0; j < tileList.size(); j++) {
							Tiles tempTile = tileList.get(j);
							if (tempTile.get_X() == startX && tempTile.get_Y() == startY + i)
								if (tempTile.getPiece() != null)
									return true;
						}
					}
				} else { // difY < 0 up straight
					for (int i = 0; i < Math.abs(difY); i++) {
						// startX, startY - a
						for (int j = 0; j < tileList.size(); j++) {
							Tiles tempTile = tileList.get(j);
							if (tempTile.get_X() == startX && tempTile.get_Y() == startY - i)
								if (tempTile.getPiece() != null)
									return true;
						}
					}

				}
			}
		}
		return false;
	};
}
