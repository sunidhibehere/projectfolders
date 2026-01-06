package com.example.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SQLServerExample {
	public static void main(String args[]) throws IOException {
		Properties props = new Properties();
		try(InputStream input = SQLServerExample.class.getClassLoader().getResourceAsStream("db.properties")){
			if(input==null) {
				System.out.println("Sorry, unable to find db.properties");
				return;
			}
			props.load(input);
			String url = props.getProperty("db.url");
			String user = props.getProperty("db.user");
			String password = props.getProperty("db.password");
			
			try(Connection conn = DriverManager.getConnection(url,user,password)){
				System.out.println("Connected to SQL Server successfully!");
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
	}
}
