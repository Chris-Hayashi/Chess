package chesspieces;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Rook extends ChessPiece {
	public Rook(Boolean isWhite, int x, int y) {
		super(isWhite, x, y);
	}
	
	@Override
	public ImageView display() {
//		System.out.println("piece.display() is called.");
		InputStream stream;
		if (isWhite) {
			//display white rook
			//InputStream image = new URL("file: resources/Sprites/white_rook.png").openStream();
			try {
				System.out.println("try block executed");
				stream = new FileInputStream("resources\\Sprites\\white_rook.png");
				Image image= new Image(stream);
				ImageView imageView = new ImageView();
				imageView.setImage(image);
				return imageView;
//				System.out.println(stream.toString());
				
			} catch (Exception e) {
				System.out.println("catch executed");
				System.out.println(e);
			}
			
		}
		else {
			//display black rook
			try {
				System.out.println("try block executed");
				stream = new FileInputStream("resources\\Sprites\\black_rook.png");
				Image image= new Image(stream);
				ImageView imageView = new ImageView();
				imageView.setImage(image);
				return imageView;
//				System.out.println(stream.toString());
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
//		Image image= new Image(stream);
//		ImageView imageView = new ImageView();
//		imageView.setImage(image);
//		return imageView;
//		return null;
	}
}
