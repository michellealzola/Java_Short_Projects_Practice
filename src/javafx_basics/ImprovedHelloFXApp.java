package javafx_basics;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ImprovedHelloFXApp extends Application
{

	public static void main(String[] args)
	{
		Application.launch(args);

	}
	
	@Override
	public void start(Stage stage)
	{
		Label nameLbl = new Label("Enter you name: ");
		
		TextField nameFld = new TextField();
		
		Label msg = new Label();
		msg.setStyle("-fx-text-fill: blue;");
		
		Button sayHelloBtn = new Button("Say Hello");
		
		Button exitBtn = new Button("Exit");
		
		sayHelloBtn.setOnAction(event -> 
		{
			String name = nameFld.getText();
			
			if(name.trim().length() > 0)
			{
				msg.setText("Hello" + name);
			}
			else
			{
				msg.setText("Hello there");
			}
		});
		
		exitBtn.setOnAction(e -> Platform.exit());
		
		VBox root = new VBox(5, nameLbl, nameFld, msg, sayHelloBtn, exitBtn);
		
		Scene scene = new Scene(root, 350, 150);
		
		stage.setScene(scene);
		stage.setTitle("Improved Hello JavaFX Application");
		
		stage.show();
		
	}

}























