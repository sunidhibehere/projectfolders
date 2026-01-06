package com.example.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
	//To add employees to employee table
    public void addEmployee(int empId, String empName, String designation) {
        String query = "INSERT INTO Employee (empId, empName, designation) VALUES (?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Set the parameters for the PreparedStatement
            stmt.setInt(1, empId);
            stmt.setString(2, empName);
            stmt.setString(3, designation);

            // Execute the query
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Employee added, rows affected: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

 // Update Employee
    public void updateEmployee(int empId, String empName, String designation) {
        String query = "UPDATE Employee SET empName = ?, designation = ? WHERE empId = ?";
        
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, empName);
            stmt.setString(2, designation);
            stmt.setInt(3, empId);
            
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Employee updated, rows affected: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Find Employee by ID
    public void findEmployeeById(int empId) {
        String query = "SELECT * FROM Employee WHERE empId = ?";
        
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, empId);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                System.out.println("Employee ID: " + rs.getInt("empId"));
                System.out.println("Name: " + rs.getString("empName"));
                System.out.println("Designation: " + rs.getString("designation"));
            } else {
                System.out.println("Employee not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
 // Delete Employee
    public void deleteEmployee(int empId) {
        String query = "DELETE FROM Employee WHERE empId = ?";
        
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, empId);
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Employee deleted, rows affected: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        // Method to display all employees
        public void displayAllEmployees() {
            String query = "SELECT * FROM Employee";
            
            try (Connection conn = DBUtil.getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                // Loop through the result set and display employee details
                while (rs.next()) {
                    int empId = rs.getInt("empId");
                    String name = rs.getString("empName");
                    String designation = rs.getString("designation");
                    
                    System.out.println("Employee ID: " + empId);
                    System.out.println("Name: " + name);
                    System.out.println("Designation: " + designation);
                    System.out.println("------------------------------");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        
    }

  //Assigning project to employees
        public void assignEmployeeToProject(int empId, int projectId) throws SQLException {
            String sql = "INSERT INTO assignments (empId, projectId) VALUES (?, ?)";
            try (Connection con = DBUtil.getConnection();  // Use your DB utility to get a connection
                 PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, empId);        // Set the employee ID
                ps.setInt(2, projectId);    // Set the project ID
                ps.executeUpdate();         // Execute the update to assign the employee to the project
            }
        }

}
