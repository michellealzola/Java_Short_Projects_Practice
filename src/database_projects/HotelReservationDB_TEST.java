package database_projects;

import java.sql.*;

public class HotelReservationDB_TEST
{

	public static void main(String[] args)
	{
		final String DB_URL = "jdbc:derby:HotelReservationDB";
		
		try
		{
			Connection conn = DriverManager.getConnection(DB_URL);
			
			Statement stmt = conn.createStatement();
			
			String sql = "SELECT * FROM Room";
			
			ResultSet result = stmt.executeQuery(sql);
			
			while(result.next())
			{
				System.out.println(result.getString("id")
						+ result.getString("room_number")
						+ result.getString("room_type")
						+ result.getString("room_price"));
			}
			
			
			
			conn.close();
			
		} 
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.getMessage());
		}

	}

}
