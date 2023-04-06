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

/* In this code, binding is used to establish a relationship between the value of a 
 * property and an expression that depends on that property's value. When the value of the 
 * property changes, the bound expression is automatically updated to reflect the new value.
 */

/* In particular, the code uses binding to create a string that represents the current 
 * state of a list of strings. The list is represented by a ListProperty<String> object 
 * called lp, which is initially empty. The string is represented by a StringProperty object called desc.
 */

/* The expression that represents the current state of the list is constructed using 
 * the concat method of the StringProperty class. The expression concatenates several parts:
 */

/* The initial string "Size: "
The size of the list, represented by the sizeProperty of the ListProperty object lp.
The string ", Empty: ", followed by a boolean value that indicates whether the list is empty. 
The boolean value is represented by the emptyProperty of the ListProperty object lp.
The string ", List: ", followed by a string representation of the list, represented by 
the asString method of the ListProperty object lp.
The bind method of the StringProperty class is used to establish a binding between the desc 
property and the constructed expression. This means that whenever any of the properties involved 
in the expression change, the desc property is automatically updated to reflect the new value of the expression.

In the main method, the initial value of the desc property is printed to the console using 
the get method. Then, two strings are added to the lp list using the addAll method, and the 
updated value of the desc property is printed to the console using the get method again. 
Because the desc property is bound to the expression that depends on the lp list, its value is 
automatically updated to reflect the new state of the list.*/