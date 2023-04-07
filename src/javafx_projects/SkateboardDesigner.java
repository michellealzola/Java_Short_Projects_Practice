package javafx_projects;

import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SkateboardDesigner extends Application
{
	// Skateboard Products
	private static final Map<String, Double> DECKS = new HashMap<>();
	private static final Map<String, Double> TRUCK_ASSEMBLIES = new HashMap<>();
	private static final Map<String, Double> WHEELS = new HashMap<>();
	private static final Map<String, Double> MISC_ITEMS = new HashMap<>();
	
	static
	{
		DECKS.put("The Master Thrasher - $60", 60.0);
        DECKS.put("The Dictator - $45", 45.0);
        DECKS.put("The Street King - $50", 50.0);

        TRUCK_ASSEMBLIES.put("7.75-inch axle - $35", 35.0);
        TRUCK_ASSEMBLIES.put("8-inch axle - $40", 40.0);
        TRUCK_ASSEMBLIES.put("8.5-inch axle - $45", 45.0);

        WHEELS.put("51 mm - $20", 20.0);
        WHEELS.put("55 mm - $22", 22.0);
        WHEELS.put("58 mm - $24", 24.0);
        WHEELS.put("61 mm - $28", 28.0);
        
        MISC_ITEMS.put("Grip tape - $20", 10.0);
        MISC_ITEMS.put("Bearings - $30", 30.0);
        MISC_ITEMS.put("Riser pads - $2", 2.0);
        MISC_ITEMS.put("Nuts & bolts kit - $3", 3.0);
	}
	

	public static void main(String[] args)
	{
		Application.launch(args);

	}
	
	@Override
	public void start(Stage primaryStage)
	{
		Label deck = new Label("Deck");
		ComboBox<String> deckComboBox = new ComboBox<>(FXCollections.observableArrayList(DECKS.keySet()));
		HBox deckHBox = new HBox(10, deck, deckComboBox);
		
		Label truck = new Label("Truck Assemblies");
		ComboBox<String> truckComboBox = new ComboBox<>(FXCollections.observableArrayList(TRUCK_ASSEMBLIES.keySet()));
		HBox truckHBox = new HBox(10, truck, truckComboBox);
		
		Label wheels = new Label("Wheels");
		ComboBox<String> wheelsComboBox = new ComboBox<>(FXCollections.observableArrayList(WHEELS.keySet()));
		HBox wheelsHBox = new HBox(10, wheels, wheelsComboBox);
		
		Label misc = new Label("Miscellaneous");
		ListView<String> miscListView = new ListView<>(FXCollections.observableArrayList(MISC_ITEMS.keySet()));
		miscListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		VBox miscVBox = new VBox(10, misc, miscListView);
		
		Label subTotalLabel = new Label();
		Label taxLabel = new Label();
		Label totalLabel = new Label();
		
		// Bind sub-total, tax and total labels to DoubleBinding
		DoubleBinding subtotal = Bindings.createDoubleBinding(() -> 
		{
			double deckPrice = DECKS.getOrDefault(deckComboBox.getValue(), 0.0);
			double truckPrice = TRUCK_ASSEMBLIES.getOrDefault(truckComboBox.getValue(), 0.0);
			double wheelsPrice = WHEELS.getOrDefault(wheelsComboBox.getValue(), 0.0);
			return deckPrice + truckPrice + wheelsPrice + miscListView.getSelectionModel().getSelectedItems().stream()
					.mapToDouble(MISC_ITEMS::get)
					.sum();
		}, deckComboBox.valueProperty(), truckComboBox.valueProperty(), wheelsComboBox.valueProperty(), miscListView.getSelectionModel().getSelectedItems());
		
		DoubleBinding tax = Bindings.multiply(0.07, subtotal);
		DoubleBinding total = (DoubleBinding) Bindings.add(subtotal, tax);
		
		subTotalLabel.textProperty().bind(Bindings.format("Subtotal: $%.2f", subtotal));
		
		taxLabel.textProperty().bind(Bindings.format("Tax (7%%): $%.2f", tax));
		totalLabel.textProperty().bind(Bindings.format("Total: $%.2f", total));
		
		VBox root = new VBox(10, deckHBox, truckHBox, wheelsHBox, miscVBox, subTotalLabel, taxLabel, totalLabel);
		root.setAlignment(Pos.TOP_LEFT);
		root.setPadding(new Insets(25));
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add("skateboard.css");
		
		primaryStage.setTitle("Skateboard Designer");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

}
