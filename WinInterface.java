import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WinInterface extends Application {

	private MenuInterface menuInterface;
	
	private Scene winScene;
	
	private BorderPane borderPaneTop;
	private BorderPane borderPaneBottom;
	
	private Text winnerText;
	
	public void initWinInterface (double width, double height) {
		
		this.menuInterface = new MenuInterface();
		
		this.borderPaneTop = new BorderPane();
		this.borderPaneBottom = new BorderPane();
		
		winScene = new Scene(borderPaneTop, width, height);
		
	}
	
	@Override
	public void start(Stage primaryStage) {
		
		VBox vbox = new VBox();
		
		Button buttonMenu = new Button("Retour Menu");
		
		winnerText.setStyle("-fx-font-size: 80pt;");
		buttonMenu.setStyle("-fx-font-size: 50pt;");
		
		this.borderPaneTop.setCenter(winnerText);
		this.borderPaneTop.setBottom(borderPaneBottom);
		
		vbox.getChildren().add(buttonMenu);
		
		this.borderPaneBottom.setCenter(buttonMenu);
		
		buttonMenu.setOnMouseClicked(new EventHandler <MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				// TODO - need to re-use the scene from MenuInterface already created at start of application
				menuInterface.start(primaryStage);
				primaryStage.setWidth(primaryStage.getWidth());
				primaryStage.setHeight(primaryStage.getHeight());
				primaryStage.setScene(menuInterface.getMenuScene());
				menuInterface.setOnResumeButton();
				System.out.println("Return to Menu...");
			}
		});
		
	}
	
	public Scene getWinScene () {
		return winScene;
	}

	public void fetchWinner(Joueur winner) {
		if (winner.getNumber() == 1) {
			winnerText = new Text("   Joueur 1\nA GAGNER !");
		}
		else if (winner.getNumber() == 2) {
			winnerText = new Text("   Joueur 2\nA GAGNER !");
		}
		else {
			winnerText = new Text("   Joueur 0\nA GAGNER !");
		}
	}
    
}
