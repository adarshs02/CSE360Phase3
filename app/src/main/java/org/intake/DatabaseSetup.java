package org.intake;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {
	private static final String DB_URL = "jdbc:sqlite:users.db";
	 static boolean validateLogin(String username, String password) {
	        try (Connection conn = DriverManager.getConnection(DB_URL);
	            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?")) {
	            stmt.setString(1, username);
	            stmt.setString(2, password);
	            try (ResultSet rs = stmt.executeQuery()) {
	                return rs.next(); // If the query returns any row, login is successful
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    // Method to create account in the database
	    static boolean createAccount(String username, String password, String accountType) {
	        try (Connection conn = DriverManager.getConnection(DB_URL);
	        	PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (username, password, account_type) VALUES (?, ?, ?)")) {
	            stmt.setString(1, username);
	            stmt.setString(2, password);
	            stmt.setString(3, accountType);
	            int rowsInserted = stmt.executeUpdate();
	            return rowsInserted > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	   // Method to create database
	    public static void initializeDatabase() throws ClassNotFoundException {
			String sql = "CREATE TABLE IF NOT EXISTS users (" 
					+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "username TEXT UNIQUE NOT NULL,"	// first 5 fields are NOT NULL since they are required for all user accounts
					+ "password TEXT NOT NULL,"
	                + "account_type TEXT NOT NULL);";
			System.out.println("Creating DB");
			// Connect to the user db file
			try (Connection connection = DriverManager.getConnection(DB_URL); Statement stmt = connection.createStatement()) {
				stmt.execute(sql);
				System.out.println("Database and user table initialized successfully.");
			} catch (SQLException e) {	//Print the error message if we were unable to connect to the db file
				System.out.println("Failed");
				System.out.println(e.getMessage());
			}
		}
}
