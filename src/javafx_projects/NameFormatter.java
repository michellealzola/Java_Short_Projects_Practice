package javafx_projects;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NameFormatter extends Application
{
	private Label resultLabel;

	public static void main(String[] args)
	{
		launch(args);

	}
	
	@Override
	public void start(Stage primaryStage)
	{
		resultLabel = new Label();
		
		Label fnameLabel = new Label("First Name: ");
		TextField fname = new TextField();		
		HBox fnameHbox = new HBox(10, fnameLabel, fname);
		
		Label mnameLabel = new Label("Middle Name: ");
		TextField mname = new TextField();		
		HBox mnameHbox = new HBox(10, mnameLabel, mname);
		
		Label lnameLabel = new Label("Last Name: ");
		TextField lname = new TextField();		
		HBox lnameHbox = new HBox(10, lnameLabel, lname);
		
		Label titleLabel = new Label("Title: ");
		TextField title = new TextField();		
		HBox titleHbox = new HBox(10, titleLabel, title);
		
		VBox inputVbox = new VBox(5, fnameHbox, mnameHbox, lnameHbox, titleHbox);
		
		inputVbox.setAlignment(Pos.CENTER_LEFT);
		
		Button format1 = new Button("Format 1");
		format1.setOnAction(event ->
		{
			resultLabel.setText(String.format("%s %s %s %s", title.getText(), fname.getText(), mname.getText(), lname.getText()));
		});
		
		Button format2 = new Button("Format 2");
		format2.setOnAction(event ->
		{
			resultLabel.setText(String.format("%s %s %s", fname.getText(), mname.getText(), lname.getText()));
		});
		
		Button format3 = new Button("Format 3");
		format3.setOnAction(event ->
		{
			resultLabel.setText(String.format("%s %s", fname.getText(), lname.getText()));
		});
		
		Button format4 = new Button("Format 4");
		format4.setOnAction(event ->
		{
			resultLabel.setText(String.format("%s, %s %s, %s", lname.getText(), fname.getText(), mname.getText(), title.getText()));
		});
		
		Button format5 = new Button("Format 5");
		format5.setOnAction(event ->
		{
			resultLabel.setText(String.format("%s, %s %s", lname.getText(), fname.getText(), mname.getText()));
		});
		
		Button format6 = new Button("Format 6");
		format6.setOnAction(event ->
		{
			resultLabel.setText(String.format("%s, %s", lname.getText(), fname.getText()));
		});
		
		HBox buttonsHbox = new HBox(5, format1, format2, format3, format4, format5, format6);
		buttonsHbox.setAlignment(Pos.CENTER);
		
		VBox resultsVbox = new VBox(10, buttonsHbox, resultLabel);
		
		VBox allVbox = new VBox(10, inputVbox, resultsVbox);
		allVbox.setPadding(new Insets(30));
		
		Scene scene = new Scene(allVbox);
		
		primaryStage.setScene(scene);
		
		primaryStage.show();
		
		
	}

}
