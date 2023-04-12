package database_projects;

import java.sql.SQLException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BoltsNutsInventoryManagementSystem extends Application
{
	private MenuBar menuBar;
	private Menu fileMenu;
	private MenuItem exitMenuItem;
	
	private Menu createMenu;
	
	private Menu readMenu;
	private MenuItem productMenuItem;
	private MenuItem inventoryMenuItem;
	private MenuItem categoryMenuItem;
	private MenuItem supplierMenuItem;
	private ListView<String> productListView;
	
	private Menu updateMenu;
	private Menu deleteMenu;
	
	private ListView<Object> listView;

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
		
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(menuBar);
		borderPane.setCenter(listView);
		
		Scene scene = new Scene(borderPane, 1000, 500);
		
		primaryStage.setScene(scene);
		primaryStage.show();		
		
	}

	private void buildCreateMenu(Stage primaryStage)
	{
		createMenu = new Menu("Create");
		
	}

	private void buildReadMenu(Stage primaryStage)
	{
		readMenu = new Menu("Read");
		productMenuItem = new MenuItem("View Products");
		inventoryMenuItem = new MenuItem("View Inventory");
		categoryMenuItem = new MenuItem("View Categories");
		supplierMenuItem = new MenuItem("View Suppliers");
		
		readMenu.getItems().add(productMenuItem);
		
		listView = new ListView<>();
		
		productMenuItem.setOnAction(e ->
		{
			try
			{
				listView.getItems().addAll(BoltsNutsInventoryDBManager.getProductList());
			} catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
	}

	private void buildUpdateMenu(Stage primaryStage)
	{
		updateMenu = new Menu("Update");
		
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
