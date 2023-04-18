package database_projects;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class HotelReservationDB_MANAGER
{
	private final static String DB_URL = "jdbc:derby:HotelReservationDB";
	
	public static String addGuest(int guest_id, String guest_name, String guest_phone, String guest_email) throws SQLException
	{
		Connection conn = DriverManager.getConnection(DB_URL);
		
		String sqlStatement = "INSERT INTO Guest VALUES (?, ?, ?, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sqlStatement);
		pstmt.setInt(1, guest_id);
		pstmt.setString(2, guest_name);
		pstmt.setString(3, guest_phone);
		pstmt.setString(4, guest_email);
		
		int rows = pstmt.executeUpdate();
		
		conn.commit();
		
		pstmt.close();
		conn.close();
		
		return rows + " row(s) added to the Guest table";
		
	}
	
	public static String addRoom(int room_id, int room_num, String room_type, double room_price) throws SQLException
	{
		Connection conn = DriverManager.getConnection(DB_URL);
		
		String sqlStatement = "INSERT INTO Room VALUES (?, ?, ?, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sqlStatement);
		pstmt.setInt(1, room_id);
		pstmt.setInt(2, room_num);
		pstmt.setString(3, room_type);
		pstmt.setDouble(4, room_price);
		
		int rows = pstmt.executeUpdate();
		
		conn.commit();
		
		pstmt.close();
		conn.close();
		
		return rows + " row(s) added to the Room table";
		
	}
	
	public static String addBooking(int booking_id, int room_id, int guest_id, Date check_in, Date check_out) throws SQLException
	{
		Connection conn = DriverManager.getConnection(DB_URL);
		
		String sqlStatement = "INSERT INTO Booking VALUES (?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sqlStatement);
		pstmt.setInt(1, booking_id);
		pstmt.setInt(2, room_id);
		pstmt.setInt(3, guest_id);
		pstmt.setDate(4, check_in);
		pstmt.setDate(5, check_out);
		
		int rows = pstmt.executeUpdate();
		
		conn.commit();
		
		pstmt.close();
		conn.close();
		
		return rows + " row(s) added to the Booking table";
		
	}
}
