package javafx_stages;

import javafx.collections.ObservableList;
import javafx.stage.Screen;

public class PrimaryScreen
{
	// this code is not runnable

	public static void main(String[] args)
	{
		// You can get the reference of the Screen object for the 
		// primary monitor using the static getPrimary() method of the 
		// Screen class with the following code:
		
		Screen primaryScreen = Screen.getPrimary();
		
		// The static getScreens() method
		// returns an ObservableList of Screen objects:
		
		ObservableList<Screen> screenList = Screen.getScreens();
		
		// You can get the resolution of a screen in DPI using the getDpi() method
		// of the Screen class as follows:
		
		double dpi = primaryScreen.getDpi();

	}

}
//Learn JavaFX 17,  2nd Edition by K. Sharan and P. Spath