package javafx_projects;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SlotMachineSimulator extends Application
{
	private Image slotImage1;
	private Image slotImage2;
	private Image slotImage3;
	
	private ImageView imageView1;
	private ImageView imageView2;
	private ImageView imageView3;
	
	private Label amountInsertedLabel;
	private TextField amountInput;
	
	private Label amountWonLabel;
	private Label resultAmountWon;
	
	private Label totalAmountWonLabel;
	private Label resultTotalAmountWon;
	
	public static int totalWon = 0;
	
	private ImageView getImageView_(Image imageA, ImageView imageViewA)
	{
		imageViewA.setImage(imageA);
		imageViewA.setFitHeight(200);
		imageViewA.setPreserveRatio(true);
		
		return imageViewA;
		
	}

	private Image getImage(String image)
	{
		Image image_ = null;
		try
		{
			image_ = new Image(new File(image).toURI().toURL().toExternalForm());
			
		} catch (MalformedURLException e)
		{
			
			e.printStackTrace();
		}
		return image_;
	}

	private String spinImage(int value)
	{
		if(value == 0)
		{
			return "slot1.png";
		}
		else if(value == 1)
		{
			return "slot2.png";
		}
		return "slot3.png";	
		
	}
	

	public static void main(String[] args)
	{
		launch(args);

	}
	
	@Override
	public void start(Stage primaryStage)
	{
		Button spin = new Button("Spin");
		imageView1 = new ImageView();
		imageView2 = new ImageView();
		imageView3 = new ImageView();
		
		// Amount Inserted
		amountInsertedLabel = new Label("Amount Inserted: $");
		amountInput = new TextField();			
		
		
		// Amount won this spin
		amountWonLabel = new Label("Amount Won this Spin:");
		resultAmountWon = new Label();	
		
		// Total amount won
		totalAmountWonLabel = new Label("Total Amount Won:");
		resultTotalAmountWon = new Label();
		
		
		spin.setOnAction(event->
		{
			Random rand = new Random();
			
			// Image view 1
			int value1 = rand.nextInt(3);			
			String image1 = spinImage(value1);
			slotImage1 = getImage(image1);
			imageView1 = getImageView_(slotImage1, imageView1);
			
			
			// Image view 2
			int value2 = rand.nextInt(3);			
			String image2 = spinImage(value2);
			slotImage2 = getImage(image2);
			imageView2 = getImageView_(slotImage2, imageView2);
			
			
			// Image view 3
			int value3 = rand.nextInt(3);			
			String image3 = spinImage(value3);
			slotImage3 = getImage(image3);
			imageView3 = getImageView_(slotImage3, imageView3);
			
			double won = 0;
			
			
			
			double amountInputValue = Double.parseDouble(amountInput.getText());
			
			if (value1 == value2 && value1 == value3 && value2 == value3)
			{
				won = amountInputValue * 3;
			}
			else if(value1 == value2 || value1 == value3 || value2 == value3)
			{
				won = amountInputValue * 2;
			}
			else
			{
				won = 0;
			}
			resultAmountWon.setText(String.format("$%,.2f", won));
			double totalwon = accumulateTotal(won);
			
			
			resultTotalAmountWon.setText(String.format("$%,.2f", totalwon));
			
		});
		
		HBox amountInsertedHbox = new HBox(10, amountInsertedLabel, amountInput);	
		amountInsertedHbox.setAlignment(Pos.TOP_LEFT);
		
		HBox imageViewsHbox = new HBox(10, imageView1, imageView2, imageView3);
		imageViewsHbox.setAlignment(Pos.CENTER);
		
		HBox amountWonHbox = new HBox(5, amountWonLabel, resultAmountWon);
		amountWonHbox.setAlignment(Pos.TOP_RIGHT);
		
		HBox totalAmountWonHbox = new HBox(5, totalAmountWonLabel, resultTotalAmountWon);
		totalAmountWonHbox.setAlignment(Pos.TOP_RIGHT);
		
		VBox wonAmountVbox = new VBox(10, amountWonHbox, totalAmountWonHbox);
		wonAmountVbox.setAlignment(Pos.CENTER_RIGHT);
		
		HBox moneyHbox = new HBox(25, amountInsertedHbox, wonAmountVbox);
		moneyHbox.setAlignment(Pos.CENTER);
		
		VBox allElements = new VBox(10, imageViewsHbox, moneyHbox, spin);
		allElements.setAlignment(Pos.TOP_CENTER);
		allElements.setPadding(new Insets(10));
		
		Scene scene = new Scene(allElements, 700, 400);
		
		primaryStage.setScene(scene);
		
		primaryStage.show();
		
	}

	private static double accumulateTotal(double won)
	{
		return totalWon += won;
		
	}	

}
