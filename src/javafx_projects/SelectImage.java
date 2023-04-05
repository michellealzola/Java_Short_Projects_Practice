package javafx_projects;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SelectImage extends Application
{

	public static void main(String[] args)
	{
		Application.launch(args);

	}

	@Override
	public void start(Stage primaryStage)
	{
		final double WIDTH = 500.0, HEIGHT = 250;
		
		Image catImage = new Image("file:cat.png");
		Image hotChocoImage = new Image("file:hot_choco.png");
		Image snowmanImage = new Image("file:snowman.png");
		
		ImageView catImageView = new ImageView(catImage);
		catImageView.setFitHeight(200);
		catImageView.setPreserveRatio(true);
		ImageView hotChocoView = new ImageView(hotChocoImage);
		hotChocoView.setFitHeight(200);
		hotChocoView.setPreserveRatio(true);
		ImageView snowmanView = new ImageView(snowmanImage);
		snowmanView.setFitHeight(200);
		snowmanView.setPreserveRatio(true);
		
		ListView<ImageView> listView = new ListView<>();
		listView.setPrefSize(WIDTH, HEIGHT);
		listView.setOrientation(Orientation.HORIZONTAL);
		listView.getItems().addAll(catImageView, hotChocoView, snowmanView);
		
		String[] photoNames = {"A cat with a scarf", "A cup of hot choco with marshmallows", "A happy snowman"};
		
		Label outputLabel = new Label("Select a Photo");
		
		listView.getSelectionModel().selectedItemProperty().addListener(event ->
		{
			int index = listView.getSelectionModel().getSelectedIndex();
			
			outputLabel.setText(photoNames[index]);
		});
		
		VBox vbox = new VBox(10, listView, outputLabel);
		vbox.setPadding(new Insets(10));
		vbox.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(vbox, 500, 300);
		scene.getStylesheets().add("select_image.css");
		
		primaryStage.setScene(scene);
		primaryStage.show();	
		
	}
}


































