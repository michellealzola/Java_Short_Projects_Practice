package javafx_basics;

import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.MapProperty;
import javafx.beans.property.SimpleMapProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

public class MapBindingTest
{

	public static void main(String[] args)
	{
		MapProperty<String, Double> mp1 = new SimpleMapProperty<>(FXCollections.observableHashMap());
		
		ObjectBinding<Double> kenSalary = mp1.valueAt("Ken");
		System.out.println("Ken Salary: " + kenSalary.get());
		
		StringProperty initStr = new SimpleStringProperty("Size: " );
		StringProperty desc = new SimpleStringProperty();
		desc.bind(initStr.concat(mp1.sizeProperty())
		                 .concat(", Empty: ")
		                 .concat(mp1.emptyProperty())
		                 .concat(", Map: " )
		                 .concat(mp1.asString())
		                 .concat(", Ken Salary: ")
		                 .concat(kenSalary));
		
		System.out.println("Before mp1.put(): " + desc.get());
		
		mp1.put("Ken", 7890.90);
		mp1.put("Jim", 9800.80);
		mp1.put("Lee", 6000.20);	    
		System.out.println("After mp1.put(): " + desc.get());
		
		MapProperty<String, Double> mp2 = new SimpleMapProperty<>(FXCollections.observableHashMap());
		
		mp1.bindContent(mp2);
		System.out.println("Called mp1.bindContent(mp2)...");
		
		System.out.println("Before mp2.put(): " + desc.get());
		mp2.put("Ken", 7500.90);
		mp2.put("Cindy", 7800.20);
		System.out.println("After mp2.put(): " + desc.get());
		

	}

}
//Learn JavaFX 17,  2nd Edition by Sharan and Spath