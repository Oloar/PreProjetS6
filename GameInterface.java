package preprojets6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GameInterface extends Application {
	
	int winWidth = 1080;
	int winHeight = 720;
	
	@Override
	public void start(Stage primaryStage) {
		BorderPane borderPane = new BorderPane();
		BorderPane borderPaneInfo = new BorderPane();
		GridPane gridPaneGame = new GridPane();
		GridPane gridPanePlayer = new GridPane();
		GridPane gridPaneButtons = new GridPane();
		
		borderPane.setTop(gridPaneGame);
		borderPane.setBottom(borderPaneInfo);
		borderPaneInfo.setLeft(gridPanePlayer);
		borderPaneInfo.setRight(gridPaneButtons);
		
		Rectangle rectInfo = new Rectangle(0, 0, winWidth-6, 208);
		rectInfo.setFill(Color.LIGHTGREY);
		
		//gridPaneGame.add(b1, 0, 0);
		gridPanePlayer.add(rectInfo, 0, 0);
		//gridPaneButtons.add(b3, 0, 0);
		
		
		Scene scene = new Scene(borderPane, 300, 250);
		
		primaryStage.setTitle("Gauffre");
		primaryStage.setWidth(winWidth);
		primaryStage.setHeight(winHeight);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
