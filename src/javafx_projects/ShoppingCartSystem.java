package javafx_projects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShoppingCartSystem extends Application
{
	private static final String BOOK_FILE = "BookPrices.txt";
	private static final double TAX_RATE = 0.07;
	
	private ListView<String> bookListView;
	private ListView<String> cartListView;
	
	private DoubleProperty totalPrice = new SimpleDoubleProperty();
	private Label totalPriceLabel;
	
	
	public static void main(String[] args)
	{
		Application.launch(args);

	}
	
	@Override
	public void start(Stage primaryStage) throws IOException
	{
		bookListView = new ListView<>();
		BufferedReader reader = new BufferedReader(new FileReader(BOOK_FILE));
		String entry;
		while((entry = reader.readLine()) != null)
		{
			String[] bookEntry = entry.split(", ");
			String bookTitle = bookEntry[0];			
			double bookPrice = Double.parseDouble(bookEntry[1]);			
			
			bookListView.getItems().add(bookTitle + " - $" + bookPrice);
		}
		reader.close();
		
		cartListView = new ListView<>();
		totalPriceLabel = new Label();
		
		// Add to Cart		
		Button addButton = new Button("Add to Cart");
		addButton.setOnAction(event ->
		{
			String selectedBook = bookListView.getSelectionModel().getSelectedItem();
			
			if(selectedBook != null)
			{
				String[] bookItem = selectedBook.split(" - \\$");
				String bookTitle = bookItem[0];			
				double bookPrice = Double.parseDouble(bookItem[1]);
				int quantity = 1;
				
				String cartItem = bookTitle + " (x" + quantity + ") - $" + (bookPrice * quantity);
				
				cartListView.getItems().add(cartItem);
				
				totalPrice.set(totalPrice.get() + bookPrice * quantity);
				
				totalPriceLabel.textProperty().bind(Bindings.format("Total Price: $%.2f", totalPrice));
				
			}
		});
		
		
		// Remove from Cart
		Button removeButton = new Button("Remove from Cart");
		removeButton.setOnAction(event -> 
		{
			int selectedBookIndex = cartListView.getSelectionModel().getSelectedIndex();
			
			if(selectedBookIndex != -1)
			{
				String selectedBook = cartListView.getSelectionModel().getSelectedItem();
				String[] bookItem = selectedBook.split(" - \\$");
				String bookTitle = bookItem[0];			
				double bookPrice = Double.parseDouble(bookItem[1].substring(1));
				
				String cartItem = cartListView.getItems().get(selectedBookIndex);
				int quantity = Integer.parseInt(cartItem.substring(cartItem.indexOf("(x") + 2, cartItem.indexOf(")")));
				
				if (quantity == 1) 
				{
	                cartListView.getItems().remove(selectedBookIndex);
	            } 
				else 
				{
	                cartListView.getItems().set(selectedBookIndex, bookTitle + " (x" + (quantity - 1) + ") - $" + (bookPrice * (quantity - 1)));
	            }

	            totalPrice.set(totalPrice.get() - bookPrice);
	            
	            totalPriceLabel.textProperty().bind(Bindings.format("Total Price: $%.2f", totalPrice));
		
			}
		});
		
		// Clear Cart
		Button clearButton = new Button("Clear Cart");
		clearButton.setOnAction(event -> 
		{
			cartListView.getItems().clear();
	        totalPrice.set(0);
		});
		
		// Checkout
		Button checkoutButton = new Button("Checkout");
		
		checkoutButton.setOnAction(event ->
		{
			double subtotal = totalPrice.get();
	        double salesTax = subtotal * TAX_RATE;
	        double total = subtotal + salesTax;

	        cartListView.getItems().add(String.format("Subtotal: $%,.2f", subtotal));
	        cartListView.getItems().add(String.format("Sales Tax: $%,.2f", salesTax));
	        cartListView.getItems().add(String.format("Total: $%,.2f", total));
	        
	        totalPriceLabel.textProperty().bind(Bindings.format("Total Price: $%.2f", total));
		});
				
		
		
		HBox buttonHBox = new HBox(10, addButton, removeButton, clearButton, checkoutButton);
		
		VBox cartVBox = new VBox(10, cartListView, totalPriceLabel);
		
		VBox root = new VBox(15, bookListView, buttonHBox, cartVBox);
		root.setPadding(new Insets(25));
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add("shopping.css");
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Books Shopping Cart System");
		primaryStage.show();
		
	}

}