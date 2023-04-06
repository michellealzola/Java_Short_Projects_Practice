package javafx_basics;

import javafx.beans.property.SetProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

public class SetBindingTest
{

	public static void main(String[] args)
	{
		SetProperty<String> sp1 = new SimpleSetProperty<String>(FXCollections.observableSet());
		
		StringProperty initStr = new SimpleStringProperty("Size: ");
		
		StringProperty desc = new SimpleStringProperty();
		desc.bind(initStr.concat(sp1.sizeProperty())
							.concat(", Empty: ")
							.concat(sp1.emptyProperty())
							.concat(", Set: ")
							.concat(sp1.asString()));
		
		System.out.println("Before sp1.add(): " + desc.get());
		sp1.add("John");
		sp1.add("Jacobs");
		System.out.println("After sp1.add(): " + desc.get());
		
		SetProperty<String> sp2 = new SimpleSetProperty<String>(FXCollections.observableSet());
		
		sp1.bindContent(sp2);
		
		print("Before sp2.add():", sp1, sp2);
		sp2.add("1");
		print("After sp2.add():", sp1, sp2);
		
		sp1.unbindContent(sp2);
		print("After sp1.unbindContent(sp2):", sp1, sp2);
		
		sp1.bindContentBidirectional(sp2);
		
		print("Before sp2.add():", sp1, sp2);
		sp2.add("2");
		print("After sp2.add():", sp1, sp2);
		

	}
	
	public static void print(String msg, SetProperty<String> sp1, SetProperty<String> sp2)
	{
		System.out.println(msg + " sp1: " + sp1.get() + " sp2: " + sp2.get());
	}

}
//Learn JavaFX 17,  2nd Edition by Sharan and Spath















