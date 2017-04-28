import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MenuInterface extends Application{
    
    private final int winWidth = 1080;
    private final int winHeight = 720;

    @Override
    public void start(Stage primaryStage) {
        
        //Buttons
    	Button newGame = createButton("  Nouvelle partie  ", "0");
    	Button loadGame = createButton("Continuer la partie", "1");
        Button exitGame = createButton("  Quitter le jeu   ", "2");
        loadGame.setDisable(true); // permet de désactiver un boutton (utile pour le boutton "Continuer" lorsqu'aucue partie n'est savegardée)
        newGame.setMaxHeight(Double.MAX_VALUE);
        loadGame.setMaxHeight(Double.MAX_VALUE);
        exitGame.setMaxHeight(Double.MAX_VALUE);
        newGame.setMinWidth(300);
        loadGame.setMinWidth(300);
        exitGame.setMinWidth(300);
        newGame.setStyle("-fx-font-size: 20pt;");
        loadGame.setStyle("-fx-font-size: 20pt;");
        exitGame.setStyle("-fx-font-size: 20pt;");
      
        
        //Grid
        GridPane menu = new GridPane();
        menu.setHgap(5);
        menu.setVgap(5);
        menu.add(newGame,75,30);
        menu.add(loadGame,75,35);
        menu.add(exitGame,75,40);
        Image imgTitle = new Image("ressources/waffle_title.png");
        ImageView viewTitle = new ImageView(imgTitle);
        menu.add(viewTitle, 55, 10);
        GridPane.setColumnSpan(viewTitle, 200);
        
 	Scene scene = new Scene(menu, 300, 250);

        primaryStage.setTitle("Waffle 1.0");
        primaryStage.setWidth(winWidth);
        primaryStage.setHeight(winHeight);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("ressources/waffle.png"));
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }

    // Fonction qui crée un boutton avec comme texte dessus txt, comme identifiant label et qui associe le handler 
    public Button createButton(String txt, String label){
    	Button b = new Button(txt);
    	b.setId(label);
    	b.setOnAction(handler);
    	return b;
    }

    // Handler qui traite les events des différents bouttons. Pour l'instant :
    // "0" => boutton de nouvelle partie
    // "1" => boutton pour charger la partie sauvegardée (si elle existe)
    final EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>(){

        @Override
        public void handle(final ActionEvent event) {
            Button b = (Button) event.getSource();
    	switch(b.getId()){
    		case "0":
    			System.out.println("Lancement d'une nouvelle partie");
    			break;
    		case "1":
    			System.out.println("Chargement de la partie en cours");
    			break;
                case "2":
                        System.exit(0);
                        break;
    	}
        }
    };

 	public static void main(String[] args) {
        launch(args);
    }
}