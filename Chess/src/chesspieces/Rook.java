package chesspieces;

import java.io.FileInputStream;
import java.io.InputStream;

public class Rook extends ChessPiece {
	public Rook(Boolean isWhite, int x, int y) {
		super(isWhite, x, y);
	}
	
	@Override
	public InputStream display() {
		InputStream stream;
		if (isWhite) {
			//display white rook
			try {
				stream = new FileInputStream("resources\\Sprites\\white_rook.png");
				return stream;		
				
			} catch (Exception e) {
				System.out.println(e);
			}		
		}
		else {
			//display black rook
			try {
				stream = new FileInputStream("resources\\Sprites\\black_rook.png");
				return stream;
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return null;
	}
}
