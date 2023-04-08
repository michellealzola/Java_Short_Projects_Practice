package javafx_stages;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BlankStage extends Application
{

	public static void main(String[] args)
	{
		Application.launch(args);

	}
	
	@Override
	public void start(Stage primaryStage)
	{
		primaryStage.setTitle("A Sized Stage with a Sized Scene");
		
		Group root = new Group(new Button("Hello"));
		
		Scene scene = new Scene(root, 300, 100);
		
		primaryStage.setScene(scene);
		primaryStage.setWidth(400);
		primaryStage.setHeight(100);
		primaryStage.show();
	}

}
//Learn JavaFX 17,  2nd Edition by K. Sharan and P. Spath