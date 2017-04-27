import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameInterface extends Application {
	
	private final int winWidth = 1080;
	private final int winHeight = 720;
	
	// -- Tests --
	private final int [][]arrayTest = {
		{0, 0, 0, 0},
		{0, 0, 0, 0},
		{0, 0, 0, 0}};
	
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
		
		// -- Grille Jeu --
		// TODO
		
		// -- Info Joueurs --
		Rectangle rectInfo = new Rectangle(0, 0, ((winWidth-6)/2), 208);
		rectInfo.setFill(Color.LIGHTGREY);
		Text textPlayer = new Text("Joueur");
		textPlayer.setStyle("-fx-font-size: 50pt;");
		
		// -- Info Bouttons --
		Rectangle rectButton = new Rectangle(((winWidth-6)/2), 0, ((winWidth-6)/2), 208);
		rectButton.setFill(Color.LIGHTGREY);
		Button buttonUndo = new Button("Undo");
		Button buttonSave = new Button("Save");
		Button buttonMenu = new Button("Menu");
		buttonUndo.setMaxHeight(Double.MAX_VALUE);
		buttonSave.setMaxHeight(Double.MAX_VALUE);
		buttonMenu.setMaxHeight(Double.MAX_VALUE);
		buttonUndo.setStyle("-fx-font-size: 20pt;");
		buttonSave.setStyle("-fx-font-size: 20pt;");
		buttonMenu.setStyle("-fx-font-size: 20pt;");
		HBox hBoxButtons = new HBox();
		hBoxButtons.setSpacing(30);
		hBoxButtons.setMaxHeight(104);
		hBoxButtons.getChildren().addAll(buttonUndo, buttonSave, buttonMenu);
		
		
		
		// -- GridPaneGame --
		//gridPaneGame.add(b1, 0, 0);
		
		// -- GridPanePlayer --
		gridPanePlayer.setHgap(1);
		gridPanePlayer.add(rectInfo, 0, 0); GridPane.setColumnSpan(rectInfo, 200);
		gridPanePlayer.add(textPlayer, 100, 0);
		
		// -- GridPaneButtons --
		gridPaneButtons.setHgap(28);
		gridPaneButtons.add(rectButton, 0, 0); GridPane.setColumnSpan(rectButton, 20);
		gridPaneButtons.add(hBoxButtons, 3, 0);
		
		
		
		// -- Scene --
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
