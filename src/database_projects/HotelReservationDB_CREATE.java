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
			
			stmt.execute("CREATE TABLE Guest (\r\n"
					+ "    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,\r\n"
					+ "    guest_name VARCHAR(50) NOT NULL,\r\n"
					+ "    guest_phone VARCHAR(15) NOT NULL,\r\n"
					+ "    guest_email VARCHAR(50) NOT NULL\r\n"
					+ ")");
			
			stmt.execute("INSERT INTO Guest (guest_name, guest_phone, guest_email) VALUES ('John Doe', '123-456-7890', 'john.doe@example.com')");
			stmt.execute("INSERT INTO Guest (guest_name, guest_phone, guest_email) VALUES ('Jane Smith', '456-789-0123', 'jane.smith@example.com')");
			stmt.execute("INSERT INTO Guest (guest_name, guest_phone, guest_email) VALUES ('Bob Johnson', '789-012-3456', 'bob.johnson@example.com')");
			stmt.execute("INSERT INTO Guest (guest_name, guest_phone, guest_email) VALUES ('Alice Brown', '012-345-6789', 'alice.brown@example.com')");
			
			System.out.println("Guest table created.");
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
			
			stmt.execute("CREATE TABLE Room (\r\n"
					+ "    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,\r\n"
					+ "    room_number INT NOT NULL,\r\n"
					+ "    room_type VARCHAR(50) NOT NULL,\r\n"
					+ "    room_price DECIMAL(10, 2) NOT NULL\r\n"
					+ ")");
			
			stmt.execute("INSERT INTO Room (room_number, room_type, room_price) VALUES (101, 'Standard', 100)");
			stmt.execute("INSERT INTO Room (room_number, room_type, room_price) VALUES (102, 'Standard', 100)");
			stmt.execute("INSERT INTO Room (room_number, room_type, room_price) VALUES (201, 'Deluxe', 150)");
			stmt.execute("INSERT INTO Room (room_number, room_type, room_price) VALUES (202, 'Deluxe', 150)");
			stmt.execute("INSERT INTO Room (room_number, room_type, room_price) VALUES (301, 'Suite', 250)");
			stmt.execute("INSERT INTO Room (room_number, room_type, room_price) VALUES (302, 'Suite', 250)");
			
			System.out.println("Room table created.");
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
			
			stmt.execute("CREATE TABLE Booking (\r\n"
					+ "    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,\r\n"
					+ "    room_id INT NOT NULL,\r\n"
					+ "    guest_id INT NOT NULL,\r\n"
					+ "    check_in DATE NOT NULL,\r\n"
					+ "    check_out DATE NOT NULL,\r\n"
					+ "    CONSTRAINT fk_booking_room FOREIGN KEY (room_id) REFERENCES Room (id) ON DELETE CASCADE,\r\n"
					+ "    CONSTRAINT fk_booking_guest FOREIGN KEY (guest_id) REFERENCES Guest (id) ON DELETE CASCADE,\r\n"
					+ "    CONSTRAINT chk_booking_dates CHECK (check_out >= check_in)\r\n"
					+ ")");
			
			stmt.execute("INSERT INTO Booking (room_id, guest_id, check_in, check_out) VALUES (1, 1, '2023-05-01', '2023-05-03')");
			stmt.execute("INSERT INTO Booking (room_id, guest_id, check_in, check_out) VALUES (2, 2, '2023-05-02', '2023-05-04')");
			stmt.execute("INSERT INTO Booking (room_id, guest_id, check_in, check_out) VALUES (3, 3, '2023-05-05', '2023-05-07')");
			stmt.execute("INSERT INTO Booking (room_id, guest_id, check_in, check_out) VALUES (4, 4, '2023-05-08', '2023-05-10')");
			stmt.execute("INSERT INTO Booking (room_id, guest_id, check_in, check_out) VALUES (5, 1, '2023-05-15', '2023-05-20')");
			
			
			System.out.println("Booking table created.");
		} 
		catch (SQLException e)
		{
			System.out.println("ERROR: " + e.getMessage());
			e.printStackTrace();
		}
		
		
	}

}
