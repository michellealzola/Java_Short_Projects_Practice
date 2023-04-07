package javafx_projects;

import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConferenceRegistrationSystem extends Application
{
	private static final Map<String, Double> REGISTRATION = new HashMap<>();
	private BooleanProperty keynoteSelected; 
	private static final Map<String, Double> PRECONFERENCE = new HashMap<>();
	
	static
	{
		REGISTRATION.put("General - $895", 895.0);
		REGISTRATION.put("Student - $495", 495.0);
		
		PRECONFERENCE.put("Introduction to E-commerce - $295", 295.0);
		PRECONFERENCE.put("The Future of the Web - $295", 295.0);
		PRECONFERENCE.put("Advanced Java Programming - $395", 395.0);
		PRECONFERENCE.put("Network Security - $395", 395.0);
		
	}

	public static void main(String[] args)
	{
		Application.launch(args);

	}
	
	@Override
	public void start(Stage primaryStage)
	{
		// Registration Fees ComboBox
		Label registrationLabel = new Label("Registration Fees:");
		ComboBox<String> registrationComboBox = new ComboBox<>(FXCollections.observableArrayList(REGISTRATION.keySet()));
		HBox registrationHBox = new HBox(10, registrationLabel, registrationComboBox);
		
		// Optional opening night dinner with a keynote speech
		keynoteSelected = new SimpleBooleanProperty(false);
		CheckBox keynoteCheckBox = new CheckBox("Include opening night dinner with a keynote speech (Optional)");
		keynoteCheckBox.selectedProperty().bindBidirectional(keynoteSelected);
		
		// Optional preconference workshops
		Label preconferenceLabel = new Label("Optional preconference workshops (May select multiple):");
		ListView<String> preconferenceListView = new ListView<>(FXCollections.observableArrayList(PRECONFERENCE.keySet()));
		preconferenceListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		VBox preconferenceVBox = new VBox(10, preconferenceLabel, preconferenceListView);
		
		// Total cost
		Label totalCostLabel = new Label();
		
		DoubleBinding totalCost = Bindings.createDoubleBinding(() ->
		{
			double registrationFee = REGISTRATION.getOrDefault(registrationComboBox.getValue(), 0.0);
			double keynoteFee = keynoteSelected.get() ? 30.0 : 0.0;
			double preconferenceFee = preconferenceListView.getSelectionModel().getSelectedItems().stream().mapToDouble(PRECONFERENCE::get).sum();
			return registrationFee + keynoteFee + preconferenceFee;
		}, 	registrationComboBox.valueProperty(), 
			keynoteSelected, 
			preconferenceListView.getSelectionModel().getSelectedItems()
		);
		
		totalCostLabel.textProperty().bind(Bindings.format("Total: $%,.2f", totalCost));
		
		Label heading = new Label("Conference Registration System");
		heading.setStyle("-fx-font-weight: bolder;");
		
		VBox root = new VBox(15, heading, registrationHBox, keynoteCheckBox, preconferenceVBox, totalCostLabel);
		root.setPadding(new Insets(30));
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add("conference_registration.css");
		
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Conference Registration System");
		
		primaryStage.show();
		
	}

}













