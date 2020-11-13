package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	public void startGame() {
		
	}
	
	public void loadGame() {
		
	}
	
	public void exit() {
		
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Label chessLbl = new Label("Chess");
			
			// Start Button
			Button startBtn = new Button("Start Game");
			startBtn.setOnAction(event ->)
			
			// Load Game
			Button loadBtn = new Button("Load Game");
			
			
			// Exit Program
			Button exitBtn = new Button("Exit");
			
			
			VBox root = new VBox();
			root.getChildren().add(chessLbl);
			root.getChildren().add(startBtn);
			root.getChildren().add(loadBtn);
			root.getChildren().add(exitBtn);
			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
