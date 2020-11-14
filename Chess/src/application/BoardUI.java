package application;

import java.io.InputStream;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class BoardUI {
	public static final int Size = 90;
	public static final int Board_X = 275; //x-coordinate of board
	public static final int Board_Y = 100; //y-coordinate of board
	
	public BoardUI(Stage primaryStage, Scene mainScene){
		try {

			BorderPane root = new BorderPane();
			
			//Top Right Title
			Label title = new Label("Chess!");
			title.setFont(new Font("Arial", 40));
			title.setPadding(new Insets(20, 20, 20, 20));
			
			VBox vbox = VboxUI(primaryStage, mainScene);
			
			
			Group tileGroup = new Group();
			
			
			root.setRight(vbox);
			root.setLeft(title);
			root.setStyle("-fx-background-color: rgb(211,211,211)");
			
			root.getChildren().addAll(tileGroup); //for placing tiles 
			//root.getChildren().addAll(spriteGroup); //for placing pieces
			
			for(int y=0; y<8; y++){ //creating the chess tiles and setting them to root on the pane
				for(int x=0; x<8; x++){
					Tiles tile = new Tiles((x + y)%2 == 0, x, y);
					
					tileGroup.getChildren().add(tile);
				}
			}
			
			/*for(int y=0; y<8; y++){ //creating the chess tiles and setting them to root on the pane
				for(int x=0; x<8; x++){
					Sprites piece = new Sprites(x, y);
					
					spriteGroup.getChildren().add(piece);
				}
			}*/
			
			//sets scene to be 1280 x 900p
			Scene scene = new Scene(root,1280,900);
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
		
		//Save Game Button 
		Button saveGame = new Button("Save Game");
		saveGame.setPrefSize(100, 50);

		saveGame.setOnAction(arg0 ->{
				// save board file here
				System.out.println("game saved!");
				// print file save location
		});
		
		Button exitGame = new Button("Exit to Menu");
		exitGame.setPrefSize(100, 50);
		exitGame.setOnAction(event -> ExitConfirm(primaryStage, mainScene));

		//Vbox Adjustments
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
		
		VBox vbox = new VBox(); // handles label and hbox
		HBox hbox = new HBox(); // handles buttons
		
		//HBox adjustments
		hbox.getChildren().add(ybtn);
		hbox.getChildren().add(nbtn);
		hbox.setAlignment(Pos.CENTER);
		hbox.setSpacing(25);
		
		//Vbox adjustments
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
