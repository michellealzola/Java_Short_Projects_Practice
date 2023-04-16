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
		try
		{
			Statement stmt = conn.createStatement();
			
			stmt.execute("CREATE TABLE Guest "
						+ "(id INT NOT NULL PRIMARY KEY, "
						+ "guest_name VARCHAR(50) NOT NULL, "
						+ "guest_phone VARCHAR(15) NOT NULL, "
						+ "guest_email VARCHAR(50) NOT NULL)");
			
			stmt.execute("INSERT INTO Guest VALUES (1, 'John Doe', '123-456-7890', 'john.doe@example.com')");
			stmt.execute("INSERT INTO Guest VALUES (2, 'Jane Smith', '456-789-0123', 'jane.smith@example.com')");
			stmt.execute("INSERT INTO Guest VALUES (3, 'Bob Johnson', '789-012-3456', 'bob.johnson@example.com')");
			stmt.execute("INSERT INTO Guest VALUES (4, 'Alice Brown', '012-345-6789', 'alice.brown@example.com')");
		} 
		catch (SQLException e)
		{
			System.out.println("ERROR: " + e.getMessage());
			e.printStackTrace();
		}
		
	}

	private static void buildRoomTable(Connection conn)
	{
		try
		{
			Statement stmt = conn.createStatement();
			
			stmt.execute("CREATE TABLE Room "
						+ "(id INT NOT NULL PRIMARY KEY, "
						+ "room_number INT NOT NULL, "
						+ "room_type VARCHAR(50) NOT NULL, "
						+ "room_price DECIMAL(10, 2) NOT NULL)");
			
			stmt.execute("INSERT INTO Room VALUES (1, 101, 'Standard', 100)");
			stmt.execute("INSERT INTO Room VALUES (2, 102, 'Standard', 100)");
			stmt.execute("INSERT INTO Room VALUES (3, 201, 'Deluxe', 150)");
			stmt.execute("INSERT INTO Room VALUES (4, 202, 'Deluxe', 150)");
			stmt.execute("INSERT INTO Room VALUES (5, 301, 'Suite', 250)");
			stmt.execute("INSERT INTO Room VALUES (6, 302, 'Suite', 250)");
		} 
		catch (SQLException e)
		{
			System.out.println("ERROR: " + e.getMessage());
			e.printStackTrace();
		}
		
		
	}

	private static void buildBookingTable(Connection conn)
	{
		try
		{
			Statement stmt = conn.createStatement();
			
			stmt.execute("CREATE TABLE Booking "
						+ "(id INT NOT NULL PRIMARY KEY, "
						+ "room_id INT NOT NULL, "
						+ "guest_id INT NOT NULL, "
						+ "check_in DATE NOT NULL, "
						+ "check_out DATE NOT NULL, "
						+ "CONSTRAINT fk_booking_room FOREIGN KEY (room_id) REFERENCES Room (id) ON DELETE CASCADE, "
						+ "CONSTRAINT fk_booking_guest FOREIGN KEY (guest_id) REFERENCES Guest (id) ON DELETE CASCADE, "
						+ "CONSTRAINT chk_booking_dates CHECK (check_out >= check_in))");
			
			stmt.execute("INSERT INTO Booking VALUES (1, 1, 1, '2023-05-01', '2023-05-03')");
			stmt.execute("INSERT INTO Booking VALUES (2, 2, 2, '2023-05-02', '2023-05-04')");
			stmt.execute("INSERT INTO Booking VALUES (3, 3, 3, '2023-05-05', '2023-05-07')");
			stmt.execute("INSERT INTO Booking VALUES (4, 4, 4, '2023-05-08', '2023-05-10')");
			stmt.execute("INSERT INTO Booking VALUES (5, 5, 1, '2023-05-15', '2023-05-20')");
			stmt.execute("INSERT INTO Booking VALUES (6, 6, 2, '2023-06-01', '2023-06-03')");
		} 
		catch (SQLException e)
		{
			System.out.println("ERROR: " + e.getMessage());
			e.printStackTrace();
		}
		
		
	}

}
