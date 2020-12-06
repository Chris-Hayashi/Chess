package application;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
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

			// Buttons
			List<Button> buttons = createButtons();

			// Image
			InputStream stream = new FileInputStream("resources\\images\\chess_icon.png");
			Image image = new Image(stream);
			ImageView imageView = new ImageView(image);
			imageView.setFitWidth(500);
			imageView.setPreserveRatio(true);

			// Virtual Box
			VBox vBox = displayVBox(buttons, imageView);

			// Border Pane
			BorderPane root = setBorderPane(chessLbl, vBox);

			// Set Scene and Stage
			Scene mainScene = new Scene(root, 800, 800);
			mainScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(mainScene);
			primaryStage.show();

			// Event Handlers
			Button startBtn = buttons.get(0);
			Button exitBtn = buttons.get(1);
			startBtn.setOnAction(event -> {
				@SuppressWarnings("unused")
				BoardUI boardUI = new BoardUI(primaryStage, mainScene);
			});
			exitBtn.setOnAction(event -> primaryStage.close());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private List<Button> createButtons() {
		// Start Button
		Button startBtn = new Button("Start Game");
		Button exitBtn = new Button("Exit");

		// Button dimensions
		startBtn.setPrefSize(300, 75);
		exitBtn.setPrefSize(300, 75);

		// Button Fonts
		startBtn.setFont(new Font("Arial", 24));
		exitBtn.setFont(new Font("Arial", 24));

		// Button List
		List<Button> buttons = new ArrayList<Button>();
		buttons.add(startBtn);
		buttons.add(exitBtn);

		return buttons;
	}

	private VBox displayVBox(List<Button> buttons, ImageView imageView) {
		// Create VBox
		VBox vBox = new VBox();

		// Add Buttons to VBox
		vBox.getChildren().add(imageView);

		for (Button b : buttons) {
			vBox.getChildren().add(b);
		}

		// VBox settings
		vBox.setAlignment(Pos.CENTER);
		vBox.setSpacing(30);

		return vBox;
	}

	private BorderPane setBorderPane(Label lbl, VBox vBox) {
		// BorderPane
		BorderPane root = new BorderPane();

		// Insets
		Insets insets = new Insets(100, 100, 0, 100);

		// Configure BorderPane
		root.setTop(lbl);
		root.setCenter(vBox);
		BorderPane.setMargin(lbl, insets);
		BorderPane.setAlignment(lbl, Pos.CENTER);
		root.setStyle("-fx-background-color: rgb(170,170,170)");

		return root;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
