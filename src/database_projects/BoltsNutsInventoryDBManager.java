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
				+ String.format("%33s", result.getMetaData().getColumnName(3))
				+ String.format("%47s", result.getMetaData().getColumnName(4))
				+ String.format("%34s", result.getMetaData().getColumnName(5))
				+ String.format("%22s", result.getMetaData().getColumnName(6))
				+ String.format("\t%s", result.getMetaData().getColumnName(7))
				+ String.format("\t\t%s", result.getMetaData().getColumnName(8)));
		
		while(result.next())
		{
			supplierList.add(String.format("%s", result.getString("SupplierID"))
					+ String.format("\t%s", result.getString("SupplierName"))
					+ String.format("%s", result.getString("SupplierAddress"))
					+ String.format("%s", result.getString("SupplierCity"))
					+ String.format("%s", result.getString("SupplierProvince"))
					+ String.format("%s", result.getString("SupplierPostalCode"))
					+ String.format("\t\t%s", result.getString("SupplierPhone"))
					+ String.format("\t%s", result.getString("SupplierFax")));
			
		}
		
		supplierList.add("");
		
		conn.close();
		stmt.close();
		
		return supplierList;
		
	}
	
	public static String addProduct(String productID, String productName, String productDescription, String categoryID) throws SQLException 
	{
		Connection conn = DriverManager.getConnection(DB_URL);
		
		String sqlStatement = "INSERT INTO Product VALUES (?, ?, ?, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sqlStatement);
		pstmt.setString(1, productID);
		pstmt.setString(2, productName);
		pstmt.setString(3, productDescription);
		pstmt.setString(4, categoryID);
		
		int rows = pstmt.executeUpdate();
		
		conn.commit();
		
		pstmt.close();
		conn.close();
		
		return rows + " row(s) added to the table.";
			
	}
	
	public static String addInventory(String inventoryID, String productID, String supplierID, int quantityInStock) throws SQLException 
	{
		Connection conn = DriverManager.getConnection(DB_URL);
		
		String sqlStatement = "INSERT INTO Inventory VALUES (?, ?, ?, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sqlStatement);
		pstmt.setString(1, inventoryID);
		pstmt.setString(2, productID);
		pstmt.setString(3, supplierID);
		pstmt.setInt(4, quantityInStock);
		
		int rows = pstmt.executeUpdate();
		
		conn.commit();
		
		pstmt.close();
		conn.close();
		
		return rows + " row(s) added to the table.";
			
	}
	
	public static String addCategory(String categoryID, String categoryName) throws SQLException 
	{
		Connection conn = DriverManager.getConnection(DB_URL);
		
		String sqlStatement = "INSERT INTO Category VALUES (?, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sqlStatement);
		pstmt.setString(1, categoryID);
		pstmt.setString(2, categoryName);	
		
		int rows = pstmt.executeUpdate();
		
		conn.commit();
		
		pstmt.close();
		conn.close();
		
		return rows + " row(s) added to the table.";
			
	}

	public static String addSupplier(String supplierID, String supplierName, String supplierAddress, String supplierCity, String supplierProvince, String supplierPostalCode, String supplierPhone, String supplierFax) throws SQLException 
	{
		Connection conn = DriverManager.getConnection(DB_URL);
		
		String sqlStatement = "INSERT INTO Supplier VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sqlStatement);
		pstmt.setString(1, supplierID);
		pstmt.setString(2, supplierName);
		pstmt.setString(3, supplierAddress);
		pstmt.setString(4, supplierCity);
		pstmt.setString(5, supplierProvince);
		pstmt.setString(6, supplierPostalCode);
		pstmt.setString(7, supplierPhone);
		pstmt.setString(8, supplierFax);
		
		int rows = pstmt.executeUpdate();
		
		conn.commit();
		
		pstmt.close();
		conn.close();
		
		return rows + " row(s) added to the table.";
			
	}
	
	public static String changeQty(String inventoryID, int newQty) throws SQLException
	{
		
		Connection conn = DriverManager.getConnection(DB_URL);
		
		String sqlStatement = "UPDATE Inventory SET QuantityInStock = ? WHERE InventoryID = ?" ;
		
		PreparedStatement pstmt = conn.prepareStatement(sqlStatement);
		pstmt.setInt(1, newQty);
		pstmt.setString(2, inventoryID);
		
		int rows = pstmt.executeUpdate();
		
		conn.commit();
		
		pstmt.close();
		conn.close();
		
		return rows + " row(s) updated.";
	}
	
	public static ArrayList<String> getInventoryList(String inventoryID) throws SQLException
	{
		ArrayList<String> inventoryList = new ArrayList<>();
		
		Connection conn = DriverManager.getConnection(DB_URL);
		
		String sqlStatement = "SELECT * FROM Inventory WHERE InventoryID = ?" ;
		PreparedStatement pstmt = conn.prepareStatement(sqlStatement);
		pstmt.setString(1, inventoryID);
		
		ResultSet result = pstmt.executeQuery();
		
		while(result.next())
		{
			inventoryList.add(String.format("InventoryID: %s\n", result.getString("InventoryID"))
					+ String.format("ProductID: %s\n", result.getString("ProductID"))
					+ String.format("SupplierID: %s\n", result.getString("SupplierID"))
					+ String.format("Quantity in Stock: %s", result.getInt("QuantityInStock")));
		}	
		
		return inventoryList;
	}
	
	public String deleteProduct(String productID) throws SQLException
	{
		Connection conn = DriverManager.getConnection(DB_URL);
		
		String sqlStatement = "DELETE FROM Product WHERE ProductID = ?" ;
		PreparedStatement pstmt = conn.prepareStatement(sqlStatement);
		pstmt.setString(1, productID);
		
		int rows = pstmt.executeUpdate();
		
		conn.commit();
		
		pstmt.close();
		conn.close();
		
		return rows + " row(s) deleted.";
	}
	
	public String deleteInventory(String inventoryID) throws SQLException
	{
		Connection conn = DriverManager.getConnection(DB_URL);
		
		String sqlStatement = "DELETE FROM Inventory WHERE InventoryID = ?" ;
		PreparedStatement pstmt = conn.prepareStatement(sqlStatement);
		pstmt.setString(1, inventoryID);
		
		int rows = pstmt.executeUpdate();
		
		conn.commit();
		
		pstmt.close();
		conn.close();
		
		return rows + " row(s) deleted.";
	}
	
	public String deleteCategory(String categoryID) throws SQLException
	{
		Connection conn = DriverManager.getConnection(DB_URL);
		
		String sqlStatement = "DELETE FROM Category WHERE CategoryID = ?" ;
		PreparedStatement pstmt = conn.prepareStatement(sqlStatement);
		pstmt.setString(1, categoryID);
		
		int rows = pstmt.executeUpdate();
		
		conn.commit();
		
		pstmt.close();
		conn.close();
		
		return rows + " row(s) deleted.";
	}
	
	public String deleteSupplier(String supplierID) throws SQLException
	{
		Connection conn = DriverManager.getConnection(DB_URL);
		
		String sqlStatement = "DELETE FROM Supplier WHERE SupplierID = ?" ;
		PreparedStatement pstmt = conn.prepareStatement(sqlStatement);
		pstmt.setString(1, supplierID);
		
		int rows = pstmt.executeUpdate();
		
		conn.commit();
		
		pstmt.close();
		conn.close();
		
		return rows + " row(s) deleted.";
	}
	
}
























