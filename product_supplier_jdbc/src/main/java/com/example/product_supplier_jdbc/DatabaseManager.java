package com.example.product_supplier_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
	
	private static final String JDBC_URL = "jdbc:h2:~/data/product-supplier-db";
	private static final String USER = "root";
	private static final String PASSWORD = "Ad123#";
	
	private DatabaseManager() {}
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(JDBC_URL,USER,PASSWORD);
	}
	
	//Creating tables suppliers and products
	//Using supplier_id as foreign key in products table/
	//ON DELETE CASCADE used to remove all products if supplier is removed
	public static void initializeSchema() throws SQLException{
		try(Connection conn = getConnection();Statement stmt = conn.createStatement()){
			stmt.execute("""
					CREATE TABLE IF NOT EXISTS suppliers(
						supplier_id IDENTITY PRIMARY KEY,
						supplier_name VARCHAR(255) NOT NULL,
						contact_info VARCHAR(255)
					);					
					""");
			
			stmt.execute("""
					CREATE TABLE IF NOT EXISTS products(
					    product_id IDENTITY PRIMARY KEY,
					    product_name VARCHAR(255) NOT NULL,
					    price DECIMAL(10,2) NOT NULL,
					    supplier_id BIGINT NOT NULL,
					    CONSTRAINT supplier_foreignkey FOREIGN KEY(supplier_id) REFERENCES 
					    suppliers(supplier_id) ON DELETE CASCADE
 					);					
					""");
		}
		
	}
}
