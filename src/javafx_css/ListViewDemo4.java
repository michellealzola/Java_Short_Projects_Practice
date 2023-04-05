package javafx_css;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViewDemo4 extends Application
{

	public static void main(String[] args)
	{
		Application.launch(args);

	}

	@Override
	public void start(Stage primaryStage)
	{
		final double WIDTH = 500, HEIGHT = 250;
		
		ListView<String> listView1 = new ListView<>();
		listView1.setPrefSize(WIDTH, HEIGHT);
		listView1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		listView1.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
		
		ListView<String> listView2 = new ListView<>();
		listView2.setPrefSize(WIDTH, HEIGHT);
		
		Button getButton = new Button("Get Selections");
		
		getButton.setOnAction(event -> 
		{
			ObservableList<String> selections = listView1.getSelectionModel().getSelectedItems();
			
			listView2.getItems().setAll(selections);
			
		});
		
		VBox vbox = new VBox(10, listView1, listView2, getButton);
		vbox.setAlignment(Pos.CENTER);
		vbox.setPadding(new Insets(10));
		
		Scene scene = new Scene(vbox);
		scene.getStylesheets().add("list_view_demo4.css");
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}























