package javafx_projects;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BorderPaneDemo extends Application
{

	public static void main(String[] args)
	{
		launch(args);

	}
	
	@Override
	public void start(Stage primaryStage)
	{
		Button center = new Button("Center");
		Button top = new Button("Top");
		Button right = new Button("Right");
		Button bottom = new Button("Bottom");
		Button left = new Button("Left");
		
		HBox centerHBox = new HBox(center);
		HBox topHBox = new HBox(top);
		VBox rightVBox = new VBox(right);
		HBox bottomHBox = new HBox(bottom);
		VBox leftVBox = new VBox(left);
		
		topHBox.setAlignment(Pos.CENTER);
		bottomHBox.setAlignment(Pos.CENTER);
		
		BorderPane borderPane = new BorderPane();
		
		borderPane.setCenter(centerHBox);
		borderPane.setTop(topHBox);
		borderPane.setRight(rightVBox);
		borderPane.setBottom(bottomHBox);
		borderPane.setLeft(leftVBox);
		
		Scene scene = new Scene(borderPane);
		
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}

}
