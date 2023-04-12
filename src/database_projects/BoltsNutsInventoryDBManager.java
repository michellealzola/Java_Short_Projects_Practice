package database_projects;

import java.util.ArrayList;
import java.sql.*;

public class BoltsNutsInventoryDBManager
{
	private final static String DB_URL = "jdbc:derby:BoltsNutsInventoryDB";
	
	public static ArrayList<String> getProductList() throws SQLException
	{
		ArrayList<String> productList = new ArrayList<>();
		
		Connection conn = DriverManager.getConnection(DB_URL);
		Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		
		String sqlStatement = "SELECT * FROM Product";
		
		ResultSet result = stmt.executeQuery(sqlStatement);
		
		while(result.next())
		{
			productList.add(result.getString("ProductID")
								+ result.getString("ProductName")
								+ result.getString("ProductDescription")
								+ result.getString("CategoryID"));
			
		}
		
		conn.close();
		stmt.close();
		
		return productList;
		
	}
	
	public static ArrayList<String> getInventoryList() throws SQLException
	{
		ArrayList<String> inventoryList = new ArrayList<>();
		
		Connection conn = DriverManager.getConnection(DB_URL);
		Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		
		String sqlStatement = "SELECT * FROM Inventory";
		
		ResultSet result = stmt.executeQuery(sqlStatement);
		
		while(result.next())
		{
			inventoryList.add(result.getString("InventoryID")
					+ result.getString("ProductID")
					+ result.getString("SupplierID")
					+ result.getInt("QuantityInStock"));
			
		}
		
		conn.close();
		stmt.close();
		
		return inventoryList;
		
	}
	
	public static ArrayList<String> getCategoryList() throws SQLException
	{
		ArrayList<String> categoryList = new ArrayList<>();
		
		Connection conn = DriverManager.getConnection(DB_URL);
		Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		
		String sqlStatement = "SELECT * FROM Category";
		
		ResultSet result = stmt.executeQuery(sqlStatement);
		
		while(result.next())
		{
			categoryList.add(result.getString("CategoryID")
					+ result.getString("CategoryName"));
			
		}
		
		conn.close();
		stmt.close();
		
		return categoryList;
		
	}
	
	public static ArrayList<String> getSupplierList() throws SQLException
	{
		ArrayList<String> supplierList = new ArrayList<>();
		
		Connection conn = DriverManager.getConnection(DB_URL);
		Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		
		String sqlStatement = "SELECT * FROM Supplier";
		
		ResultSet result = stmt.executeQuery(sqlStatement);
		
		while(result.next())
		{
			supplierList.add(result.getString("SupplierID")
					+ result.getString("SupplierName")
					+ result.getString("SupplierAddress")
					+ result.getString("SupplierCity")
					+ result.getString("SupplierPostalCode")
					+ result.getString("SupplierPhone")
					+ result.getString("SupplierFax"));
			
		}
		
		conn.close();
		stmt.close();
		
		return supplierList;
		
	}
}
