package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

import chesspieces.Bishop;
import chesspieces.ChessPiece;
import chesspieces.King;
import chesspieces.Knight;
import chesspieces.Pawn;
import chesspieces.Queen;
import chesspieces.Rook;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BoardUI {
	public static final int Size = 90;
	public static final int Board_X = 275; // x-coordinate of board
	public static final int Board_Y = 100; // y-coordinate of board

	// Coordinates
	private int x1 = -1;
	private int y1 = -1;
	private int x2 = -1;
	private int y2 = -1;
	private CheckMove checkMove = new CheckMove();

	private Tiles tileClicked = null;

	public BoardUI(Stage primaryStage, Scene mainScene) {
		try {

			BorderPane root = new BorderPane();

			// Top Right Title
			Label title = new Label("Chess!");
			title.setFont(new Font("Arial", 40));
			title.setPadding(new Insets(20, 20, 20, 20));

			VBox vbox = VboxUI(primaryStage, mainScene);
			Group tileGroup = new Group();
			Group spriteGroup = new Group();

			root.setRight(vbox);
			root.setLeft(title);
			root.setStyle("-fx-background-color: rgb(211,211,211)");

			root.getChildren().addAll(tileGroup); // for placing tiles
			root.getChildren().addAll(spriteGroup); // for placing pieces

			displayTile(tileGroup, spriteGroup);

			// sets scene to be 1280 x 900p
			Scene scene = new Scene(root, 1280, 900);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// creating the chess tiles and setting them to root on the pane
	private void displayTile(Group tileGroup, Group spriteGroup) {
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {			
				ChessPiece piece = piece(x,y);
				Tiles tile = new Tiles((x + y) % 2 == 0, x, y, piece);
				
				//Displays Image
				Image image = null;
				ImageView imageView = new ImageView();
				if (tile.getPiece() != null) 
					image = new Image(tile.getPiece().display());

					imageView.setImage(image);
					imageView.setFitWidth(Size / 1.5);
					imageView.setX(Board_X + Size * x + Size / 6);
					imageView.setY(Board_Y + Size * y + Size / 6);
					imageView.setPreserveRatio(true);
					imageView.setDisable(true);

				tile.setCursor(Cursor.HAND);
				tile.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
					Image imageClicked=null;
					// User Selects 1st Tile
					if (tileClicked == null&&tile.getPiece()!=null) {
						tileClicked = tile;
						imageClicked=new Image(tile.getPiece().display());
						x1 = (int) (event.getSceneX() - Board_X) / Size;
						y1 = (int) (event.getSceneY() - Board_Y) / Size;
						tile.setStrokeWidth(2);
						tile.setStroke(Color.RED);
						imageView.setImage(null);
					}
					// User selects 2nd Tile
					else if(tileClicked!=null){
						tileClicked.setStroke(Color.TRANSPARENT);
						
						x2 = (int) (event.getSceneX() - Board_X) / Size;
						y2 = (int) (event.getSceneY() - Board_Y) / Size;
						System.out.println(x1 + "," + y1);
						System.out.println(x2 + "," + y2);
						// if(CheckMove.isValidMove(x1,y1,x2,y2,tileClicked,tile));
						// move tile 1 piece to tile 2, and delete tile 2 piece
						// CheckWin...();
						//replace sprite pieces
						
						imageClicked = new Image(tileClicked.getPiece().display());
						imageView.setImage(imageClicked);
						//replace tile pieces
						ChessPiece tempPiece = tileClicked.getPiece();
						tileClicked.setPiece(null);
						tile.setPiece(tempPiece);
						tileClicked = null;
						//reset coordinates
						x1=-1;
						y1=-1;
						x2=-1;
						y2=-1;	
					}
					
				});
				spriteGroup.getChildren().add(imageView);
				tileGroup.getChildren().add(tile);
			}

		}
	}
	
	//Initializes the chess board with each piece in the required positions
	// pawnlayer is for placing the pawns on the board
	// piecelayer is for placing the pieces other than pawns on the board
	private ChessPiece piece(int x, int y) {
		ChessPiece piece = null;
		boolean piecelayer = false;
		boolean pawnlayer = false;
		boolean isWhite = false;

		if (y == 0 || y == 7) {// for determining piece layers
			if (y > 5)
				isWhite = true;
			else
				isWhite = false;
			piecelayer = true;
		} else if (y == 1 || y == 6) {// for determining pawn layers
			pawnlayer = true;
			if (y == 1)
				isWhite = false;
			else
				isWhite = true;
		} else {
			piecelayer = false;
			pawnlayer = false;
		}
		if (piecelayer) {
			if (x == 0 || x == 7) {// place rook
				piece = new Rook(isWhite, x, y);

			} else if (x == 1 || x == 6) {// place knight
				piece = new Knight(isWhite, x, y);
			} else if (x == 2 || x == 5) {// place bishop
				piece = new Bishop(isWhite, x, y);
			} else if (x == 3) {// place queen
				piece = new Queen(isWhite, x, y);
			} else if (x == 4) {// place king
				piece = new King(isWhite, x, y);
			}
		} else if (pawnlayer) {// place pawns
			piece = new Pawn(isWhite, x, y);
		}
		return piece;
	}

	// Handle Buttons on right side of UI
	private VBox VboxUI(Stage primaryStage, Scene mainScene) {

		VBox vbox = new VBox();

		// Save Game Button
		Button saveGame = new Button("Save Game");
		saveGame.setPrefSize(100, 50);

		saveGame.setOnAction(arg0 -> {
			// save board file here
			System.out.println("game saved!");
			// print file save location
		});

		Button exitGame = new Button("Exit to Menu");
		exitGame.setPrefSize(100, 50);
		exitGame.setOnAction(event -> ExitConfirm(primaryStage, mainScene));

		// Vbox Adjustments
		vbox.setPadding(new Insets(10, 10, 10, 10));
		vbox.setSpacing(20);
		vbox.setAlignment(Pos.BOTTOM_CENTER);
		vbox.getChildren().addAll(saveGame, exitGame);

		return vbox;
	}

	// Handles Exit Confirmation GUI
	private void ExitConfirm(Stage primaryStage, Scene mainScene) {

		Stage exitStage = new Stage();

		Label lbl = new Label("Are you sure you want to exit?");
		lbl.setFont(new Font("Arial", 18));

		// Yes Button
		Button ybtn = new Button("Yes");
		ybtn.setPrefSize(50, 30);
		ybtn.setOnAction(arg0 -> {
			exitStage.close();
			primaryStage.setScene(mainScene);
			System.out.println("Sucessfully Exited Game");
		});

		// No Button
		Button nbtn = new Button("No");
		nbtn.setPrefSize(50, 30);
		nbtn.setOnAction(arg0 -> {
			exitStage.close();
			System.out.println("Cancelled Exit Game");
		});

		VBox vbox = new VBox(); // handles label and hbox
		HBox hbox = new HBox(); // handles buttons

		// HBox adjustments
		hbox.getChildren().add(ybtn);
		hbox.getChildren().add(nbtn);
		hbox.setAlignment(Pos.CENTER);
		hbox.setSpacing(25);

		// Vbox adjustments
		vbox.getChildren().add(lbl);
		vbox.getChildren().add(hbox);
		vbox.setSpacing(20);
		vbox.setAlignment(Pos.CENTER);

		Scene exitConfirm = new Scene(vbox, 250, 100);

		exitStage.setScene(exitConfirm);
		exitStage.show();
		return;
	}

}
