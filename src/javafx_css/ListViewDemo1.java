package javafx_css;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViewDemo1 extends Application
{

	public static void main(String[] args)
	{
		launch(args);

	}
	
	@Override
	public void start(Stage primaryStage)
	{
		ListView<String> listView = new ListView<>();
		
		listView.setPrefSize(120, 100);
		listView.getItems().addAll("Apple", "Banana", "Orange", "Pomelo");
		
		Label selectedFruitLabel = new Label("Select a Fruit");
		
		Button getButton = new Button("Get the Selection");
		
		getButton.setOnAction(event -> 
		{
			String selected = listView.getSelectionModel().getSelectedItem();
			
			selectedFruitLabel.setText(selected);
		});
		
		VBox vbox = new VBox(10, listView, selectedFruitLabel, getButton);
		vbox.setPadding(new Insets(10));
		vbox.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(vbox);
		scene.getStylesheets().add("list_view_demo1.css");
		
		primaryStage.setScene(scene);
		
		primaryStage.show();
		
		
	}

}
























