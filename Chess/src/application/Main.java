package application;
	
import java.io.InputStream;
import java.net.URL;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			// Chess Label
			Label chessLbl = new Label("Chess");
			chessLbl.setId("chessLbl");
			chessLbl.setFont(Font.loadFont("file:resources/fonts/Ondine.ttf", 120));
			
//			// Chess Icon
//			InputStream image = new URL("file: resources/images/chess_icon.jpg").openStream();
//			Image chessImage= new Image(image);
//			ImageView chessIcon = new ImageView(chessImage);
			
			// Start Button
			Button startBtn = new Button("Start Game");
			Button loadBtn = new Button("Load Game");
			Button exitBtn = new Button("Exit");
			
			//Button dimensions
			startBtn.setPrefSize(300, 75);
			loadBtn.setPrefSize(300, 75);
			exitBtn.setPrefSize(300, 75);
			
			//Button Fonts
			startBtn.setFont(new Font("Arial", 24));
			loadBtn.setFont(new Font("Arial", 24));
			exitBtn.setFont(new Font("Arial", 24));
			
			//Virtual Box
			VBox vBox = new VBox();
			vBox.getChildren().add(startBtn);
			vBox.getChildren().add(loadBtn);
			vBox.getChildren().add(exitBtn);
			vBox.setAlignment(Pos.CENTER);
			vBox.setSpacing(20);
			
			//Insets
			Insets insets = new Insets(100, 100, 100, 100);
			
			// Border Pane
			BorderPane root = new BorderPane();
			root.setTop(chessLbl);
			root.setCenter(vBox);
			root.setMargin(chessLbl, insets);
			root.setAlignment(chessLbl,Pos.CENTER);
			root.setStyle("-fx-background-color: rgb(170,170,170)");
			
			
			Scene mainScene = new Scene(root,800,800);
			mainScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(mainScene);
			primaryStage.show();
			
			startBtn.setOnAction(event -> {
				BoardUI boardUI = new BoardUI(primaryStage, mainScene);
			});
			exitBtn.setOnAction(event -> primaryStage.close());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
