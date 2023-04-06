package javafx_css;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PizzaComboBox extends Application
{

	public static void main(String[] args)
	{
		Application.launch(args);

	}

	@Override
	public void start(Stage primaryStage)
	{
		ComboBox<String> comboBox = new ComboBox<>();
		comboBox.setEditable(true);
		comboBox.getItems().addAll("Pineapple", "Bacon", "Pepperoni", "Cheese");
		
		Label outputLabel = new Label("Select a Pizza Topping");
		
		comboBox.setOnAction(event -> 
		{
			outputLabel.setText(comboBox.getValue());
		});
		
		VBox vbox = new VBox(10, comboBox, outputLabel);
		vbox.setPadding(new Insets(10));
		vbox.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(vbox);
		scene.getStylesheets().add("pizza_toppings.css");
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
