package database_projects;

import java.sql.SQLException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BoltsNutsInventoryManagementSystem extends Application
{
	private MenuBar menuBar;
	private Menu fileMenu;
	private MenuItem exitMenuItem;
	
	// Create menu
	private Menu createMenu;
	
	private MenuItem productAdd;
	private Label addProductLabel;
	private Label productIDLabel;
	private Label productNameLabel;
	private Label productDescriptionLabel;
	private Label categoryIDLabel;
	private TextField productIDTextField;
	private TextField productNameTextField;
	private TextField productDescriptionTextField;
	private TextField categoryIDTextField;
	private HBox productIDHBox;
	private HBox productNameHBox;
	private HBox productDescriptionHBox;
	private HBox categoryIDHBox;
	private VBox addProductVBox;
	private Button addProductButton;
	private Label addProductMsg;
	
	private MenuItem inventoryAdd;
	private Label addInventoryLabel;
	private Label inventoryIDLabel;
	private Label inProductIDLabel;
	private Label supplierIDLabel;
	private Label qtyInStockLabel;
	private TextField inventoryIDTextField;
	private TextField inProductIDTextField;
	private TextField supplierIDTextField;
	private TextField qtyInStockTextField;
	private HBox inventoryIDHBox;
	private HBox inProductIDHBox;
	private HBox supplierIDHBox;
	private HBox qtyInStockHBox;
	private VBox addInventoryVBox;
	private Button addInventoryButton;
	private Label addInventoryMsg;
		
	private MenuItem categoryAdd;
	private Label addCategoryLabel;
	private Label catCategoryIDLabel;
	private Label categoryNameLabel;
	private TextField catCategoryIDTextField;
	private TextField categoryNameTextField;
	private HBox catCategoryIDHBox;
	private HBox categoryNameHBox;
	private VBox addCategoryVBox;
	private Button addCategoryButton;
	private Label addCategoryMsg;	
	
	private MenuItem supplierAdd;
	private Label addSupplierLabel;
	private Label supSupplierIDLabel;
	private Label supplierNameLabel;
	private Label supplierAddressLabel;
	private Label supplierCityLabel;
	private Label supplierProvinceLabel;
	private Label supplierPostCodeLabel;
	private Label supplierPhoneLabel;
	private Label supplierFaxLabel;
	private TextField supSupplierIDTextField;
	private TextField supplierNameTextField;
	private TextField supplierAddressTextField;
	private TextField supplierCityTextField;
	private TextField supplierProvinceTextField;
	private TextField supplierPostCodeTextField;
	private TextField supplierPhoneTextField;
	private TextField supplierFaxTextField;
	private HBox supSupplierIDHBox;
	private HBox supplierNameHBox;
	private HBox supplierAddressHBox;
	private HBox supplierCityHBox;
	private HBox supplierProvinceHBox;
	private HBox supplierPostCodeHBox;
	private HBox supplierPhoneHBox;
	private HBox supplierFaxHBox;
	private VBox addSupplierVBox;
	private Button addSupplierButton;
	private Label addSupplierMsg;
		
	// Read menu
	private Menu readMenu;
	private MenuItem productMenuItem;
	private MenuItem inventoryMenuItem;
	private MenuItem categoryMenuItem;
	private MenuItem supplierMenuItem;	
	private ListView<String> itemListView;
	private VBox readVBox;
	
	// Update menu
	private Menu updateMenu;
	private MenuItem changeQtyMenuItem;
	private Label updateQtyLabel;
	private Label upInventoryIDLabel;
	private Label upOrigDataLabel;
	private Label upNewQtyLabel;
	private TextField upInventoryIDTextField;
	private ListView<String> inventoryListView;
	private TextField upNewQtyTextField;
	private HBox upInventoryIDHBox;
	private VBox upOrigDataVBox;
	private HBox upNewQty;
	private Button updateQtyButton;
	private Label upNewQtyMsg;
	private VBox updateVBox;
	private Button displayOrigDataButton;
	
	// Delete menu
	private Menu deleteMenu;
	
	private BorderPane borderPane;
	
	public static void main(String[] args)
	{
		Application.launch(args);

	}
	
	@Override
	public void start(Stage primaryStage)
	{
		menuBar = new MenuBar();
		buildFileMenu(primaryStage);
		buildCreateMenu(primaryStage);
		buildReadMenu(primaryStage);
		buildUpdateMenu(primaryStage);
		buildDeleteMenu(primaryStage);
		
		menuBar.getMenus().add(fileMenu);
		menuBar.getMenus().add(createMenu);
		menuBar.getMenus().add(readMenu);
		menuBar.getMenus().add(updateMenu);
		menuBar.getMenus().add(deleteMenu);
		
		borderPane = new BorderPane();
		borderPane.setTop(menuBar);

		readMenu.setOnAction(e2 -> 
		{
			borderPane.setCenter(readVBox);
		});
		
		
		Scene scene = new Scene(borderPane, 1000, 500);
		scene.getStylesheets().add("nuts_bolts.css");
		
		primaryStage.setScene(scene);
		primaryStage.show();		
		
	}

	private void buildCreateMenu(Stage primaryStage)
	{
		createMenu = new Menu("Create");
	    productAdd = new MenuItem("Add Product");
	    inventoryAdd = new MenuItem("Add Inventory");
	    categoryAdd = new MenuItem("Add Category");
	    supplierAdd = new MenuItem("Add Supplier");

	    createMenu.getItems().add(productAdd);
	    createMenu.getItems().add(inventoryAdd);
	    createMenu.getItems().add(categoryAdd);
	    createMenu.getItems().add(supplierAdd);
	    
	    // Add Product
	    addProductLabel = new Label("Add a Product");
	    addProductLabel.getStyleClass().add("heading");
	    
	    productIDLabel = new Label("Product ID:");
	    productIDTextField = new TextField();
	    productIDHBox = new HBox(10, productIDLabel, productIDTextField);
	    
	    productNameLabel = new Label("Product Name:");
	    productNameTextField = new TextField();
	    productNameHBox = new HBox(10, productNameLabel, productNameTextField);
	    
	    productDescriptionLabel = new Label("Product Description:");
	    productDescriptionTextField = new TextField();
	    productDescriptionHBox = new HBox(10, productDescriptionLabel, productDescriptionTextField);
	    
	    categoryIDLabel = new Label("Category ID:");
	    categoryIDTextField = new TextField();
	    categoryIDHBox = new HBox(10, categoryIDLabel, categoryIDTextField);
	    
	    addProductMsg = new Label();
	    
	    addProductButton = new Button("Add Product");
	    addProductButton.setOnAction(eAddProductButton -> 
	    {
	    	try
			{
				addProductMsg.setText(BoltsNutsInventoryDBManager.addProduct(productIDTextField.getText(), 
						productNameTextField.getText(), productDescriptionTextField.getText(), 
						categoryIDTextField.getText()));
			} 
	    	catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    });
	    		
	    addProductVBox = new VBox(10, addProductLabel, productIDHBox, productNameHBox, productDescriptionHBox, categoryIDHBox, addProductButton, addProductMsg);
	    addProductVBox.setPadding(new Insets(25));
	    
	    productAdd.setOnAction(e -> 
	    {
	        borderPane.setCenter(addProductVBox);
	    });
	    
	    // Add Inventory
	    addInventoryLabel = new Label("Add an Inventory");
	    addInventoryLabel.getStyleClass().add("heading");
	    
	    inventoryIDLabel = new Label("Inventory ID:");
	    inventoryIDTextField = new TextField();
	    inventoryIDHBox = new HBox(10, inventoryIDLabel, inventoryIDTextField);
	    
	    inProductIDLabel = new Label("Product ID: ");
	    inProductIDTextField = new TextField();
	    inProductIDHBox = new HBox(10, inProductIDLabel, inProductIDTextField);
	    
	    supplierIDLabel = new Label("Supplier ID:");
	    supplierIDTextField = new TextField();
	    supplierIDHBox = new HBox(10, supplierIDLabel, supplierIDTextField);
	    
	    qtyInStockLabel = new Label("Quantity in Stock");
	    qtyInStockTextField = new TextField();
	    qtyInStockHBox = new HBox(10, qtyInStockLabel, qtyInStockTextField);
	    
	    addInventoryMsg = new Label();
	    
	    addInventoryButton = new Button("Add Inventory");
	    addInventoryButton.setOnAction(eAddInventoryButton -> 
	    {
	    	try
			{
				addInventoryMsg.setText(BoltsNutsInventoryDBManager.addInventory(inventoryIDTextField.getText(), inProductIDTextField.getText(), supplierIDTextField.getText(), Integer.parseInt(qtyInStockTextField.getText())));
			} 
	    	catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    });
	    
	    addInventoryVBox = new VBox(10, addInventoryLabel, inventoryIDHBox, inProductIDHBox, supplierIDHBox, qtyInStockHBox, addInventoryButton, addInventoryMsg);
		addInventoryVBox.setPadding(new Insets(25));
		
		inventoryAdd.setOnAction(e -> 
		{
	        borderPane.setCenter(addInventoryVBox);
	    });
		
		// Add Category
		addCategoryLabel = new Label("Add a Category");
		addCategoryLabel.getStyleClass().add("heading");
		
		catCategoryIDLabel = new Label("Category ID:");
		catCategoryIDTextField = new TextField();
		catCategoryIDHBox = new HBox(10, catCategoryIDLabel, catCategoryIDTextField);
		
		categoryNameLabel = new Label("Category Name:");
		categoryNameTextField = new TextField();
		categoryNameHBox = new HBox(10, categoryNameLabel, categoryNameTextField);
		
		addCategoryMsg = new Label();
		
		addCategoryButton = new Button("Add Category");
		addCategoryButton.setOnAction(eAddCategoryButton -> 
		{
			try
			{
				addCategoryMsg.setText(BoltsNutsInventoryDBManager.addCategory(catCategoryIDTextField.getText(), categoryNameTextField.getText()));
			} 
			catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		addCategoryVBox = new VBox(10, addCategoryLabel, catCategoryIDHBox, categoryNameHBox, addCategoryButton, addCategoryMsg);
		addCategoryVBox.setPadding(new Insets(25));
		
		categoryAdd.setOnAction(e -> 
		{
	        borderPane.setCenter(addCategoryVBox);
	    });
		
		// Add Supplier
		addSupplierLabel = new Label("Add a Supplier");
		addSupplierLabel.getStyleClass().add("heading");
		
		supSupplierIDLabel = new Label("Supplier ID:");
		supSupplierIDTextField = new TextField();
		supSupplierIDHBox = new HBox(10, supSupplierIDLabel, supSupplierIDTextField);
		
		supplierNameLabel = new Label("Supplier Name:");
		supplierNameTextField = new TextField();
		supplierNameHBox = new HBox(10, supplierNameLabel, supplierNameTextField);
		
		supplierAddressLabel = new Label("Supplier Address:");
		supplierAddressTextField = new TextField();
		supplierAddressHBox = new HBox(10, supplierAddressLabel, supplierAddressTextField);
		
		supplierCityLabel = new Label("Supplier City:");
		supplierCityTextField = new TextField();
		supplierCityHBox = new HBox(10, supplierCityLabel, supplierCityTextField);
		
		supplierProvinceLabel = new Label("Supplier Province");
		supplierProvinceTextField = new TextField();
		supplierProvinceHBox = new HBox(10, supplierProvinceLabel, supplierProvinceTextField);
		
		supplierPostCodeLabel = new Label("Supplier Postal Code:");
		supplierPostCodeTextField = new TextField();
		supplierPostCodeHBox = new HBox(10, supplierPostCodeLabel, supplierPostCodeTextField);		
		
		supplierPhoneLabel  = new Label("Supplier Phone:");
		supplierPhoneTextField = new TextField();
		supplierPhoneHBox = new HBox(10, supplierPhoneLabel, supplierPhoneTextField);		
		
		supplierFaxLabel = new Label("Supplier Fax:");
		supplierFaxTextField = new TextField();
		supplierFaxHBox = new HBox(10, supplierFaxLabel, supplierFaxTextField);
		
		addSupplierMsg = new Label();
		
		addSupplierButton = new Button("Add a Supplier");
		addSupplierButton.setOnAction(eAddSupplierButton -> 
		{
			try
			{
				addSupplierMsg.setText(BoltsNutsInventoryDBManager.addSupplier(supSupplierIDTextField.getText(), 
						supplierNameTextField.getText(), supplierAddressTextField.getText(), supplierCityTextField.getText(), 
						supplierProvinceTextField.getText(), supplierPostCodeTextField.getText(), 
						supplierPhoneTextField.getText(), supplierFaxTextField.getText()));
			} 
			catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		addSupplierVBox = new VBox(10, addSupplierLabel, supSupplierIDHBox, supplierNameHBox, 
				supplierAddressHBox, supplierCityHBox, supplierProvinceHBox, supplierPostCodeHBox, 
				supplierPhoneHBox, supplierFaxHBox, addSupplierButton, addSupplierMsg);
		addSupplierVBox.setPadding(new Insets(25));
		
		supplierAdd.setOnAction(e -> 
		{
			borderPane.setCenter(addSupplierVBox);
		});
		
	}


	private void buildReadMenu(Stage primaryStage)
	{
		readMenu = new Menu("Read");
		productMenuItem = new MenuItem("View Products");
		inventoryMenuItem = new MenuItem("View Inventory");
		categoryMenuItem = new MenuItem("View Categories");
		supplierMenuItem = new MenuItem("View Suppliers");		
		
		readMenu.getItems().add(productMenuItem);
		readMenu.getItems().add(inventoryMenuItem);
		readMenu.getItems().add(categoryMenuItem);
		readMenu.getItems().add(supplierMenuItem);		
		
		itemListView = new ListView<>();
		itemListView.setPrefHeight(1000);
		
		productMenuItem.setOnAction(e ->
		{
			try
			{
				itemListView.getItems().addAll(BoltsNutsInventoryDBManager.getProductList());				
			} 
			catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
		});
		
		inventoryMenuItem.setOnAction(e ->
		{			
			try
			{
				itemListView.getItems().addAll(BoltsNutsInventoryDBManager.getInventoryList());				
			} 
			catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
		});
		
		categoryMenuItem.setOnAction(e ->
		{			
			try
			{
				itemListView.getItems().addAll(BoltsNutsInventoryDBManager.getCategoryList());				
			} 
			catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
		});
		
		supplierMenuItem.setOnAction(e ->
		{			
			try
			{
				itemListView.getItems().addAll(BoltsNutsInventoryDBManager.getSupplierList());				
			} 
			catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
		});		

		readVBox = new VBox(itemListView);
		readVBox.setPadding(new Insets(15));
		
	}

	private void buildUpdateMenu(Stage primaryStage)
	{
		updateMenu = new Menu("Update");
		changeQtyMenuItem = new MenuItem("Change Stock Quantity");
		
		updateMenu.getItems().add(changeQtyMenuItem);
		
		updateQtyLabel = new Label("Change Stock Quantity");
		updateQtyLabel.getStyleClass().add("heading");
		
		upInventoryIDLabel = new Label("Inventory ID:");
		upInventoryIDTextField = new TextField();
		upInventoryIDHBox = new HBox(10, upInventoryIDLabel, upInventoryIDTextField);
		
		upOrigDataLabel = new Label("Original Data:");
		inventoryListView = new ListView<>();
		
		displayOrigDataButton = new Button("Display Original Data");
		displayOrigDataButton.setOnAction(eDisplayOrigDataButton -> 
		{
			try
			{
				inventoryListView.getItems().addAll(BoltsNutsInventoryDBManager.getInventoryList(upInventoryIDTextField.getText()));
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});		
		upOrigDataVBox = new VBox(10, upOrigDataLabel, displayOrigDataButton, inventoryListView);
		
		upNewQtyLabel = new Label("Enter New Quantity:");
		upNewQtyTextField = new TextField();
		upNewQty = new HBox(10, upNewQtyLabel, upNewQtyTextField);
		
		upNewQtyMsg = new Label();
		
		updateQtyButton = new Button("Update Quantity");
		updateQtyButton.setOnAction(eUpdateQtyButton -> 
		{
			try
			{
				upNewQtyMsg.setText(BoltsNutsInventoryDBManager.changeQty(upInventoryIDTextField.getText(), Integer.parseInt(upNewQtyTextField.getText())));
			} 
			catch (NumberFormatException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		updateVBox = new VBox(10, updateQtyLabel, upInventoryIDHBox, upOrigDataVBox, upNewQty, updateQtyButton, upNewQtyMsg);
		updateVBox.setPadding(new Insets(25));
		
		changeQtyMenuItem.setOnAction(e -> 
	    {
	        borderPane.setCenter(updateVBox);
	    });
		
	}

	private void buildDeleteMenu(Stage primaryStage)
	{
		deleteMenu = new Menu("Delete");
		
	}

	private void buildFileMenu(Stage primaryStage)
	{
		fileMenu = new Menu("File");
		exitMenuItem = new MenuItem("Exit");
		
		exitMenuItem.setOnAction(event -> 
		{
			primaryStage.close();
		});
		
		fileMenu.getItems().add(exitMenuItem);
	}

}
