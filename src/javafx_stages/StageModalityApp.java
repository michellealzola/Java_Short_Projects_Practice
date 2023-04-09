package javafx_stages;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.Modality;
import static javafx.stage.Modality.NONE;
import static javafx.stage.Modality.WINDOW_MODAL;
import static javafx.stage.Modality.APPLICATION_MODAL;

public class StageModalityApp extends Application
{

	public static void main(String[] args)
	{
		Application.launch(args);

	}
	
	@Override
	public void start(Stage primaryStage)
	{
		Button ownedNoneButton = new Button("Owned None");
		ownedNoneButton.setOnAction(event -> showDialog(primaryStage, NONE));
		
		Button nonOwnedNoneButton = new Button("Non-owned None");               
		nonOwnedNoneButton.setOnAction(event -> showDialog(null, NONE)); 
		
		Button ownedWinButton = new Button("Owned Window Modal");               
		ownedWinButton.setOnAction(event -> showDialog(primaryStage, WINDOW_MODAL));               
		
		Button nonOwnedWinButton = new Button("Non-owned Window Modal");               
		nonOwnedWinButton.setOnAction(event -> showDialog(null, WINDOW_MODAL));               
		
		Button ownedAppButton = new Button("Owned Application Modal");               
		ownedAppButton.setOnAction(event -> showDialog(primaryStage, APPLICATION_MODAL));               
		
		Button nonOwnedAppButton = new Button("Non-owned Application Modal");               
		nonOwnedAppButton.setOnAction(event -> showDialog(null, APPLICATION_MODAL));
		
		VBox root = new VBox();
		root.getChildren().addAll(	ownedNoneButton, 
									nonOwnedNoneButton,                        
									ownedWinButton, 
									nonOwnedWinButton,                        
									ownedAppButton, 
									nonOwnedAppButton);
		
		Scene scene = new Scene(root, 300, 200);
		primaryStage.setScene(scene);               
		primaryStage.setTitle("The Primary Stage");               
		primaryStage.show();
		
		
	}

	private void showDialog(Window owner, Modality modality)
	{
		Stage stage = new Stage();
		stage.initOwner(owner);
		stage.initModality(modality);
		
		Label modalityLabel = new Label(modality.toString());
		
		Button closeButton = new Button("Close");
		closeButton.setOnAction(event -> stage.close());
		
		VBox root = new VBox();
		root.getChildren().addAll(modalityLabel, closeButton);
		
		Scene scene = new Scene(root, 200, 100);
		stage.setScene(scene);
		stage.setTitle("A Dialog Box");
		stage.show();
		
	}

}
//Learn JavaFX 17,  2nd Edition by K. Sharan and P. Spath















