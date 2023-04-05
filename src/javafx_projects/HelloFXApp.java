package javafx_projects;

import javafx.application.Application;
import javafx.stage.Stage;

public class HelloFXApp extends Application
{

	public static void main(String[] args)
	{
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage)
	{
		stage.setTitle("Hello JavaFX Application2");
		stage.show();
	}
}