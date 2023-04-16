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
		System.out.println("Dropping Tables...");
		
		try
		{
			Statement stmt = conn.createStatement();
			
			try
			{
				stmt.execute("DROP TABLE Room CASCADE CONSTRAINTS");
				System.out.println("Room table dropped");
			} 
			catch (Exception e)
			{
				// No need for an error message. The table does not exist.
			}
			
			try
			{
				stmt.execute("DROP TABLE Guest CASCADE CONSTRAINTS");
				System.out.println("Guest table dropped");
			} 
			catch (Exception e)
			{
				// No need for an error message. The table does not exist.
			}
			
			try
			{
				stmt.execute("DROP TABLE Booking CASCADE CONSTRAINTS");
				System.out.println("Booking table dropped");
			} 
			catch (Exception e)
			{
				// No need for an error message. The table does not exist.
			}
		} 
		catch (SQLException e)
		{
			System.out.println("ERROR: " + e.getMessage());
			e.printStackTrace();
		}
		
		
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
