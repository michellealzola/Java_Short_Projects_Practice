package database_projects;

import java.sql.*;

public class HotelReservationDB_CREATE
{

	public static void main(String[] args)
	{
		final String DB_URL = "jdbc:derby:HotelReservationDB;create=true";
		
		try
		{
			Connection conn = DriverManager.getConnection(DB_URL);			
			
			dropTables(conn);
			buildGuestTable(conn);
			buildRoomTable(conn);
			buildBookingTable(conn);
			
			conn.close();
			
			
			
			
		} 
		catch (SQLException e)
		{
			System.out.println("ERROR: " + e.getMessage());
		}
		
		
		

	}

	private static void dropTables(Connection conn)
	{
		// TODO Auto-generated method stub
		
	}

	private static void buildGuestTable(Connection conn)
	{
		// TODO Auto-generated method stub
		
	}

	private static void buildRoomTable(Connection conn)
	{
		// TODO Auto-generated method stub
		
	}

	private static void buildBookingTable(Connection conn)
	{
		// TODO Auto-generated method stub
		
	}

}
