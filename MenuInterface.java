import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MenuInterface extends Application{

    @Override
    public void start(Stage primaryStage) {
    	Button newGame = createButton("Nouvelle partie", "0");
    	Button loadGame = createButton("Continuer la partie", "1");
        loadGame.setDisable(true); // permet de désactiver un boutton (utile pour le boutton "Continuer" lorsqu'aucue partie n'est savegardée)
        
        GridPane root = new GridPane();
        root.getChildren().add(newGame);
        root.getChildren().add(loadGame);

 		Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Waffle 1.0");
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
    	}
        }
    };

 	public static void main(String[] args) {
        launch(args);
    }
}