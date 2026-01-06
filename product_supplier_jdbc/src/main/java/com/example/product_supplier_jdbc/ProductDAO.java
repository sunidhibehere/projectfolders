package com.example.product_supplier_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;


public class ProductDAO {
	public long insertProduct(String name, BigDecimal price, long supplierId) throws SQLException{
		String sql="INSERT INTO products(productName,price,supplier_id) VALUES (?,?,?)";
		try(Connection connection = DatabaseManager.getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
				
				stmt.setString(1, name);
				stmt.setBigDecimal(2, price);
				stmt.setLong(3, supplierId);
				stmt.executeUpdate();
				
				try(ResultSet keys=stmt.getGeneratedKeys()){
					if(keys.next()) {
						return keys.getLong(1);
					}
					throw new SQLException("No generated key returned for product insertion");
				}
		}	
	}
	
	public Optional<Product> findById(long productId) throws SQLException{
		String sql="SELECT product_id,product_name,price,supplier_id FROM products WHERE product_id=?";
		try(Connection connection = DatabaseManager.getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setLong(1, productId);
			try(ResultSet rs=stmt.executeQuery()){
				if(rs.next()) {
					return Optional.of(mapRow(rs));
				}
				return Optional.empty();
			}
		}
	}
	
	public List<Product> findBySupplier(long supplierId) throws SQLException{
		String sql="SELECT product_id,product_name,price,supplier_id FROM products WHERE supplier_id=?";
		try(Connection connection = DatabaseManager.getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setLong(1, supplierId);
			try(ResultSet rs=stmt.executeQuery()){
				List<Product> products = new ArrayList<>();
				while(rs.next()) {
					products.add(mapRow(rs));
				}
				return products;
			}
		}
	}
		
	public int updatePrice(long productId,BigDecimal newPrice) throws SQLException{
		String sql="UPDATE products SET price = ? where product_id = ?";
		try(Connection connection = DatabaseManager.getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setBigDecimal(1, newPrice);
			stmt.setLong(2, productId);
			return stmt.executeUpdate();
		}
	}
	 public int deleteById(long productId) throws SQLException {
	        String sql = "DELETE FROM products WHERE product_id = ?";
	        try (Connection connection = DatabaseManager.getConnection();
	             PreparedStatement statement = connection.prepareStatement(sql)) {
	            // Direct delete of a single product.
	            statement.setLong(1, productId);
	            return statement.executeUpdate();
	        }
	    }

	    private Product mapRow(ResultSet rs) throws SQLException {
	        long id = rs.getLong("product_id");
	        String name = rs.getString("product_name");
	        BigDecimal price = rs.getBigDecimal("price");
	        long supplierId = rs.getLong("supplier_id");
	        return new Product(id, name, price, supplierId);
	    }
}
