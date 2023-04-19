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
		addGuestHeading = new Label("Guest");
		addGuestHeading.getStyleClass().add("heading");
		
		guestIDLabel = new Label("Guest ID:");
		guestIDTextField = new TextField();
		guestIDHBox = new HBox(10, guestIDLabel, guestIDTextField);
		
		guestNameLabel = new Label("Guest Name:");
		guestNameTextField = new TextField();
		guestNameHbox = new HBox(10, guestNameLabel, guestNameTextField);
		
		guestPhoneLabel = new Label("Guest Phone:");
		guestPhoneTextField = new TextField();
		guestPhoneHbox = new HBox(10, guestPhoneLabel, guestPhoneTextField);
		
		guestEmailLabel = new Label("Guest Email:");
		guestEmailTextField = new TextField();;
		guestEmailHbox = new HBox(10, guestEmailLabel, guestEmailTextField);
		
		guestAddResult = new Label();
		
		guestAddVBox = new VBox(10, addGuestHeading, guestIDHBox, guestNameHbox, guestPhoneHbox, guestEmailHbox, guestAddResult);
		guestAddVBox.setPadding(new Insets(10));
		
		// Room Box
		addRoomHeading = new Label("Room");
		addRoomHeading.getStyleClass().add("heading");
		
		roomIDLabel = new Label("Room ID:");
		roomIDTextField = new TextField();
		roomIDHbox = new HBox(10, roomIDLabel, roomIDTextField);
		
		roomNumLabel = new Label("Room Number:");
		roomNumTextField = new TextField();
		roomNumHbox = new HBox(10, roomNumLabel, roomNumTextField);
		
		roomTypeLabel = new Label("Room Type:");
		roomTypeTextField = new TextField();
		roomTypeHbox = new HBox(10, roomTypeLabel, roomTypeTextField);
		
		roomPriceLabel = new Label("Room Price:");
		roomPriceTextField = new TextField();
		roomPriceHbox = new HBox(10, roomPriceLabel, roomPriceTextField);
		
		roomAddResult = new Label();
		
		roomAddVBox = new VBox(10, addRoomHeading, roomIDHbox, roomNumHbox, roomTypeHbox, roomPriceHbox, roomAddResult);
		roomAddVBox.setPadding(new Insets(10));
		
		addGuestRoomHBox = new HBox(10, guestAddVBox, roomAddVBox);
		
		// Booking box
		addBookingHeading = new Label("Booking");
		addBookingHeading.getStyleClass().add("heading");
		
		bookingIDLabel = new Label("Booking ID:");
		bookingIDTextField = new TextField();
		bookingIDHbox = new HBox(10, bookingIDLabel, bookingIDTextField);
		
		bookingCheckInLabel = new Label("Check-in");
		bookingCheckIn = new DatePicker();
		bookingCheckInHbox = new HBox(10, bookingCheckInLabel, bookingCheckIn);
		
		bookingCheckOutLabel = new Label("Check-out");
		bookingCheckOut = new DatePicker();
		bookingCheckOutHbox = new HBox(10, bookingCheckOutLabel, bookingCheckOut);
		
		roomBookingVBox = new VBox(10, addBookingHeading, bookingIDHbox, bookingCheckInHbox, bookingCheckOutHbox);
		roomBookingVBox.setPadding(new Insets(10));
		
		bookingAddResult = new Label();
		
		addReservationButton = new Button("Add Reservation");
		
		addReservationButton.setOnAction(event -> 
		{
			try
			{
				guestAddResult.setText(HotelReservationDB_MANAGER.addGuest(Integer.parseInt(guestIDTextField.getText()), 
						guestNameTextField.getText(), guestPhoneTextField.getText(), guestEmailTextField.getText()));
				
				roomAddResult.setText(HotelReservationDB_MANAGER.addRoom(Integer.parseInt(roomIDTextField.getText()), 
						Integer.parseInt(roomNumTextField.getText()), roomTypeTextField.getText(), 
						Double.parseDouble(roomPriceTextField.getText())));
				
				LocalDate checkInDate = bookingCheckIn.getValue();
				LocalDate checkOutDate = bookingCheckOut.getValue();
				
				bookingAddResult.setText(HotelReservationDB_MANAGER.addBooking(Integer.parseInt(bookingIDTextField.getText()),
						Integer.parseInt(roomIDTextField.getText()), Integer.parseInt(guestIDTextField.getText()), 
						Date.valueOf(checkInDate), Date.valueOf(checkOutDate)));
			} 
			catch (NumberFormatException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		addGuestRoomBookingVBox = new VBox(10, addGuestRoomHBox, roomBookingVBox, addReservationButton, bookingAddResult);
		addGuestRoomBookingVBox.setPadding(new Insets(25));		
		
		addAll.setOnAction(event -> 
		{
			borderPane.setCenter(addGuestRoomBookingVBox);
		});
		
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



























