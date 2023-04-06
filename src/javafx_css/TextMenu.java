package javafx_css;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TextMenu extends Application
{
	private MenuBar menuBar;
	private Menu fileMenu;
	private Menu textMenu;
	private MenuItem exitItem;
	
	private RadioMenuItem blackItem;
	private RadioMenuItem redItem;
	private RadioMenuItem greenItem;
	private RadioMenuItem blueItem;
	
	private CheckMenuItem visibleItem;	
	
	private Label outputLabel;
	

	public static void main(String[] args)
	{
		Application.launch(args);

	}
	
	@Override
	public void start(Stage primaryStage)
	{
		final double WIDTH = 300.0, HEIGHT = 200.0;
		
		outputLabel = new Label("Hello World!");
		
		menuBar = new MenuBar();
		
		buildFileMenu(primaryStage);
		
		buildTextMenu();
		
		menuBar.getMenus().add(fileMenu);
		menuBar.getMenus().add(textMenu);
		
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(menuBar);
		borderPane.setCenter(outputLabel);
		
		Scene scene = new Scene(borderPane, WIDTH, HEIGHT);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	private void buildTextMenu()
	{
		textMenu = new Menu("Text");
		
		blackItem = new RadioMenuItem("Black");
		redItem = new RadioMenuItem("Red");
		greenItem = new RadioMenuItem("Green");
		blueItem = new RadioMenuItem("Blue");
		
		visibleItem = new CheckMenuItem("Visible");
		
		blackItem.setSelected(true);
		visibleItem.setSelected(true);
		
		ToggleGroup textToggeleGroup = new ToggleGroup();
		blackItem.setToggleGroup(textToggeleGroup);
		redItem.setToggleGroup(textToggeleGroup);
		greenItem.setToggleGroup(textToggeleGroup);
		blueItem.setToggleGroup(textToggeleGroup);
		
		blackItem.setOnAction(event -> 
		{
			outputLabel.setStyle("-fx-text-fill: black");
		});
		
		redItem.setOnAction(event -> 
		{
			outputLabel.setStyle("-fx-text-fill: red");
		});
		
		greenItem.setOnAction(event -> 
		{
			outputLabel.setStyle("-fx-text-fill: green");
		});
		
		blueItem.setOnAction(event -> 
		{
			outputLabel.setStyle("-fx-text-fill: blue");
		});
		
		visibleItem.setOnAction(event -> 
		{
			if(outputLabel.isVisible())
			{
				outputLabel.setVisible(false);
			}
			else
			{
				outputLabel.setVisible(true);
			}
		});
		
		textMenu.getItems().addAll(blackItem, redItem, greenItem, blueItem);
		textMenu.getItems().add(new SeparatorMenuItem());
		textMenu.getItems().add(visibleItem);
		
	}

	private void buildFileMenu(Stage primaryStage)
	{
		fileMenu = new Menu("_File"); // mnemonic: ALT + F
		
		exitItem = new MenuItem("E_xit"); // mnemonic: ALT + X
		
		exitItem.setOnAction(event -> 
		{
			primaryStage.close();
		});
		
		fileMenu.getItems().add(exitItem);
	}

}






















