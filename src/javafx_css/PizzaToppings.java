package javafx_css;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PizzaToppings extends Application
{
	CheckBox pepperoniCheckBox;
	CheckBox cheeseCheckBox;
	CheckBox anchoviesCheckBox;
	Label totalLabel;
	

	public static void main(String[] args)
	{
		launch(args);

	}
	
	@Override
	public void start(Stage primaryStage)
	{
		pepperoniCheckBox = new CheckBox("Pepperoni $3.00");
		cheeseCheckBox = new CheckBox("Cheese $2.00");
		anchoviesCheckBox = new CheckBox("Anchovies $1.00");
		
		Button totalButton = new Button("Get Total");
		
		totalButton.setOnAction(new TotalButtonHandler());
		
		totalLabel = new Label("$0.00");
		
		VBox checkBoxVBox = new VBox(10, pepperoniCheckBox, cheeseCheckBox, anchoviesCheckBox);		
		
		VBox mainVBox = new VBox(10, checkBoxVBox, totalButton, totalLabel);
		mainVBox.setAlignment(Pos.CENTER);
		mainVBox.setPadding(new Insets(10));
		
		Scene scene = new Scene(mainVBox, 250, 250);
		scene.getStylesheets().add("pizza_toppings.css");
		
		primaryStage.setScene(scene);
		
		primaryStage.show();		
		
	}
	
	class TotalButtonHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			double result = 0;
			
			if(pepperoniCheckBox.isSelected())
			{
				result += 3.0;
			}
			
			if(cheeseCheckBox.isSelected())
			{
				result += 2.0;
			}
			
			if(anchoviesCheckBox.isSelected())
			{
				result += 1.0;
			}
			
			totalLabel.setText(String.format("$%,.2f", result));
		}
	}

}























