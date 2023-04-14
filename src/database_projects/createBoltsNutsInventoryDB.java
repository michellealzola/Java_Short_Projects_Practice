/**
 * This program creates the Bolts and Nuts Inventory Database
 * Author: Michelle Alzola | www.michellealzoladesign.com
 * Date: 11-April-2023
 * Version: 1.0 
 * 
 */
package database_projects;

import java.sql.*;

public class createBoltsNutsInventoryDB
{

	public static void main(String[] args)
	{
		final String DB_URL = "jdbc:derby:BoltsNutsInventoryDB;create=true";
		
		try
		{
			Connection conn = DriverManager.getConnection(DB_URL);
			
			dropTables(conn);
			
			buildCategoryTable(conn);
			
			buildProductTable(conn);
			
			buildSupplierTable(conn);
			
			buildInventoryTable(conn);			
			
			conn.close();	
			
			
		} 
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.getMessage());
		}

	}

	private static void dropTables(Connection conn)
	{
		System.out.println("Dropping existing tables.");
		
		try
		{
			Statement stmt = conn.createStatement();
			
			try
			{
				stmt.execute("DROP TABLE Product CASCADE CONSTRAINTS");
				System.out.println("Product Table dropped.");
			} 
			catch (SQLException e)
			{
				// No need for error message. The table does not exist.
			}
			
			try
			{
				stmt.execute("DROP TABLE Inventory CASCADE CONSTRAINTS");
				System.out.println("Inventory Table dropped.");
			} 
			catch (SQLException e)
			{
				// No need for error message. The table does not exist.
			}
			
			try
			{
				stmt.execute("DROP TABLE Category");
				System.out.println("Category Table dropped.");
			} 
			catch (SQLException e)
			{
				// No need for error message. The table does not exist.
			}
			
			try
			{
				stmt.execute("DROP TABLE Supplier");
				System.out.println("Supplier Table dropped.");
			} 
			catch (SQLException e)
			{
				// No need for error message. The table does not exist.
			}
			
		} 
		catch (SQLException e)
		{
			System.out.println("ERROR: " + e.getMessage());
			e.printStackTrace();			
		}
		
	}

	private static void buildProductTable(Connection conn)
	{
		try
		{
			Statement stmt = conn.createStatement();
			
			stmt.execute("CREATE TABLE Product "
					+ "(ProductID CHAR(10) NOT NULL PRIMARY KEY, "
					+ "ProductName CHAR(30), "
					+ "ProductDescription CHAR(30), "
					+ "CategoryID CHAR(10) NOT NULL, "
					+ "CONSTRAINT Product_CategoryID_FK FOREIGN KEY (CategoryID) REFERENCES Category(CategoryID) ON DELETE CASCADE)");
			
			stmt.execute("INSERT INTO Product VALUES ('P-001', 'Hex Bolt', '1/4 in. x 2 in. Zinc Plated', 'C-001')");
			stmt.execute("INSERT INTO Product VALUES ('P-002', 'Wing Nut', '5/16 in. Zinc Plated', 'C-002')");
			stmt.execute("INSERT INTO Product VALUES ('P-003', 'Flat Washer', '3/8 in. Zinc Plated', 'C-003')");
			stmt.execute("INSERT INTO Product VALUES ('P-004', 'Lock Nut', '1/2 in. Zinc Plated', 'C-002')");
			stmt.execute("INSERT INTO Product VALUES ('P-005', 'Socket Head Cap', 'M8 x 1.25 x 20mm Stainless', 'C-004')");
			
			System.out.println("Product table created.");
		} 
		catch (SQLException e)
		{
			System.out.println("ERROR: " + e.getMessage());
			e.printStackTrace();
		}
		
	}

	private static void buildInventoryTable(Connection conn)
	{
		try
		{
			Statement stmt = conn.createStatement();
			
			stmt.execute("CREATE TABLE Inventory "
					+ "(InventoryID CHAR(10) NOT NULL PRIMARY KEY, "
					+ "ProductID CHAR(10) NOT NULL, "
					+ "SupplierID CHAR(10) NOT NULL, "
					+ "QuantityInStock INTEGER, "
					+ "CONSTRAINT Inventory_ProductID_FK FOREIGN KEY (ProductID) REFERENCES Product(ProductID) ON DELETE CASCADE, "
					+ "CONSTRAINT Inventory_SupplierID_FK FOREIGN KEY (SupplierID) REFERENCES Supplier(SupplierID) ON DELETE CASCADE)");
			
			stmt.execute("INSERT INTO Inventory VALUES ('I-001', 'P-001', 'S-001', 100)");
			stmt.execute("INSERT INTO Inventory VALUES ('I-002', 'P-002', 'S-002', 200)");
			stmt.execute("INSERT INTO Inventory VALUES ('I-003', 'P-003', 'S-001', 300)");
			stmt.execute("INSERT INTO Inventory VALUES ('I-004', 'P-004', 'S-002', 400)");
			stmt.execute("INSERT INTO Inventory VALUES ('I-005', 'P-005', 'S-001', 500)");
			
			System.out.println("Inventory table created.");
		} 
		catch (SQLException e)
		{
			System.out.println("ERROR: " + e.getMessage());
			e.printStackTrace();
		}
		
	}

	private static void buildCategoryTable(Connection conn)
	{
		try
		{
			Statement stmt = conn.createStatement();
			
			stmt.execute("CREATE TABLE Category "
					+ "(CategoryID CHAR(10) NOT NULL PRIMARY KEY, "
					+ "CategoryName CHAR(20))");
			
			stmt.execute("INSERT INTO Category VALUES ('C-001', 'Bolts')");
			stmt.execute("INSERT INTO Category VALUES ('C-002', 'Nuts')");
			stmt.execute("INSERT INTO Category VALUES ('C-003', 'Washers')");
			stmt.execute("INSERT INTO Category VALUES ('C-004', 'Screws')");
			
			System.out.println("Product Category created.");
		} 
		catch (SQLException e)
		{
			System.out.println("ERROR: " + e.getMessage());
			e.printStackTrace();
		}
		
		
	}

	private static void buildSupplierTable(Connection conn)
	{
		try
		{
			Statement stmt = conn.createStatement();
			
			stmt.execute("CREATE TABLE Supplier "
					+ "(SupplierID CHAR(10) NOT NULL PRIMARY KEY, "
					+ "SupplierName CHAR(30), "
					+ "SupplierAddress CHAR(50), "
					+ "SupplierCity CHAR(30), "
					+ "SupplierProvince CHAR(20), "
					+ "SupplierPostalCode CHAR(10), "
					+ "SupplierPhone CHAR(20), "
					+ "SupplierFax CHAR(20))");
			
			stmt.execute("INSERT INTO Supplier VALUES ('S-001', 'ABC Suppliers', '123 Main St', 'Anytown', 'ON', 'A1B 2C3', '555-123-4567', '555-123-4568')");
			stmt.execute("INSERT INTO Supplier VALUES ('S-002', 'XYZ Suppliers', '456 Oak St', 'Othertown', 'AB', 'X1Y 2Z3', '555-987-6543', '555-987-6542')");
			
			System.out.println("Supplier table created.");
		} 
		catch (SQLException e)
		{
			System.out.println("ERROR: " + e.getMessage());
			e.printStackTrace();
		}
		
	}

}
