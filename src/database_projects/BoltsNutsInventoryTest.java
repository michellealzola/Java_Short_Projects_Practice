package database_projects;

import java.sql.*;

public class BoltsNutsInventoryTest
{

	public static void main(String[] args)
	{
		final String DB_URL = "jdbc:derby:BoltsNutsInventoryDB";
		
		try
		{
			Connection conn = DriverManager.getConnection(DB_URL);
			
			viewProduct(conn);
			viewInventory(conn);
			viewCategory(conn);
			viewSupplier(conn);
			
			conn.close();
			
		} 
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.getMessage());
		}
		

	}

	private static void viewProduct(Connection conn) throws SQLException
	{
		Statement stmt = conn.createStatement();
		
		String sqlStatement = "SELECT * FROM Product";
		
		ResultSet result = stmt.executeQuery(sqlStatement);
		System.out.println("Product Table");		
		
		System.out.println(result.getMetaData().getColumnName(1) + "          "
							+ result.getMetaData().getColumnName(2) + "          "
							+ result.getMetaData().getColumnName(3) + "          "
							+ result.getMetaData().getColumnName(4));
		
		System.out.println("--------------------------------------------------------------------------------");
		
		while(result.next())
		{
			System.out.println(result.getString("ProductID")
								+ result.getString("ProductName")
								+ result.getString("ProductDescription")
								+ result.getString("CategoryID"));
		}
		
		System.out.println();
		
	}

	private static void viewInventory(Connection conn) throws SQLException
	{
		Statement stmt = conn.createStatement();
		
		String sqlStatement = "SELECT * FROM Inventory";
		
		ResultSet result = stmt.executeQuery(sqlStatement);
		System.out.println("Inventory Table");
		
		System.out.println(result.getMetaData().getColumnName(1) + "          "
				+ result.getMetaData().getColumnName(2) + "          "
				+ result.getMetaData().getColumnName(3) + "          "
				+ result.getMetaData().getColumnName(4));

		System.out.println("--------------------------------------------------------------------------------");
		
		while(result.next())
		{
			System.out.println(result.getString("InventoryID")
								+ result.getString("ProductID")
								+ result.getString("SupplierID")
								+ result.getInt("QuantityInStock"));
		}
		
		System.out.println();
		
	}

	private static void viewCategory(Connection conn) throws SQLException
	{
		Statement stmt = conn.createStatement();
		
		String sqlStatement = "SELECT * FROM Category";
		
		ResultSet result = stmt.executeQuery(sqlStatement);
		System.out.println("Category Table");

		System.out.println(result.getMetaData().getColumnName(1) + "          "
				+ result.getMetaData().getColumnName(2));

		System.out.println("--------------------------------------------------------------------------------");
		
		
		while(result.next())
		{
			System.out.println(result.getString("CategoryID")
								+ result.getString("CategoryName"));
		}
		
		System.out.println();
		
	}

	private static void viewSupplier(Connection conn) throws SQLException
	{
		Statement stmt = conn.createStatement();
		
		String sqlStatement = "SELECT * FROM Supplier";
		
		ResultSet result = stmt.executeQuery(sqlStatement);
		System.out.println("Supplier Table");

		System.out.println(result.getMetaData().getColumnName(1) + "          "
				+ result.getMetaData().getColumnName(2) + "          "
				+ result.getMetaData().getColumnName(3) + "          "
				+ result.getMetaData().getColumnName(4) + "          "
				+ result.getMetaData().getColumnName(5) + "          "
				+ result.getMetaData().getColumnName(6) + "          "
				+ result.getMetaData().getColumnName(7));

		System.out.println("--------------------------------------------------------------------------------");
		
		
		while(result.next())
		{
			System.out.println(result.getString("SupplierID")
								+ result.getString("SupplierName")
								+ result.getString("SupplierAddress")
								+ result.getString("SupplierCity")
								+ result.getString("SupplierPostalCode")
								+ result.getString("SupplierPhone")
								+ result.getString("SupplierFax"));
		}
		
		System.out.println();
	}

}
