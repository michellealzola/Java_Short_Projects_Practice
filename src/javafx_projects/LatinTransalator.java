package javafx_projects;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LatinTransalator extends Application
{
	private Label resultLabel;

	public static void main(String[] args)
	{
		launch(args);

	}
	
	@Override
	public void start(Stage primaryStage)
	{
		resultLabel = new Label();
		
		Button sinister = new Button("Sinister");
		Button dexter = new Button("Dexter");
		Button medium = new Button("Medium");
		
		sinister.setOnAction(event -> 
		{
			resultLabel.setText("left");
		});
		
		dexter.setOnAction(event -> 
		{
			resultLabel.setText("right");
		});
		
		medium.setOnAction(event -> 
		{
			resultLabel.setText("center");
		});
		
		HBox hbox = new HBox(15, sinister, dexter, medium);
		
		hbox.setAlignment(Pos.CENTER);
		
		VBox vbox = new VBox(15, hbox, resultLabel);
		
		vbox.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(vbox, 400, 200);
		
		primaryStage.setScene(scene);
		
		primaryStage.show();		
		
		
	}

}
