package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
//	public void startGame() {
//		
//	}
//	
//	public void loadGame() {
//		
//	}
//	
//	public void exit() {
//		
//	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Label chessLbl = new Label("Chess");
			
			// Start Button
			Button startBtn = new Button("Start Game");
			
			// Load Game
			Button loadBtn = new Button("Load Game");
			
			// Exit Program
			Button exitBtn = new Button("Exit");
			
			VBox root = new VBox();
			root.getChildren().add(chessLbl);
			root.getChildren().add(startBtn);
			root.getChildren().add(loadBtn);
			root.getChildren().add(exitBtn);
			
			Scene mainScene = new Scene(root,400,400);
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
