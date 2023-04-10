package databases;

import java.sql.*;

public class ShowCoffeeDescription
{

	public static void main(String[] args)
	{
		final String DB_URL = "jdbc:derby:CoffeeDB";
		
		try
		{
			Connection conn = DriverManager.getConnection(DB_URL);
			Statement stmt = conn.createStatement();
			
			String sqlStatement = "SELECT Description "
								+ "FROM Coffee";
			
			ResultSet result = stmt.executeQuery(sqlStatement);
			
			System.out.println("Coffees Found in the Database:");
			System.out.println("----------------------------------");
			
			while(result.next())
			{
				System.out.println(result.getString("Description"));
			}
			
			conn.close();
			
		} 
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.getMessage());
		}
		

	}

}
