package javafx_basics;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class InitializeListProperty
{

	public static void main(String[] args)
	{
		ObservableList<String> list1 = FXCollections.observableArrayList();
		
		ListProperty<String> lp1 = new SimpleListProperty<String>(list1);
		lp1.add("Hello");
		System.out.println("lp1: " + lp1);
		
		ListProperty<String> lp2 = new SimpleListProperty<String>();
		lp2.set(FXCollections.observableArrayList());
		lp2.add("Hello");
		System.out.println("lp2: " + lp2);
	}

}
//Learn JavaFX 17,  2nd Edition by Sharan and Spath