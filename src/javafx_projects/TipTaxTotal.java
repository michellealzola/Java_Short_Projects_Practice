package javafx_projects;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TipTaxTotal extends Application
{
	TextField foodChargeField;
	Label foodChargeLabel;
	Label tip;
	Label resultTip;
	Label tax;
	Label resultTax;
	Label total;
	Label resultTotal;

	public static void main(String[] args)
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage)
	{
		foodChargeLabel = new Label("Enter food charge: ");
		foodChargeField = new TextField();
		
		HBox foodChargeHbox = new HBox(10, foodChargeLabel, foodChargeField);
		
		tip = new Label("Tip (18%): ");
		resultTip = new Label();
		
		HBox tipHbox = new HBox(10, tip, resultTip);
		
		tax = new Label("Tax (7%): ");
		resultTax = new Label();
		
		HBox taxHbox = new HBox(10, tax, resultTax);
		
		total = new Label("Total: ");
		resultTotal = new Label();
		
		HBox totalHbox = new HBox(10, total, resultTotal);
		
		Button calcButton = new Button("Calculate Charges");
		
		calcButton.setOnAction(event ->
		{
			double charge = Double.parseDouble(foodChargeField.getText());
			
			double tipAmount = charge * 0.18;
			
			resultTip.setText(String.format("$%.2f", tipAmount));
			
			double taxAmount = charge * 0.07;
			
			resultTax.setText(String.format("$%.2f", taxAmount));
			
			double totalAmount = charge + tipAmount + taxAmount;
			
			resultTotal.setText(String.format("$%.2f", totalAmount));
		});
		
		VBox allVbox = new VBox(10, foodChargeHbox, calcButton, tipHbox, taxHbox, totalHbox );
		allVbox.setPadding(new Insets(30));
		
		Scene scene = new Scene(allVbox);
		
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}

}
