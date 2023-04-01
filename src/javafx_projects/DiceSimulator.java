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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DiceSimulator extends Application
{
	private Image rolledImage1;
	private ImageView rolledImageView1;
	
	private Image rolledImage2;
	private ImageView rolledImageView2;
	

	public static void main(String[] args)
	{
		launch(args);

	}

	@Override
	public void start(Stage primaryStage)
	{
				
		Button roll = new Button("Roll the Dice");
		rolledImageView1 = new ImageView();	
		rolledImageView2 = new ImageView();		
		
		
		roll.setOnAction(new rollHandler());			
		
		HBox rolledImages = new HBox(20, rolledImageView1, rolledImageView2);
		rolledImages.setAlignment(Pos.CENTER);
		
		VBox allElements = new VBox(20, roll, rolledImages);
		allElements.setAlignment(Pos.TOP_CENTER);
		allElements.setPadding(new Insets(10));
		
		Scene scene = new Scene(allElements, 600, 300);
		
		primaryStage.setScene(scene);
		
		primaryStage.setTitle("Dice Simulator");
		
		primaryStage.show();
	}
	
	class rollHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			Random rand = new Random();
			
			int value1 = rand.nextInt(6);
			
			if(value1 == 0)
			{
				rolledImage1 = new Image("file:dice1.png");	
			}
			else if(value1 == 1)
			{
				rolledImage1 = new Image("file:dice2.png");	
			}
			else if(value1 == 2)
			{
				rolledImage1 = new Image("file:dice3.png");	
			}
			else if(value1 == 3)
			{
				rolledImage1 = new Image("file:dice4.png");	
			}
			else if(value1 == 4)
			{
				rolledImage1 = new Image("file:dice5.png");	
			}
			else if(value1 == 5)
			{
				rolledImage1 = new Image("file:dice6.png");	
			}
			else
			{
				rolledImage1 = new Image("file:dice7.png");
			}				
			
			rolledImageView1.setImage(rolledImage1);
			rolledImageView1.setFitHeight(200);
			rolledImageView1.setPreserveRatio(true);
			
			int value2 = rand.nextInt(6);
			
			if(value2 == 0)
			{
				rolledImage2 = new Image("file:dice1.png");	
			}
			else if(value2 == 1)
			{
				rolledImage2 = new Image("file:dice2.png");	
			}
			else if(value2 == 2)
			{
				rolledImage2 = new Image("file:dice3.png");	
			}
			else if(value2 == 3)
			{
				rolledImage2 = new Image("file:dice4.png");	
			}
			else if(value2 == 4)
			{
				rolledImage2 = new Image("file:dice5.png");	
			}
			else if(value2 == 5)
			{
				rolledImage2 = new Image("file:dice6.png");	
			}
			else
			{
				rolledImage2 = new Image("file:dice7.png");
			}
			
			rolledImageView2.setImage(rolledImage2);
			rolledImageView2.setFitHeight(200);
			rolledImageView2.setPreserveRatio(true);
			
		}
	}


}
