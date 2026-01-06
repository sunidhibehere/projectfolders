package com.example.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAO {
	
	//List all projects
    public List<Project> getAllProjects() throws SQLException {
        List<Project> list = new ArrayList<>();
        String sql = "SELECT * FROM Project";
        try (Connection con = DBUtil.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Project proj = new Project();
                proj.setProjectId(rs.getInt("projectId"));
                proj.setProjectName(rs.getString("projectName"));
                proj.setDeadline(rs.getDate("deadline"));
                list.add(proj);
            }
        }
        return list;
    }
    
    //Add project
    public void addProject(int projectId, String projectName, Date deadline) {
        String query = "INSERT INTO Project (projectId, projectName, deadline) VALUES (?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, projectId);
            stmt.setString(2, projectName);
            stmt.setDate(3, deadline);

            int rowsAffected = stmt.executeUpdate();
            System.out.println("Project added, rows affected: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
 // Update Project
    public void updateProject(int projectId, String projectName, Date deadline) {
        String query = "UPDATE Project SET projectName = ?, deadline = ? WHERE projectId = ?";
        
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, projectName);
            stmt.setDate(2, deadline);
            stmt.setInt(3, projectId);
            
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Project updated, rows affected: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

 // Delete Project
    public void deleteProject(int projectId) {
        String query = "DELETE FROM Project WHERE projectId = ?";
        
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, projectId);
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Project deleted, rows affected: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        
 // Find Project by ID
    public void findProjectById(int projectId) {
        String query = "SELECT * FROM Project WHERE projectId = ?";
        
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, projectId);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                System.out.println("Project ID: " + rs.getInt("projectId"));
                System.out.println("Project Name: " + rs.getString("projectName"));
                System.out.println("Deadline: " + rs.getDate("deadline"));
            } else {
                System.out.println("Project not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        
    // Method to display all projects
        public void displayAllProjects() {
            String query = "SELECT * FROM Project";
            
            try (Connection conn = DBUtil.getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                // Loop through the result set and display project details
                while (rs.next()) {
                    int projectId = rs.getInt("projectId");
                    String projectName = rs.getString("projectName");
                    Date deadline = rs.getDate("deadline");
                    
                    System.out.println("Project ID: " + projectId);
                    System.out.println("Project Name: " + projectName);
                    System.out.println("Deadline: " + deadline);
                    System.out.println("------------------------------");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

