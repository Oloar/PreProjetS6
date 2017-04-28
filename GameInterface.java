import java.io.File;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class GameInterface extends Application {
	
	private Scene gameScene;
	
	private GridPane gridPaneGame;
	private GridPane gridPanePlayer;
	
	private Text textNumPlayer;
	
	private final int STROKE_WIDTH = 3;
	
	private final int winWidth = 1080;
	private final int winHeight = 720;
	
	private int widthWaffle;
	private int heightWaffle;
	
	// -- Tests --
	//private final double arrayWPow = 3;
	//private final double arrayHPow = 2;
	//private final int widthWaffle = (int)Math.pow(2, arrayWPow);
	//private final int heightWaffle = (int)Math.pow(3, arrayHPow);
	/*private final Integer [][]arrayTest = {
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0}};*/
	
	
	
	public void initGameInterface (int widthWaffle, int heightWaffle) {
		this.widthWaffle = widthWaffle;
		this.heightWaffle = heightWaffle;
	}
	
	
	
	public Scene getGameScene () {
		return gameScene;
	}
	
	
	
	private static Scene fetchMenuScene () {
		return new MenuInterface().getMenuScene();
	}
	
	
	
	public void updateGame (Integer [][]arrayGame, Joueur player, int turnNumber) {
		for (int w=0; w<widthWaffle; w++) {
			for (int h=0; h<heightWaffle; h++) {
				if (arrayGame[h][w] == 0) {
					// Haut Gauche
					if (w == 0  &&  h == 0) {
						gridPaneGame.add(new ImageGame("ressources/waffle_top_left.png", gridPaneGame.getMaxWidth(), gridPaneGame.getMaxHeight(), widthWaffle, heightWaffle).getImgView(), w, h);
					}
					// Gauche
					else if (w == 0  &&  h != heightWaffle-1) {
						gridPaneGame.add(new ImageGame("ressources/waffle_left.png", gridPaneGame.getMaxWidth(), gridPaneGame.getMaxHeight(), widthWaffle, heightWaffle).getImgView(), w, h);
					}
					// Bas Gauche
					else if (w == 0  &&  h == heightWaffle-1) {
						gridPaneGame.add(new ImageGame("ressources/waffle_bottom_left.png", gridPaneGame.getMaxWidth(), gridPaneGame.getMaxHeight(), widthWaffle, heightWaffle).getImgView(), w, h);
					}
					// Haut
					else if (w != widthWaffle-1  &&  h == 0) {
						gridPaneGame.add(new ImageGame("ressources/waffle_top.png", gridPaneGame.getMaxWidth(), gridPaneGame.getMaxHeight(), widthWaffle, heightWaffle).getImgView(), w, h);
					}
					// Bas
					else if (w != widthWaffle-1  &&  h == heightWaffle-1) {
						gridPaneGame.add(new ImageGame("ressources/waffle_bottom.png", gridPaneGame.getMaxWidth(), gridPaneGame.getMaxHeight(), widthWaffle, heightWaffle).getImgView(), w, h);
					}
					// Haut Droite
					else if (w == widthWaffle-1  &&  h == 0) {
						gridPaneGame.add(new ImageGame("ressources/waffle_top_right.png", gridPaneGame.getMaxWidth(), gridPaneGame.getMaxHeight(), widthWaffle, heightWaffle).getImgView(), w, h);
					}
					// Droite
					else if (w == widthWaffle-1  &&  h != heightWaffle-1) {
						gridPaneGame.add(new ImageGame("ressources/waffle_right.png", gridPaneGame.getMaxWidth(), gridPaneGame.getMaxHeight(), widthWaffle, heightWaffle).getImgView(), w, h);
					}
					// Bas Droite
					else if (w == widthWaffle-1  &&  h == heightWaffle-1) {
						gridPaneGame.add(new ImageGame("ressources/waffle_bottom_right.png", gridPaneGame.getMaxWidth(), gridPaneGame.getMaxHeight(), widthWaffle, heightWaffle).getImgView(), w, h);
					}
					// Centre
					else {
						gridPaneGame.add(new ImageGame("ressources/waffle_center.png", gridPaneGame.getMaxWidth(), gridPaneGame.getMaxHeight(), widthWaffle, heightWaffle).getImgView(), w, h);
					}
				}
				else if (arrayGame[h][w] != 0  &&  arrayGame[h][w] == turnNumber) {
					if (player.getNumber() == 1) {
						gridPaneGame.add(new ImageGame("ressources/red.png", gridPaneGame.getMaxWidth(), gridPaneGame.getMaxHeight(), widthWaffle, heightWaffle).getImgView(), w, h);
					}
					else if (player.getNumber() == 2) {
						gridPaneGame.add(new ImageGame("ressources/blue.png", gridPaneGame.getMaxWidth(), gridPaneGame.getMaxHeight(), widthWaffle, heightWaffle).getImgView(), w, h);
					}
					else {
						gridPaneGame.add(new ImageGame("ressources/blanck.png", gridPaneGame.getMaxWidth(), gridPaneGame.getMaxHeight(), widthWaffle, heightWaffle).getImgView(), w, h);
					}
				}
			}
		}
		
		if (player.getNumber() == 1) {
			textNumPlayer = new Text("1");
		}
		else if (player.getNumber() == 2) {
			textNumPlayer = new Text("2");
		}
		else {
			textNumPlayer = new Text("0");
		}
		
		textNumPlayer.setStyle("-fx-font-size: 50pt;");
		gridPanePlayer.add(textNumPlayer, 102, 0);
		
	}
	
	
	
	@Override
	@SuppressWarnings("Convert2Lambda")
	public void start(Stage primaryStage) {
		
		// -- Panes Initialisation --
		BorderPane borderPane = new BorderPane();
		BorderPane borderPaneInfo = new BorderPane();
		gridPaneGame = new GridPane();
		gridPanePlayer = new GridPane();
		GridPane gridPaneButtons = new GridPane();
		
		borderPane.setTop(gridPaneGame);
		borderPane.setBottom(borderPaneInfo);
		borderPaneInfo.setLeft(gridPanePlayer);
		borderPaneInfo.setRight(gridPaneButtons);
		
		
		// -- Grille Jeu --
		gridPaneGame.setMinWidth(winWidth);
		gridPaneGame.setMinHeight((winHeight/4)*3);
		gridPaneGame.setMaxWidth(winWidth);
		gridPaneGame.setMaxHeight((winHeight/4)*3);
		gridPaneGame.setAlignment(Pos.CENTER);
		// -- Tests --
		//updateGame(arrayTest);
		
		
		
		// -- Info Joueurs --
		Rectangle rectInfo = new Rectangle(0, 0, ((winWidth-(STROKE_WIDTH*2))/2), ((winHeight/4)-STROKE_WIDTH));
		rectInfo.setFill(Color.LIGHTGREY);
		rectInfo.setStroke(Color.BLACK);
		rectInfo.setStrokeWidth(STROKE_WIDTH);
		Text textPlayer = new Text("Joueur");
		textPlayer.setStyle("-fx-font-size: 50pt;");
		
		// -- Info Bouttons --
		Rectangle rectButton = new Rectangle(((winWidth-6)/2), 0, ((winWidth/2)-STROKE_WIDTH), ((winHeight/4)-STROKE_WIDTH));
		rectButton.setFill(Color.LIGHTGREY);
		rectButton.setStroke(Color.BLACK);
		rectButton.setStrokeWidth(STROKE_WIDTH);
		
		Button buttonUndo = new Button("Undo");
		Button buttonSave = new Button("Save");
		Button buttonMenu = new Button("Menu");
		
		buttonUndo.setMaxHeight(Double.MAX_VALUE);
		buttonSave.setMaxHeight(Double.MAX_VALUE);
		buttonMenu.setMaxHeight(Double.MAX_VALUE);
		
		buttonUndo.setStyle("-fx-font-size: 20pt;");
		buttonSave.setStyle("-fx-font-size: 20pt;");
		buttonMenu.setStyle("-fx-font-size: 20pt;");
		
		buttonUndo.setOnMouseClicked(new EventHandler <MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("Undo...");
			}
		});
		
		buttonSave.setOnMouseClicked(new EventHandler <MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Save current Waffle game...");
				File file = fileChooser.showSaveDialog(primaryStage);
				if (file != null) {
					System.out.println("Save...");
				}
			}
		});
		
		buttonMenu.setOnMouseClicked(new EventHandler <MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				primaryStage.setWidth(primaryStage.getWidth());
				primaryStage.setHeight(primaryStage.getHeight());
				primaryStage.setScene(fetchMenuScene());
				System.out.println("Return to Menu...");
			}
		});
		
		HBox hBoxButtons = new HBox();
		hBoxButtons.setSpacing(30);
		hBoxButtons.setMaxHeight(104);
		hBoxButtons.getChildren().addAll(buttonUndo, buttonSave, buttonMenu);
		
		
		
		// -- GridPanePlayer --
		gridPanePlayer.setHgap(1);
		gridPanePlayer.add(rectInfo, 0, 0); GridPane.setColumnSpan(rectInfo, 200);
		gridPanePlayer.add(textPlayer, 100, 0);
		
		// -- GridPaneButtons --
		gridPaneButtons.setHgap(29);
		gridPaneButtons.add(rectButton, 0, 0); GridPane.setColumnSpan(rectButton, 20);
		gridPaneButtons.add(hBoxButtons, 3, 0);
		
		
		
		// -- Scene --
		gameScene = new Scene(borderPane, winWidth, winHeight);
		
		primaryStage.setResizable(false);
		primaryStage.setScene(gameScene);
		primaryStage.sizeToScene();
		primaryStage.show();
	}
	
	
	// Main is in MenuInterface
	/*public static void main(String[] args) {
		launch(args);
	}*/
	
}
