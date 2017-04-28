
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameInterface extends Application {
	
	private final int strokeWidth = 3;
	
	private final int winWidth = 1080;
	private final int winHeight = 720;
	
	// -- Tests --
	private final double arrayWPow = 3;
	private final double arrayHPow = 2;
	private final int arrayW = (int)Math.pow(2, arrayWPow);
	private final int arrayH = (int)Math.pow(3, arrayHPow);
	private final Integer [][]arrayTest = {
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0}};
	
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
		gridPaneGame.setMinWidth(winWidth);
		gridPaneGame.setMinHeight((winHeight/4)*3);
		gridPaneGame.setMaxWidth(winWidth);
		gridPaneGame.setMaxHeight((winHeight/4)*3);
		gridPaneGame.setAlignment(Pos.CENTER);
		for (int w=0; w<arrayW; w++) {
			for (int h=0; h<arrayH; h++) {
				if (arrayTest[h][w] == 0) {
					// Haut Gauche
					if (w == 0  &&  h == 0) {
						gridPaneGame.add(new ImageGame("ressources/waffle_top_left.png", gridPaneGame.getMaxWidth(), gridPaneGame.getMaxHeight(), arrayW, arrayH).getImgView(), w, h);
					}
					// Gauche
					else if (w == 0  &&  h != arrayH-1) {
						gridPaneGame.add(new ImageGame("ressources/waffle_left.png", gridPaneGame.getMaxWidth(), gridPaneGame.getMaxHeight(), arrayW, arrayH).getImgView(), w, h);
					}
					// Bas Gauche
					else if (w == 0  &&  h == arrayH-1) {
						gridPaneGame.add(new ImageGame("ressources/waffle_bottom_left.png", gridPaneGame.getMaxWidth(), gridPaneGame.getMaxHeight(), arrayW, arrayH).getImgView(), w, h);
					}
					// Haut
					else if (w != arrayW-1  &&  h == 0) {
						gridPaneGame.add(new ImageGame("ressources/waffle_top.png", gridPaneGame.getMaxWidth(), gridPaneGame.getMaxHeight(), arrayW, arrayH).getImgView(), w, h);
					}
					// Bas
					else if (w != arrayW-1  &&  h == arrayH-1) {
						gridPaneGame.add(new ImageGame("ressources/waffle_bottom.png", gridPaneGame.getMaxWidth(), gridPaneGame.getMaxHeight(), arrayW, arrayH).getImgView(), w, h);
					}
					// Haut Droite
					else if (w == arrayW-1  &&  h == 0) {
						gridPaneGame.add(new ImageGame("ressources/waffle_top_right.png", gridPaneGame.getMaxWidth(), gridPaneGame.getMaxHeight(), arrayW, arrayH).getImgView(), w, h);
					}
					// Droite
					else if (w == arrayW-1  &&  h != arrayH-1) {
						gridPaneGame.add(new ImageGame("ressources/waffle_right.png", gridPaneGame.getMaxWidth(), gridPaneGame.getMaxHeight(), arrayW, arrayH).getImgView(), w, h);
					}
					// Bas Droite
					else if (w == arrayW-1  &&  h == arrayH-1) {
						gridPaneGame.add(new ImageGame("ressources/waffle_bottom_right.png", gridPaneGame.getMaxWidth(), gridPaneGame.getMaxHeight(), arrayW, arrayH).getImgView(), w, h);
					}
					// Centre
					else {
						gridPaneGame.add(new ImageGame("ressources/waffle_center.png", gridPaneGame.getMaxWidth(), gridPaneGame.getMaxHeight(), arrayW, arrayH).getImgView(), w, h);
					}
				}
				else {
					gridPaneGame.add(new ImageGame("ressources/blanck.png", gridPaneGame.getMaxWidth(), gridPaneGame.getMaxHeight(), arrayW, arrayH).getImgView(), w, h);
				}
			}
		}
		
		// -- Info Joueurs --
		Rectangle rectInfo = new Rectangle(0, 0, ((winWidth-(strokeWidth*2))/2), ((winHeight/4)-strokeWidth)/*208*/);
		rectInfo.setFill(Color.LIGHTGREY);
		rectInfo.setStroke(Color.BLACK);
		rectInfo.setStrokeWidth(strokeWidth);
		Text textPlayer = new Text("Joueur");
		textPlayer.setStyle("-fx-font-size: 50pt;");
		
		// -- Info Bouttons --
		Rectangle rectButton = new Rectangle(((winWidth-6)/2), 0, ((winWidth/2)-strokeWidth), ((winHeight/4)-strokeWidth)/*208*/);
		rectButton.setFill(Color.LIGHTGREY);
		rectButton.setStroke(Color.BLACK);
		rectButton.setStrokeWidth(strokeWidth);
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
		
		
		
		
		// -- GridPanePlayer --
		gridPanePlayer.setHgap(1);
		gridPanePlayer.add(rectInfo, 0, 0); GridPane.setColumnSpan(rectInfo, 200);
		gridPanePlayer.add(textPlayer, 100, 0);
		
		// -- GridPaneButtons --
		gridPaneButtons.setHgap(29);
		gridPaneButtons.add(rectButton, 0, 0); GridPane.setColumnSpan(rectButton, 20);
		gridPaneButtons.add(hBoxButtons, 3, 0);
		
		
		
		
		// -- Scene --
		Scene scene = new Scene(borderPane, winWidth/*300*/, winHeight/*250*/);
		
		primaryStage.setTitle("Waffle 1.0");
		primaryStage.setWidth(winWidth);
		primaryStage.setHeight(winHeight);
		primaryStage.setResizable(false);
		primaryStage.getIcons().add(new Image("ressources/waffle.png"));
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
