package com.mypackage;
import java.sql.*;

public class JDBCExample {
	public static void main(String args[]) {
		try {
			//Load H2 driver
			Class.forName("org.h2.Driver");
			
			//Connect to H2 file based database in your home directory
			//URL, username, password
			Connection conn = DriverManager.getConnection("jdbc:h2:~/test","sa","");
			
			//create a table
			Statement stmt = conn.createStatement();
			stmt.execute("CREATE TABLE IF NOT EXISTS users(id INT PRIMARY KEY,name VARCHAR)");
			
			//insert data
			int rows = stmt.executeUpdate("INSERT INTO users VALUES(11,'Sunidhi')");
			System.out.println("Rows affected:"+rows);
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
