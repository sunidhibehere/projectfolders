package com.example.product_supplier_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SupplierDAO {
	public long insertSupplier(String name, String contactInfo) throws SQLException {
        String sql = "INSERT INTO suppliers (supplier_name, contact_info) VALUES (?, ?)";
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // Bind parameters in a predictable order to avoid SQL injection and keep logs readable.
            statement.setString(1, name);
            statement.setString(2, contactInfo);
            statement.executeUpdate();

            try (ResultSet keys = statement.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getLong(1);
                }
                throw new SQLException("No generated key returned for supplier insert");
            }
        }
    }

    public Optional<Supplier> findById(long supplierId) throws SQLException {
        String sql = "SELECT supplier_id, supplier_name, contact_info FROM suppliers WHERE supplier_id = ?";
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            // Narrow lookup to a single id to keep the result set tiny.
            statement.setLong(1, supplierId);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapRow(rs));
                }
                return Optional.empty();
            }
        }
    }

    public List<Supplier> findAll() throws SQLException {
        String sql = "SELECT supplier_id, supplier_name, contact_info FROM suppliers";
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {
            List<Supplier> results = new ArrayList<>();
            while (rs.next()) {
                results.add(mapRow(rs));
            }
            return results;
        }
    }

    public int updateSupplier(long supplierId, String newName, String newContact) throws SQLException {
        String sql = "UPDATE suppliers SET supplier_name = ?, contact_info = ? WHERE supplier_id = ?";
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            // Update both columns in one round trip.
            statement.setString(1, newName);
            statement.setString(2, newContact);
            statement.setLong(3, supplierId);
            return statement.executeUpdate();
        }
    }

    /**
     *  * With ON DELETE CASCADE, this also deletes the supplier's products.
     */
    public int deleteSupplier(long supplierId) throws SQLException {
        String sql = "DELETE FROM suppliers WHERE supplier_id = ?";
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            // With ON DELETE CASCADE this also removes child products.
            statement.setLong(1, supplierId);
            return statement.executeUpdate();
        }
    }

    private Supplier mapRow(ResultSet rs) throws SQLException {
        long id = rs.getLong("supplier_id");
        String name = rs.getString("supplier_name");
        String contact = rs.getString("contact_info");
        return new Supplier(id, name, contact);
    }
  
}
