package javafx_basics;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleBinding extends Application
{

	public static void main(String[] args)
	{
		Application.launch(args);

	}
	
	@Override
	public void start(Stage primaryStage)
	{
		Circle c = new Circle();
		Group root = new Group(c);
		
		Scene scene = new Scene(root, 150, 150);
		
		// The following bindings will position and size the circle according to the size of the scene:
		c.centerXProperty().bind(scene.widthProperty().divide(2));
		c.centerYProperty().bind(scene.heightProperty().divide(2));
		c.radiusProperty().bind(Bindings.min(scene.widthProperty(), scene.heightProperty()).divide(2));
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
//Learn JavaFX 17,  2nd Edition by Sharan and Spath
