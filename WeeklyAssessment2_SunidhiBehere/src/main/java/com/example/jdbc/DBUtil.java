package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
		private static final String DRIVER ="com.mysql.cj.jdbc.Driver";
	    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
	    private static final String USER = "root";
	    private static final String PASS = "Root123$";

	    //Using static to ensure jdbc driver is loaded once
	    static {
	    try{ 	
	    	Class.forName(DRIVER);//Load the Driver
	    }
	    catch(ClassNotFoundException e){
	    	throw new RuntimeException("Failed to load JDBC driver: "+ DRIVER, e);
	    }
	    }
	    
	    //Establishing the connection to DB
	    public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(URL, USER, PASS);
	    }
	    
	    
}
