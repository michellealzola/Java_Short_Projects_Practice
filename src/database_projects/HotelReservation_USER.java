package database_projects;

import javafx.application.Application;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HotelReservation_USER extends Application
{
	private MenuBar menuBar;
	
	// [File Menu]
	private Menu fileMenu;
	private MenuItem exitMenuItem;
	
	// [Add Reservation Menu]
	
		// [Add Reservation Menu] - Guest Interface -
	
		private Label guestIDLabel;
		private TextField guestIDTextField;
		private HBox guestIDHbox;
		
		private Label guestNameLabel;
		private TextField guestNameTextField;
		private HBox guestNameHbox;
		
		private Label guestPhoneLabel;
		private TextField guestPhoneTextField;
		private HBox guestPhoneHbox;
		
		private Label guestEmailLabel;
		private TextField guestEmailTextField;
		private HBox guestEmailHbox;
		
		private VBox guestAddVBox;
	
		// [Add Reservation Menu] - Room Interface -
	
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
		
		private VBox roomAddVBox;
	
		// [Add Reservation Menu] - Booking Interface -
	
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
	
	
	
	// View Menu
	// Search Menu
	// Update Menu
	// Calendar Menu

	public static void main(String[] args)
	{
		Application.launch(args);

	}
	
	@Override
	public void start(Stage primaryStage)
	{
		
	}

}
