package javafx_css;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RadioButtonEvent extends Application
{

	public static void main(String[] args)
	{
		launch(args);

	}
	
	@Override
	public void start(Stage primaryStage)
	{
		Image coffeeImage = new Image("file:coffee.png");
		Image pieImage = new Image("file:pie.png");
		
		ImageView imageView = new ImageView(coffeeImage);
		imageView.setFitWidth(200);
		imageView.setPreserveRatio(true);
		
		HBox imageHBox = new HBox(imageView);
		imageHBox.setAlignment(Pos.CENTER);
		
		RadioButton coffeeRadio = new RadioButton("Coffee");
		RadioButton pieRadio = new RadioButton("Pie");
		
		coffeeRadio.setSelected(true);
		
		ToggleGroup radioGroup = new ToggleGroup();
		coffeeRadio.setToggleGroup(radioGroup);
		pieRadio.setToggleGroup(radioGroup);
		
		coffeeRadio.setOnAction(event->
		{
			imageView.setImage(coffeeImage);
		});
		
		pieRadio.setOnAction(event->
		{
			imageView.setImage(pieImage);
		});
		
		VBox radioVBox = new VBox(10, coffeeRadio, pieRadio);
		radioVBox.setPadding(new Insets(30)); 
		
		VBox mainVBox = new VBox(10, imageHBox, radioVBox);
		
		Scene scene = new Scene(mainVBox);
		scene.getStylesheets().add("radio_button_event.css");
		
		primaryStage.setScene(scene);
		
		primaryStage.show();
		
	}

}
