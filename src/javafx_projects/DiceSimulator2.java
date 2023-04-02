package javafx_projects;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DiceSimulator2 extends Application
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
				
		Button roll = new Button("Roll");
		rolledImageView1 = new ImageView();
		rolledImageView2 = new ImageView();
		
		roll.setOnAction(event ->
		{
			Random rand = new Random();
			
			int value1 = rand.nextInt(6);
			
			String image1 = tossedImage(value1);			
			
			try
			{
				rolledImage1 = new Image(new File(image1).toURI().toURL().toExternalForm());
			} catch (MalformedURLException e)
			{
				
				e.printStackTrace();
			}			
			rolledImageView1.setImage(rolledImage1);
			rolledImageView1.setFitHeight(200);
			rolledImageView1.setPreserveRatio(true);
			
			int value2 = rand.nextInt(6);
			
			String image2 = tossedImage(value2);
			
			try
			{
				rolledImage2 = new Image(new File(image2).toURI().toURL().toExternalForm());
			} catch (MalformedURLException e)
			{
				
				e.printStackTrace();
			}			
			rolledImageView2.setImage(rolledImage2);
			rolledImageView2.setFitHeight(200);
			rolledImageView2.setPreserveRatio(true);
			
		});
		
		HBox rolledImages = new HBox(20, rolledImageView1, rolledImageView2);
		rolledImages.setAlignment(Pos.CENTER);
		
		VBox allElements = new VBox(20, roll, rolledImages);
		allElements.setAlignment(Pos.TOP_CENTER);
		allElements.setPadding(new Insets(10));
		
		Scene scene = new Scene(allElements, 600, 300);
		
		primaryStage.setScene(scene);
		
		primaryStage.setTitle("Dice Simulator2");
		
		primaryStage.show();
	}

	private String tossedImage(int value)
	{
		if(value == 0)
		{
			return "dice1.png";
		}
		else if(value == 1)
		{
			return "dice2.png";
		}
		else if(value == 2)
		{
			return "dice3.png";
		}
		else if(value == 3)
		{
			return "dice4.png";
		}
		else if(value == 4)
		{
			return "dice5.png";
		}
		
		return "dice6.png";
	}
}
