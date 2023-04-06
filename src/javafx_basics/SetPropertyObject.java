package javafx_basics;

import javafx.beans.property.SetProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;

public class SetPropertyObject
{

	public static void main(String[] args)
	{
		SetProperty<String> sp = new SimpleSetProperty<String>(FXCollections.observableSet());
		
		sp.add("one");
		sp.add("two");
		
		System.out.println(sp);
		
		// Get the wrapped set from the sp property
		ObservableSet<String> set = sp.get();
		
		System.out.println(set);
		

	}

}
//Learn JavaFX 17,  2nd Edition by Sharan and Spath
