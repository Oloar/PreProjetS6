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
    public static Scene menuPrincipal;
    public static Scene menuSecondaire;
    public static Stage stage;

    @Override
    public void start(Stage primaryStage) {
        this.stage = primaryStage;
        this.initMenuPrincipal();
        this.initMenuSecondaire();
        this.initStage();
        this.stage.show();
    }

    // initialisation du menu secondaire
    private void initMenuSecondaire(){

    	//Buttons du menu secondaire
    	Button solo = createButton("Solo", "4");
    	Button versus = createButton("Versus", "5");
        Button retour = createButton("Retour", "6");
        solo.setMaxHeight(Double.MAX_VALUE);
        versus.setMaxHeight(Double.MAX_VALUE);
        retour.setMaxHeight(Double.MAX_VALUE);
        solo.setMinWidth(300);
        versus.setMinWidth(300);
        retour.setMinWidth(300);
        solo.setStyle("-fx-font-size: 20pt;");
        versus.setStyle("-fx-font-size: 20pt;");
        retour.setStyle("-fx-font-size: 20pt;");
      
        //Grid du menu secondaire
        GridPane menu = new GridPane();
        menu.setHgap(5);
        menu.setVgap(5);
        menu.add(solo,75,30);
        menu.add(versus,75,35);
        menu.add(retour,75,40);
        Image imgTitle = new Image("ressources/waffle_title.png");
        ImageView viewTitle = new ImageView(imgTitle);
        menu.add(viewTitle, 55, 10);
        GridPane.setColumnSpan(viewTitle, 200);
        
 		this.menuSecondaire = new Scene(menu, 300, 250);
    }

    // initialisation du menu principal
    private void initMenuPrincipal(){

    	//Buttons du menu principal
    	Button newGame = createButton("  Nouvelle partie  ", "0");
    	Button resumeGame = createButton("Continuer la partie", "1");
    	Button loadGame = createButton("Charger la partie", "2");
        Button exitGame = createButton("  Quitter le jeu   ", "3");
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
      
        //Grid du menu principal
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
        
 		this.menuPrincipal = new Scene(menu, 300, 250);

    }

    // initialise le stage
    private void initStage(){
    	this.stage.setTitle("Waffle 1.0");
        this.stage.setWidth(winWidth);
        this.stage.setHeight(winHeight);
        this.stage.setResizable(false);
        this.stage.getIcons().add(new Image("ressources/waffle.png"));
        this.stage.setScene(this.menuPrincipal);
    }

    // Fonction qui crée un boutton avec comme texte dessus txt, comme identifiant label et qui associe le handler 
    private Button createButton(String txt, String label){
    	Button b = new Button(txt);
    	b.setId(label);
    	b.setOnAction(handler);
    	return b;
    }

    public final Scene fetchGameScene(){
    	return GameInterface.getGameScene();
    }

    // Handler qui traite les events des différents bouttons. Pour l'instant :
    // "0" => boutton de nouvelle partie
    // "1" => boutton pour charger la partie sauvegardée (si elle existe)
    final EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>(){

        @Override
        public void handle(final ActionEvent event) {
			// Scene menuPrincipal = getMenuScene();

            Button b = (Button) event.getSource();
	    	switch(b.getId()){
	    		case "0":		// Boutton Du menu principal : Nouvelle partie
	    			System.out.println("Lancement d'une nouvelle partie");
	    			
	    			break;
	    		case "1":		// Boutton Du menu principal : Chargement de la partie quitée
	    			System.out.println("Chargement de la partie en cours");
	    			break;
		        case "2":		// Boutton Du menu principal : Chargement de la partie sauvegardé
		        	System.out.println("Chargement de la partie sauvegardée");
		        	break;
		        case "3":		// Boutton Du menu principal : Quitter le jeu
		            System.exit(0);
		        	break;		        
		        case "4":		// Boutton du menu secondaire : lancement d'une nouvelle partie solo 
		        	System.out.println("Lancement d'une nouvelle partie en solo");
		        	break;		       
		        case "5":		// Boutton du menu secondaire : lancement d'une nouvelle partie en versus
		        	System.out.println("Lancement d'une nouvelle partie en  versus");
		        	break;
		        case "6":		// Boutton du menu secondaire : retour au menu principal
		        	System.out.println("Retour au menu principal");
		        	break;
	    	}
        }
    };


 	public static void main(String[] args) {
        launch(args);
    }
}