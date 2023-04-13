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
		
		productList.add(String.format("%s", result.getMetaData().getColumnName(1))
							+ String.format("\t\t%s", result.getMetaData().getColumnName(2)) 
							+ String.format("\t\t\t%s", result.getMetaData().getColumnName(3)) 
							+ String.format("\t\t\t%s", result.getMetaData().getColumnName(4)));
		
		while(result.next())
		{
			productList.add(String.format("%s", result.getString("ProductID"))
								+ String.format("\t\t%s", result.getString("ProductName"))
								+ String.format("\t%s", result.getString("ProductDescription"))
								+ String.format("\t\t%s", result.getString("CategoryID")));
			
		}
		
		productList.add("");
		
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
		
		inventoryList.add(String.format("%s", result.getMetaData().getColumnName(1))
				+ String.format("\t\t%s", result.getMetaData().getColumnName(2))
				+ String.format("\t\t\t%s", result.getMetaData().getColumnName(3))
				+ String.format("\t\t\t%s", result.getMetaData().getColumnName(4)));
		
		while(result.next())
		{
			inventoryList.add(String.format("%s", result.getString("InventoryID"))
					+ String.format("\t\t%s", result.getString("ProductID"))
					+ String.format("\t\t\t%s", result.getString("SupplierID"))
					+ String.format("\t\t\t%s", result.getInt("QuantityInStock")));
			
		}
		
		inventoryList.add("");
		
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
		
		categoryList.add(String.format("%s", result.getMetaData().getColumnName(1))
				+ String.format("\t\t%s", result.getMetaData().getColumnName(2)));
		
		while(result.next())
		{
			categoryList.add(String.format("%s", result.getString("CategoryID"))
					+ String.format("\t\t%s", result.getString("CategoryName")));
			
		}
		
		categoryList.add("");
		
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
		
		supplierList.add(String.format("%s", result.getMetaData().getColumnName(1))
				+ String.format("\t%s", result.getMetaData().getColumnName(2))
				+ String.format("\t\t\t%s", result.getMetaData().getColumnName(3))
				+ String.format("\t\t\t\t\t%s", result.getMetaData().getColumnName(4))
				+ String.format("\t\t\t%s", result.getMetaData().getColumnName(5))
				+ String.format("\t\t\t%s", result.getMetaData().getColumnName(6))
				+ String.format("\t\t\t%s", result.getMetaData().getColumnName(7)));
		
		while(result.next())
		{
			supplierList.add(String.format("%s", result.getString("SupplierID"))
					+ String.format("\t%s", result.getString("SupplierName"))
					+ String.format("%s", result.getString("SupplierAddress"))
					+ String.format("%s", result.getString("SupplierCity"))
					+ String.format("%s", result.getString("SupplierPostalCode"))
					+ String.format("\t\t%s", result.getString("SupplierPhone"))
					+ String.format("\t\t\t%s", result.getString("SupplierFax")));
			
		}
		
		supplierList.add("");
		
		conn.close();
		stmt.close();
		
		return supplierList;
		
	}
}
