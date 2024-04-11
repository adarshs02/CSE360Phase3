package org.intake;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseSetup {
	private static final String DB_URL = "jdbc:sqlite:users.db";
	
	// Create/open msgs.db
		private static final String MSG_DB_URL = "jdbc:sqlite:msgs.db";
	
	 static LoginResult validateLogin(String userid, String password) {
	        try (Connection conn = DriverManager.getConnection(DB_URL);
	            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE userid = ? AND password = ?")) {
	            stmt.setString(1, userid);
	            stmt.setString(2, password);
	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                    String accountType = rs.getString("account_type");
	                    return new LoginResult(true, accountType); // If the query returns any row, login is successful
	                } else {
	                    return new LoginResult(false, null); // Login failed
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return new LoginResult(false, null); // Login failed due to exception
	        }
	    }
	 
	 // Inner class to hold the result of the login operation
	    static class LoginResult {
	        private final boolean success;
	        private final String accountType;

	        public LoginResult(boolean success, String accountType) {
	            this.success = success;
	            this.accountType = accountType;
	        }

	        public boolean isSuccess() {
	            return success;
	        }

	        public String getAccountType() {
	            return accountType;
	        }
	    }
	    
	    public static void initializeDatabase() throws ClassNotFoundException {
			String sql = "CREATE TABLE IF NOT EXISTS users (" 
					+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "firstname TEXT NOT NULL,"
					+ "lastname TEXT NOT NULL,"
					+ "dateOfBirth TEXT NULL,"
					+ "password TEXT NOT NULL,"
	                + "account_type TEXT NOT NULL,"
					+ "userid TEXT UNIQUE NULL);";
			
			// Connect to the user db file
			try (Connection connection = DriverManager.getConnection(DB_URL); Statement stmt = connection.createStatement()) {
				stmt.execute(sql);
				System.out.println("Database and user table initialized successfully.");
			} catch (SQLException e) {	//Print the error message if we were unable to connect to the db file
				System.out.println(e.getMessage());
			}
		}

	    // Method to create account in the database
	    static boolean createAccount(String firstName, String lastName, String dateOfBirth, String password, String accountType, String userid) {
	        try (Connection conn = DriverManager.getConnection(DB_URL);
	        	PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (firstName, lastName, dateOfBirth, password, account_type, userid) VALUES (?, ?, ?, ?, ?, ?)")) {
	            stmt.setString(1, firstName);
	            stmt.setString(2, lastName);
	            stmt.setString(3, dateOfBirth);
	            stmt.setString(4, password);
	            stmt.setString(5, accountType);
	            stmt.setString(6, userid);
	            int rowsInserted = stmt.executeUpdate();
	            return rowsInserted > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    public static void initializeMessageDatabase() {
			String sql = "CREATE TABLE IF NOT EXISTS msgs (" 
					+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "sender_id INTEGER,"  
					+ "recipient_id INTEGER," 
					+ "subject TEXT," 
					+ "body TEXT,"
					+ "timestamp TEXT,"
					+ "thread_id INTEGER,"
					+ "FOREIGN KEY (sender_id) REFERENCES users(id)," // Use two foreign keys to assign the message to a unique sender and recipient 
					+ "FOREIGN KEY (recipient_id) REFERENCES users(id));";	
			
			// Connect to the message db file
			try (Connection connection = DriverManager.getConnection(MSG_DB_URL); Statement stmt = connection.createStatement()) {
				stmt.execute(sql);
				System.out.println("Message database and table initialized successfully.");
			} catch (SQLException e) {	//Print error messasge if unable to connect to message db file
				System.out.println(e.getMessage());
			}
		}
	    
	    public static List<User> getNursesAndDoctors() {
			List<User> users = new ArrayList<>();
			
			String sql = "SELECT * FROM users WHERE account_type = 'Nurse' OR role = 'Doctor'";
			
			// Make the connection to the db
			try (Connection connection = DriverManager.getConnection(DB_URL); PreparedStatement pstmt = connection.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
				// Iterate through all users in the list have role type NURSE or DOCTOR and add them to the list
		        while (rs.next()) {
		        	Role role = Role.valueOf(rs.getString("role"));
		            users.add(new User(rs.getString("username"), rs.getString("password"), role, rs.getString("firstName"), rs.getString("lastName")));
		        }
		    } catch (SQLException e) {	// Print the error message if unable to connect
		        System.err.println(e.getMessage());
		    }
		    return users;
		}
	    
	    public static List<User> getAllUsers() {
			List<User> users = new ArrayList<>();
			
			String sql = "SELECT * FROM users";
			
			// Make the connection to the db file
			try (Connection connection = DriverManager.getConnection(DB_URL); PreparedStatement pstmt = connection.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
				// Iterate through every user in the db and add them to the list
		        while (rs.next()) {
		        	Role role = Role.valueOf(rs.getString("role"));
		            users.add(new User(rs.getString("username"), rs.getString("password"), role, rs.getString("firstName"), rs.getString("lastName")));
		        }
		    } catch (SQLException e) {	// Print the error message if we were unable to connect to the db
		        System.err.println(e.getMessage());
		    }
		    return users;
		}
	    
	 // Method to get a user Id from a name and role
		public static int getUserIdByNameAndRole(String firstName, String lastName, String accountType) {
			String sql = "SELECT id FROM users WHERE firstName = ? AND lastName = ? AND accountType = ?";
			
			// Make the connection to the db
			try (Connection connection = DriverManager.getConnection(DB_URL); PreparedStatement pstmt = connection.prepareStatement(sql)) {
				pstmt.setString(1, firstName);
				pstmt.setString(2, lastName);
				pstmt.setString(3, accountType);
		        
				ResultSet rs = pstmt.executeQuery();
				
				if (rs.next()) {
					return rs.getInt("id");
				}	
		    } catch (SQLException e) {
		        System.err.println("Error fetching user ID by name and role: " + e.getMessage());
		    }
			 
		    return -1;
		}
		
		public static String getSenderNameByID(int senderID) {
	    	String sql = "SELECT firstname, lastname FROM users WHERE id = ?";
	    	
	    	// Make the db connection and prepare the sql stmt
	        try (Connection connection = DriverManager.getConnection(DB_URL); PreparedStatement pstmt = connection.prepareStatement(sql)) {
	            pstmt.setInt(1, senderID);
	            ResultSet rs = pstmt.executeQuery();

	            // If a user was found with the provided id, return their first and last name
	            if (rs.next()) {
	                return rs.getString("firstName") + " " + rs.getString("lastName");
	            }
	        } catch (SQLException e) {	// PRint the error
	            System.err.println("Error fetching sender name: " + e.getMessage());
	        }
	        return "Unknown Sender";
	    }
		
		// Method to find threadID in messages database
		 private static Integer findthreadID(int senderID, int recipientID, String subject) {
		    	String sqlFindThread = "SELECT thread_id FROM msgs " +
		                "WHERE sender_id = ? AND recipient_id = ? AND subject = ? " +
		                "LIMIT 1;";
		        
		    	// Make the connection to the db and prepare the sql search
		        try (Connection connection = DriverManager.getConnection(MSG_DB_URL); PreparedStatement pstmt = connection.prepareStatement(sqlFindThread)) {
		            pstmt.setInt(1, senderID);
		            pstmt.setInt(2, recipientID);
		            pstmt.setString(3, subject);
		            
		            // Execute the sql search and assign to a result set
		            ResultSet rs = pstmt.executeQuery();
		            
		            // If a threadID was found, return that id
		            if (rs.next()) {
		                return rs.getInt("thread_id");
		            }
		        } catch (SQLException e) {	// Print any errors if they occur
		            System.err.println("Finding thread ID failed: " + e.getMessage());
		        }
		        
		        return null;
		    }
		 
		// Method to update a threadID given a messageId and a threadID - assigns a message to a specific threadID in the case of replying to a message
		    private static void updatethreadID(int messageID, int threadID) {
		        String sqlUpdate = "UPDATE msgList SET thread_id = ? WHERE id = ?;";
		        
		        // Make the connection to the db and prepare the sql search
		        try (Connection connection = DriverManager.getConnection(MSG_DB_URL); PreparedStatement pstmt = connection.prepareStatement(sqlUpdate)) {
		            pstmt.setInt(1, threadID);
		            pstmt.setInt(2, messageID);
		            pstmt.executeUpdate();
		        } catch (SQLException e) { // Print the error
		            System.err.println("Updating thread ID failed: " + e.getMessage());
		        }
		    }

		    // Method to get all the messages for a specific user
		    public static Map<Integer, List<Message>> getMessagesForUser(int userID) {
		        Map<Integer, List<Message>> threads = new HashMap<>();
		        String sql = "SELECT * FROM msgs WHERE recipient_id = ? ORDER BY timestamp DESC";

		        // Make the connection to the db and prepare the sql search
		        try (Connection connection = DriverManager.getConnection(MSG_DB_URL); PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setInt(1, userID);
		            ResultSet rs = pstmt.executeQuery();
		            
		            // Iterate through all messages and create new message objects
		            while (rs.next()) {
		                int threadID = rs.getInt("thread_id");
		                Message message = new Message(
		                    rs.getInt("id"),
		                    rs.getInt("sender_id"),
		                    rs.getInt("recipient_id"),
		                    rs.getString("subject"),
		                    rs.getString("body"),
		                    rs.getString("timestamp"),
		                    rs.getInt("thread_id")
		                    
		                );
		                
		                // If threadID isn't in the threads list, add it 
		                if (!threads.containsKey(threadID)) {
		                    threads.put(threadID, new ArrayList<>());
		                }
		                
		                threads.get(threadID).add(message);
		            }
		        } catch (SQLException e) {
		            System.err.println("Error fetching messages for user: " + e.getMessage());
		        }
		        return threads;
		    }
		    
		    // Method to delete a message thread from the db
		    public static void deleteMessageThread(int threadID) {
		        String sql = "DELETE FROM msgList WHERE thread_id = ?";
		        
		        // Make the connection to the db and prepare the sql stmt
		        try (Connection connection = DriverManager.getConnection(MSG_DB_URL); PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setInt(1, threadID);
		            
		            // Execute the sql stmt and delete the messages
		            int affectedRows = pstmt.executeUpdate();
		            
		            // If affectedRows is > 0, we have deleted the message(s)
		            if (affectedRows > 0) {
		                System.out.println("Deleted " + affectedRows + " messages from thread " + threadID);
		            } else {	//No messages deleted
		                System.out.println("No messages were deleted.");
		            }
		        } catch (SQLException e) {	// Print the error
		            System.err.println("Error deleting message thread: " + e.getMessage());
		        }
		    }
		    
		    // Method to send a message
		    public static void sendMessage(int senderID, int recipientID, String subject, String body) {
		    	// Attempt to find existing threadID in the msgList
		    	Integer threadID = findthreadID(senderID, recipientID, subject);
		        String sql = "INSERT INTO msgList (sender_id, recipient_id, subject, body, timestamp, read_status, thread_id) VALUES (?, ?, ?, ?, datetime('now'), 0, ?);";
		        
		        // Make the connection to the db and prepare sql string
		        try (Connection connection = DriverManager.getConnection(MSG_DB_URL); PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setInt(1, senderID);
		            pstmt.setInt(2, recipientID);
		            pstmt.setString(3, subject);
		            pstmt.setString(4, body);
		            
		            //TODO: may need to revise this logic since we are getting some duplicate messages in long thread chains
		            //If no threadID was found, set to null, otherwise use the found id
		            if (threadID == null) {
		            	pstmt.setNull(5, Types.INTEGER);
		            } else {
		            	pstmt.setInt(5, threadID);
		            }
		            
		            // Execute the update and assign to affectedRows, used to check if message was sent successfully
		            int affectedRows = pstmt.executeUpdate();
		            
		            // If affectedRows is 0 then we were unable to send the message
		            if (affectedRows == 0) {
		            	throw new SQLException("Sending message failed");
		            }
		            
		            // If threadID is still null at this point, then the message thread is a new message and not a reply
		            if (threadID == null) {
		            	// Get the auto generated messageId
		            	try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
		            		// For each message in the thread, update the threadID to link properly
		            		if (generatedKeys.next()) {
		            			int newMessageId = generatedKeys.getInt(1);
		            			updatethreadID(newMessageId, newMessageId);
		            		} else {
		            			throw new SQLException("Sending message failed");
		            		}
		            	}
		            }
		            
		            System.out.println("Message sent successfully.");
		        } catch (SQLException e) {	// Print error if one occurs throughout the process
		            System.err.println(e.getMessage());
		        }
		    }
		
}
