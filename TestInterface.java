package preprojets6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TestInterface extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		Button btn_tst = new Button();
		Button btn = new Button();
		btn.setText("Say 'Hello World'");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World!");
			}
		});	
		btn_tst.setText("Essai bouton");
		btn_tst.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Test effectué");
			}
		});
		
		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(0, 0, 0, 0));
		gridPane.add(btn, 0, 0);
		gridPane.add(btn_tst, 2, 1);
		
		Scene scene = new Scene(gridPane, 300, 250);
		
		primaryStage.setTitle("Hello World!");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void test(String[] args) {
		launch(args);
	}
	
}
