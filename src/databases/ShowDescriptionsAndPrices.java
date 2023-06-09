package databases;

import java.sql.*;

public class ShowDescriptionsAndPrices
{

	public static void main(String[] args)
	{
		final String DB_URL = "jdbc:derby:CoffeeDB";
		
		try
		{
			Connection conn = DriverManager.getConnection(DB_URL);
			Statement stmt = conn.createStatement();
			
			String sqlStatement = "SELECT Description, Price "
								+ "FROM Coffee";
			
			ResultSet result = stmt.executeQuery(sqlStatement);
			
			while(result.next())
			{
				System.out.printf("%25s %.2f\n", result.getString("Description"), result.getDouble("Price"));				
			}
			
			conn.close();
			
		} 
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.getMessage());
		}
		

	}

}
