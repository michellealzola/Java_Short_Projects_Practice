package database_projects;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HotelReservation_USER2 extends Application
{
	private MenuBar menuBar;
	
	// [File Menu]
	private Menu fileMenu;
	private MenuItem exitMenuItem;
	
	// [Add Reservation Menu]
	private Menu addReservationMenu;
	private MenuItem addAll;
	
		// [Add Reservation Menu] - Guest Interface -
	
		private Label addGuestHeading;
	
		private Label guestIDLabel;
		private TextField guestIDTextField;
		private HBox guestIDHBox;
		
		private Label guestNameLabel;
		private TextField guestNameTextField;
		private HBox guestNameHbox;
		
		private Label guestPhoneLabel;
		private TextField guestPhoneTextField;
		private HBox guestPhoneHbox;
		
		private Label guestEmailLabel;
		private TextField guestEmailTextField;
		private HBox guestEmailHbox;
		
		private Label guestAddResult;
		
		private VBox guestAddVBox;
	
		// [Add Reservation Menu] - Room Interface -
		
		private Label addRoomHeading;
	
		private Label roomIDLabel;
		private TextField roomIDTextField;
		private HBox roomIDHbox;
		
		private Label roomNumLabel;
		private TextField roomNumTextField;
		private HBox roomNumHbox;
		
		private Label roomTypeLabel;
		private TextField roomTypeTextField;
		private HBox roomTypeHbox;
		
		private Label roomPriceLabel;
		private TextField roomPriceTextField;
		private HBox roomPriceHbox;
		
		private Label roomAddResult;
		
		private VBox roomAddVBox;
		
	private HBox addGuestRoomHBox;	
	
		// [Add Reservation Menu] - Booking Interface -
	
		private Label addBookingHeading;
	
		private Label bookingIDLabel;
		private TextField bookingIDTextField;
		private HBox bookingIDHbox;
		
		private Label bookingRoomIDLabel;
		private TextField bookingRoomIDTextField;
		private HBox bookingRoomIDHbox;
		
		private Label bookingGuestIDLabel;
		private TextField bookingGuestIDTextField;
		private HBox bookingGuestIDHbox;
		
		private Label bookingCheckInLabel;
		private DatePicker bookingCheckIn;
		private HBox bookingCheckInHbox;
		
		private Label bookingCheckOutLabel;
		private DatePicker bookingCheckOut;
		private HBox bookingCheckOutHbox;
		
		private Label bookingAddResult;
		
		private VBox roomBookingVBox;
	
	private VBox addGuestRoomBookingVBox;
	
	private Button addReservationButton;
	
	// [View Menu]
	private Menu viewMenu;
	
	// [Search Menu]
	private Menu searchMenu;
	
	// [Update Menu]
	private Menu updateMenu;
	
	// [Calendar Menu]
	private Menu calendarMenu;
	
	
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
		buildAddReservationMenu(primaryStage);
		buildViewMenu(primaryStage);
		buildSearchMenu(primaryStage);
		buildUpdateMenu(primaryStage);
		buildCalendarMenu(primaryStage);
		
		menuBar.getMenus().add(fileMenu);
		menuBar.getMenus().add(addReservationMenu);
		menuBar.getMenus().add(viewMenu);
		menuBar.getMenus().add(searchMenu);
		menuBar.getMenus().add(updateMenu);
		menuBar.getMenus().add(calendarMenu);
		
		borderPane = new BorderPane();
		borderPane.setTop(menuBar);		
		
		Scene scene = new Scene(borderPane, 1200, 800);
		scene.getStylesheets().add("hotel.css");
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

	private void buildFileMenu(Stage primaryStage)
	{
		fileMenu = new Menu("File");
		exitMenuItem  = new MenuItem("Exit");
		
		exitMenuItem.setOnAction(event -> 
		{
			primaryStage.close();
		});
		
		fileMenu.getItems().add(exitMenuItem);
		
	}

	private void buildAddReservationMenu(Stage primaryStage)
	{
		addReservationMenu = new Menu("Reservation");
		addAll = new MenuItem("Add");
		
		addReservationMenu.getItems().add(addAll);
		
		// Guest Box
		
		
		// Date Picker
		
		
		// Room Box with ListView
		
		
		// Booking box
		
		
	}

	private void buildViewMenu(Stage primaryStage)
	{
		viewMenu = new Menu("View");
		
		
		
	}

	private void buildSearchMenu(Stage primaryStage)
	{
		searchMenu = new Menu("Search");
		
	}

	private void buildUpdateMenu(Stage primaryStage)
	{
		updateMenu = new Menu("Update");
		
	}

	private void buildCalendarMenu(Stage primaryStage)
	{
		calendarMenu = new Menu("Calendar");
		
	}

}



























