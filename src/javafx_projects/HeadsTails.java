package javafx_projects;

import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HeadsTails extends Application
{
	private Image landedImage;
	private ImageView landedView;

	public static void main(String[] args)
	{
		launch(args);

	}
	
	@Override
	public void start(Stage primaryStage)
	{
		Button toss = new Button("Toss");
		
		toss.setOnAction(new TossHandler());
		landedView = new ImageView();
		
		VBox tossVbox = new VBox(25, toss, landedView);
		tossVbox.setPadding(new Insets(10));
		tossVbox.setAlignment(Pos.TOP_CENTER);;
		
		Scene scene = new Scene(tossVbox, 600, 350);
		
		primaryStage.setScene(scene);
		
		primaryStage.show();
		
	}
	
	class TossHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			Random rand = new Random();
			
			int value = rand.nextInt(2);
			
			if(value == 0) // Heads
			{
				landedImage = new Image("file:Heads.png");
				
			}
			else // Tails
			{
				landedImage = new Image("file:Tails.png");
				
			}			
			
			landedView.setImage(landedImage);
			
		}
	}

}
