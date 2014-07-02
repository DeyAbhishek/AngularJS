package co.prvn.eatery.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnector {

	public final static String USERNAME = "root";
	public final static String PASSWORD = "root";
	public final static String DB_STRING = "jdbc:mysql://localhost:3306/eatery_db";

	
	/**
	 * Get a Connection from the Database
	 * @return Connection
	 */
	public static Connection connectToDB() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(DB_STRING, USERNAME, PASSWORD);
			System.out.println("Connection successful");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Error in creating connection. " + e.getMessage());
		}

		return conn;
	}

	/**
	 * Close the DB resources gracefully
	 * @param pstmt
	 * @param rs
	 * @param conn
	 */
	public static void closeResources(PreparedStatement pstmt, ResultSet rs, Connection conn) {

		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	public static void main(String[] args) { 
		DBConnector.connectToDB(); 
	}
	*/

}
