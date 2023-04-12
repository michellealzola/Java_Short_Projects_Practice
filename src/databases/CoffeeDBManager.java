package databases;

import java.sql.*;
import java.util.ArrayList;

public class CoffeeDBManager
{
	public final static String DB_URL = "jdbc:derby:CoffeeDB";

	public static ArrayList<String> getCustomerNames() throws SQLException
	{
		Connection conn = DriverManager.getConnection(DB_URL);
		Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		
		ResultSet resultSet = stmt.executeQuery("SELECT Name FROM Customer");
		
		// Get number of rows
		resultSet.last();
		int numRows = resultSet.getRow();
		resultSet.first();
		
		ArrayList<String> listData = new ArrayList<>();
		
		for(int index = 0; index < numRows; index++)
		{
			listData.add(resultSet.getString(1));
			
			resultSet.next();
		}
		
		conn.close();
		stmt.close();
		
		return listData;
				
	}
	
	public static ArrayList<String> getCoffeeNames() throws SQLException
	{
		Connection conn = DriverManager.getConnection(DB_URL);
		Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		
		ResultSet resultSet = stmt.executeQuery("SELECT Description FROM Coffee");
		
		resultSet.last();
		int numRows = resultSet.getRow();
		resultSet.first();
		
		ArrayList<String> listData = new ArrayList<>();
		
		for(int index = 0; index < numRows; index++)
		{
			listData.add(resultSet.getString(1));
			
			resultSet.next();
		}
		
		conn.close();
		stmt.close();
		
		return listData;
	}

	public static String getProdNum(String coffeeName) throws SQLException
	{
		String prodNum = "";
		
		Connection conn = DriverManager.getConnection(DB_URL);
		Statement stmt = conn.createStatement();
		
		ResultSet resultSet = stmt.executeQuery("SELECT prodNum "
												+ "FROM Coffee "
												+ "WHERE Description = '" + coffeeName + "'");
		
		if(resultSet.next())
		{
			prodNum = resultSet.getString(1);
			
		}
		
		conn.close();
		stmt.close();
		
		return prodNum;
	}
	
	public static double getCoffeePrice(String prodNum) throws SQLException
	{
		double price = 0.0;
		
		Connection conn = DriverManager.getConnection(DB_URL);
		Statement stmt = conn.createStatement();
		
		ResultSet resultSet = stmt.executeQuery("SELECT price "
												+ "FROM Coffee "
												+ "WHERE ProdNum = '" + prodNum + "'");
		
		if(resultSet.next())
		{
			price = resultSet.getDouble(1);
			
		}
		
		conn.close();
		stmt.close();
		
		return price;
	}
	
	public static String getCustomerNum(String name) throws SQLException
	{
		String customerNum = "";
		
		Connection conn = DriverManager.getConnection(DB_URL);
		Statement stmt = conn.createStatement();
		
		ResultSet resultSet = stmt.executeQuery("SELECT customerNumber "
												+ "FROM Customer "
												+ "WHERE Name = '" + name + "'");
		
		if(resultSet.next())
		{
			customerNum = resultSet.getString(1);
			
		}
		
		conn.close();
		stmt.close();
		
		return customerNum;
	}
	
	public static void submitOrder(String custNum, String prodNum, int quantity, double price, String orderDate) throws SQLException
	{
		double cost = quantity * price;
		
		Connection conn = DriverManager.getConnection(DB_URL);
		Statement stmt = conn.createStatement();
		
		ResultSet resultSet = stmt.executeQuery("INSERT INTO UnpaidOrder VALUES"
												+ "('" + custNum + "', '" 
												+ prodNum + "', '" 
												+ orderDate + "', " 
												+ quantity + ", " 
												+ cost + ")");
		
		conn.close();
		stmt.close();
		
	}
}



















