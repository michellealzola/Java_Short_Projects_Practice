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
			
			viewGuest(conn);
			viewRoom(conn);
			viewBooking(conn);
			
			
			conn.close();
			
		} 
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.getMessage());
		}

	}

	private static void viewGuest(Connection conn)
	{
		Statement stmt;
		try
		{
			stmt = conn.createStatement();
			
			String sql = "SELECT * FROM Guest";
			
			ResultSet result = stmt.executeQuery(sql);
			
			System.out.println(result.getMetaData().getColumnName(1)
					+ result.getMetaData().getColumnName(2)
					+ result.getMetaData().getColumnName(3)
					+ result.getMetaData().getColumnName(4));
			
			while(result.next())
			{
				System.out.println(result.getString("id")
						+ result.getString("guest_name")
						+ result.getString("guest_phone")
						+ result.getString("guest_email"));
			}
			System.out.println();			
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void viewRoom(Connection conn)
	{
		Statement stmt;
		try
		{
			stmt = conn.createStatement();
			
			String sql = "SELECT * FROM Room";
			
			ResultSet result = stmt.executeQuery(sql);
			
			System.out.println(result.getMetaData().getColumnName(1)
					+ result.getMetaData().getColumnName(2)
					+ result.getMetaData().getColumnName(3)
					+ result.getMetaData().getColumnName(4));
			
			while(result.next())
			{
				System.out.println(result.getString("id")
						+ result.getString("room_number")
						+ result.getString("room_type")
						+ result.getString("room_price"));
			}
			System.out.println();			
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void viewBooking(Connection conn)
	{
		Statement stmt;
		try
		{
			stmt = conn.createStatement();
			
			String sql = "SELECT * FROM Booking";
			
			ResultSet result = stmt.executeQuery(sql);
			
			System.out.println(result.getMetaData().getColumnName(1)
					+ result.getMetaData().getColumnName(2)
					+ result.getMetaData().getColumnName(3)
					+ result.getMetaData().getColumnName(4)
					+ result.getMetaData().getColumnName(5));
			
			while(result.next())
			{
				System.out.println(result.getString("id")
						+ result.getString("room_id")
						+ result.getString("guest_id")
						+ result.getString("check_in")
						+ result.getString("check_out"));
			}
			System.out.println();			
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
