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

public class PropertyTax extends Application
{
	private Label propertyValueLabel;
	private TextField propertyValueField;
	private Label assessmentValueLabel;
	private Label result_assessmentValue;
	private Label propertyTaxLabel;
	private Label result_propertyTax;

	public static void main(String[] args)
	{
		launch(args);

	}
	
	@Override
	public void start(Stage primaryStage)
	{
		propertyValueLabel = new Label("Enter property value: ");
		propertyValueField = new TextField();
		
		HBox propertyValueHbox = new HBox(10, propertyValueLabel, propertyValueField);
		
		assessmentValueLabel = new Label("Assessment Value: ");
		result_assessmentValue = new Label();
		
		HBox assessmentValueHbox = new HBox(10, assessmentValueLabel, result_assessmentValue);
		
		propertyTaxLabel = new Label("Propert Tax: ");
		result_propertyTax = new Label();
		
		HBox propertyTaxHbox = new HBox(10, propertyTaxLabel, result_propertyTax);
		
		Button calcButton = new Button("Calculate Assessment Value and Property Tax");
		calcButton.setOnAction(event ->
		{
			double property = Double.parseDouble(propertyValueField.getText());
			
			double assessment = property * 0.6;
			
			result_assessmentValue.setText(String.format("$%,.2f", assessment));
			
			double tax = assessment / 100 * 0.64;
			
			result_propertyTax.setText(String.format("$%,.2f", tax));
		});
		
		VBox allVbox = new VBox(10, propertyValueHbox, calcButton, assessmentValueHbox, propertyTaxHbox );
		allVbox.setPadding(new Insets(10));
		
		Scene scene = new Scene(allVbox);
		
		primaryStage.setScene(scene);
		
		primaryStage.show();	
		
		
		
	}

}
