package javafx_stages;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static javafx.stage.StageStyle.DECORATED;
import static javafx.stage.StageStyle.UNDECORATED;
import static javafx.stage.StageStyle.TRANSPARENT;
import static javafx.stage.StageStyle.UNIFIED;
import static javafx.stage.StageStyle.UTILITY;

public class StageStyleApp extends Application
{

	public static void main(String[] args)
	{
		Application.launch(args);

	}
	
	@Override
	public void start(Stage primaryStage)
	{
		Label styleLabel = new Label("Stage Style");
		
		Button closeButton = new Button("Close");
		closeButton.setOnAction(event -> primaryStage.close());
		
		VBox root = new VBox();
		root.getChildren().addAll(styleLabel, closeButton);
		
		Scene scene = new Scene(root, 100, 70);
		
		primaryStage.setScene(scene);
		
		primaryStage.setTitle("The Style of a Stage");
		
//		this.show(primaryStage, styleLabel, DECORATED);
//		this.show(primaryStage, styleLabel, UNDECORATED);
//		this.show(primaryStage, styleLabel, TRANSPARENT);
//		this.show(primaryStage, styleLabel, UNIFIED);
		this.show(primaryStage, styleLabel, UTILITY);
		
		
	}	
		
	private void show(Stage primaryStage, Label styleLabel, StageStyle style)
	{
		styleLabel.setText(style.toString());
		
		primaryStage.initStyle(style);
		
		if(style == TRANSPARENT)
		{
			primaryStage.getScene().setFill(null);
			primaryStage.getScene().getRoot().setStyle("-fx-background-color: transparent");
		}
		else if(style == UNIFIED)
		{
			primaryStage.getScene().setFill(Color.TRANSPARENT);
		}
		
		primaryStage.show();
	}
		
		
		

}
//Learn JavaFX 17,  2nd Edition by K. Sharan and P. Spath











