package javafx_stages;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ScreenDetailsApp extends Application
{

	public static void main(String[] args)
	{
		Application.launch(args);

	}
	
	public void start(Stage primaryStage)
	{
		ObservableList<Screen> screenList = Screen.getScreens();
		System.out.println("Screens Count: " + screenList.size());
		System.out.println("---------------------------------");
		
		for(Screen screen: screenList)
		{
			System.out.println("DPI: " + screen.getDpi());
			
			System.out.println("Screen Bounds:");
			Rectangle2D bounds = screen.getBounds();
			System.out.println(bounds);
			
			System.out.println("Screen Visual Bounds: ");
			Rectangle2D visualBounds = screen.getVisualBounds();
			System.out.println(visualBounds);
			
			System.out.println("---------------------------------");
			
		}
		
		Platform.exit();
	}
}
//Learn JavaFX 17,  2nd Edition by K. Sharan and P. Spath

















