package application;

import java.io.InputStream;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BoardUI {

	public BoardUI(Stage primaryStage, Scene mainScene){
		try {
//			Stage primaryStage = new Stage();
			BorderPane root = new BorderPane();
			
			Label title = new Label("Chess!");
			title.setFont(new Font("Arial", 40));
			title.setPadding(new Insets(20, 20, 20, 20));
			
			VBox vbox = VboxUI(primaryStage, mainScene);
			
			// placeholder for chessboard
			
			InputStream image = new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/Chess_Board.svg/768px-Chess_Board.svg.png").openStream();
			Image tempchessboard = new Image(image);
			ImageView chessboard = new ImageView(tempchessboard);
			
			/*
			FileInputStream inputstream = new FileInputStream("768px-Chess_Board.svg");
			Image image = new Image(inputstream);
			ImageView chessboard = new ImageView(image);
			*/
			
			root.setRight(vbox);
			root.setLeft(title);
			root.setCenter(chessboard);
			
			Scene scene = new Scene(root,1280,720);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// Handle Buttons on right side of UI	
	private VBox VboxUI(Stage primaryStage, Scene mainScene) {
		
		VBox vbox = new VBox();
		
		Button saveGame = new Button("Save Game");
		saveGame.setPrefSize(100, 50);
		saveGame.setOnAction(arg0 -> System.out.println("game saved!"));
		
		Button exitGame = new Button("Exit to Menu");
		exitGame.setPrefSize(100, 50);
		exitGame.setOnAction(event -> ExitConfirm(primaryStage, mainScene));
		
		
		vbox.setPadding(new Insets(10, 10, 10, 10));
		vbox.setSpacing(20);
		vbox.setAlignment(Pos.BOTTOM_CENTER);
		vbox.getChildren().addAll(saveGame,exitGame);
		
		return vbox;
	}
	
	//Handles Exit Confirmation GUI
	private void ExitConfirm(Stage primaryStage, Scene mainScene) {
		
		Stage exitStage = new Stage();
		
		Label lbl = new Label("Are you sure you want to exit?");
		lbl.setFont(new Font ("Arial",18));
		
		// Yes Button
		Button ybtn = new Button ("Yes");
		ybtn.setPrefSize(50, 30);
		ybtn.setOnAction(arg0 -> {		
				exitStage.close();
				primaryStage.setScene(mainScene);
				System.out.println("Sucessfully Exited Game");
		});
		
		// No Button
		Button nbtn = new Button ("No");
		nbtn.setPrefSize(50, 30);
		nbtn.setOnAction(arg0 -> {
				exitStage.close();	
				System.out.println("Cancelled Exit Game");
		});
		
		VBox vbox = new VBox();
		HBox hbox = new HBox();
		
		hbox.getChildren().add(ybtn);
		hbox.getChildren().add(nbtn);
		hbox.setAlignment(Pos.CENTER);
		hbox.setSpacing(25);
		vbox.getChildren().add(lbl);
		vbox.getChildren().add(hbox);
		vbox.setSpacing(20);
		vbox.setAlignment(Pos.CENTER);
		
		
		Scene exitConfirm = new Scene(vbox,250,100);
		
		exitStage.setScene(exitConfirm);
		exitStage.show();
		return;
	}
	
	
}
