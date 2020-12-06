package application;

import java.util.ArrayList;

import chesspieces.ChessPiece;

public abstract class CheckMove {

	public abstract Boolean isValid(ChessPiece piece, int dest_x, int dest_y, ArrayList<Tiles> tileList, Tiles tile);

	// ensures that the chess piece being moved does not collide or move through
	// another piece in its path
	public Boolean checkPath(int startX, int startY, int destX, int destY, ArrayList<Tiles> tileList) {

		int difX = destX - startX;
		int difY = destY - startY;
		if (difX != 0) { // left and right
			if (difX > 0) { // right
				if (difY > 0) { // Bottom Right Diagonal
					for (int i = 1; i < Math.abs(difX); i++) {
						// startX + i, startY + i
						for (Tiles tile : tileList) {
							Tiles tempTile = tile;
							if ((tempTile.get_X() == startX + i) && (tempTile.get_Y() == startY + i))
								if (tempTile.getPiece() != null)
									return false;
						}
					}
					return true;
				} else if (difY < 0) { // right above
					for (int i = 1; i < Math.abs(difX); i++) {
						// startX + a, startY - a
						for (Tiles tile : tileList) {
							Tiles tempTile = tile;
							if ((tempTile.get_X() == startX + i) && (tempTile.get_Y() == startY - i))
								if (tempTile.getPiece() != null)
									return false;
						}
					}
					return true;
				} else if (difY == 0) { // right straight
					for (int i = 1; i < Math.abs(difX); i++) {
						// startX + a, startY
						for (Tiles tile : tileList) {
							Tiles tempTile = tile;
							if ((tempTile.get_X() == startX + i) && (tempTile.get_Y() == startY))
								if (tempTile.getPiece() != null)
									return false;
						}
					}
					return true;
				}
			} else if (difX < 0) { // left
				if (difY > 0) { // left below
					for (int i = 1; i < Math.abs(difX); i++) {
						// startX - a, startY + a
						for (Tiles tile : tileList) {
							Tiles tempTile = tile;
							if ((tempTile.get_X() == startX - i) && (tempTile.get_Y() == startY + i))
								if (tempTile.getPiece() != null)
									return false;

						}
					}
					return true;
				} else if (difY < 0) { // left above
					for (int i = 1; i < Math.abs(difX); i++) {
						// startX - a, startY - a
						for (Tiles tile : tileList) {
							Tiles tempTile = tile;
							if ((tempTile.get_X() == startX - i) && (tempTile.get_Y() == startY - i))
								if (tempTile.getPiece() != null)
									return false;
						}
					}
					return true;
				} else if (difY == 0) { // left straight
					for (int i = 1; i < Math.abs(difX); i++) {
						// startX - a, startY
						for (Tiles tile : tileList) {
							Tiles tempTile = tile;
							if ((tempTile.get_X() == startX - i) && (tempTile.get_Y() == startY))
								if (tempTile.getPiece() != null)
									return false;
						}
					}
					return true;
				}
			}
		} else if (difX == 0) { // up and down
			if (difY > 0) { // down straight
				for (int i = 1; i < Math.abs(difY); i++) {
					// startX, startY + a
					for (Tiles tile : tileList) {
						Tiles tempTile = tile;
						if ((tempTile.get_X() == startX) && (tempTile.get_Y() == startY + i))
							if (tempTile.getPiece() != null)
								return false;
					}
				}
				return true;
			} else { // difY < 0 up straight
				for (int i = 1; i < Math.abs(difY); i++) {
					// startX, startY - a
					for (Tiles tile : tileList) {
						Tiles tempTile = tile;
						if ((tempTile.get_X() == startX) && (tempTile.get_Y() == startY - i))
							if (tempTile.getPiece() != null)
								return false;
					}
				}
				return true;
			}
		}
		return false;
	};
}
