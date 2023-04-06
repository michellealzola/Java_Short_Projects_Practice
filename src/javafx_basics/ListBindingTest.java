package javafx_basics;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

public class ListBindingTest
{

	public static void main(String[] args)
	{
		ListProperty<String> lp = new SimpleListProperty<>(FXCollections.observableArrayList());
		
		StringProperty initStr = new SimpleStringProperty("Size: ");
		
		StringProperty desc = new SimpleStringProperty();
		desc.bind(initStr.concat(lp.sizeProperty())
						.concat(", Empty: ")
						.concat(lp.emptyProperty())
						.concat(", List: ")
						.concat(lp.asString()));
		
		System.out.println("Before addAll: " + desc.get());
		lp.addAll("John", "Jacobs");
		System.out.println("After addAll: " + desc.get());
		

	}

}
//Learn JavaFX 17,  2nd Edition by Sharan and Spath