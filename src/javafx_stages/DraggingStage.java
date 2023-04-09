package javafx_stages;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DraggingStage extends Application
{
	private Stage primaryStage;
	private double dragOffsetX;
	private double dragOffsetY;

	public static void main(String[] args)
	{
		Application.launch(args);

	}
	
	@Override
	public void start(Stage primaryStage)
	{
		this.primaryStage = primaryStage;
		
		Label msgLabel = new Label("Press Mouse Button and Drag");
		
		Button closeButton = new Button("Close");
		closeButton.setOnAction(event -> primaryStage.close());
		
		VBox root = new VBox();
		root.getChildren().addAll(msgLabel, closeButton);
		
		Scene scene = new Scene(root, 300, 200);
		scene.setOnMousePressed(event -> handleMousePressed(event));
		scene.setOnMouseDragged(event -> handleMouseDragged(event));
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Moving a Stage");
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.show();
	}

	protected void handleMousePressed(MouseEvent event)
	{
		this.dragOffsetX = event.getSceneX() - primaryStage.getX();
		this.dragOffsetY = event.getSceneY() - primaryStage.getY();
	}
	
	protected void handleMouseDragged(MouseEvent event)
	{
		primaryStage.setX(event.getScreenX() - this.dragOffsetX);
		primaryStage.setY(event.getScreenY() - this.dragOffsetX);
	}

}
//Learn JavaFX 17,  2nd Edition by K. Sharan and P. Spath




























