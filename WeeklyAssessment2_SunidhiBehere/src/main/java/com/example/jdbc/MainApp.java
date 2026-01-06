package com.example.jdbc;

import java.sql.Date;
import java.sql.SQLException;

public class MainApp {
    public static void main(String[] args) {
    	     
        EmployeeDAO employeeDAO = new EmployeeDAO();
        ProjectDAO projectDAO = new ProjectDAO();
        

        // Adding Employees
        employeeDAO.addEmployee(2111, "Sunidhi Behere", "Developer");
        employeeDAO.addEmployee(2112, "Aditi Mishra", "Team Lead");
        employeeDAO.addEmployee(2113, "Aastha Nayak", "Project Manager");

        
        // Adding Projects
        projectDAO.addProject(100010, "Project A", Date.valueOf("2025-12-25"));
        projectDAO.addProject(100020, "Project B", Date.valueOf("2026-06-30"));
        projectDAO.addProject(100030, "Project B", Date.valueOf("2026-05-12"));

        // Find Employee by ID
        employeeDAO.findEmployeeById(2113);
        
        // Find Project by ID
        projectDAO.findProjectById(100010);

        // Update Employee
        employeeDAO.updateEmployee(2111, "Sunidhi Behere", "Senior Software Developer");

        // Update Project
        projectDAO.updateProject(100010, "Project A", Date.valueOf("2026-05-15"));

        // Delete Employee
        employeeDAO.deleteEmployee(2111);

        // Delete Project
        projectDAO.deleteProject(100010);
        
      //To see employee details
        employeeDAO.displayAllEmployees();
        
      //To see project details
      projectDAO.displayAllProjects();
        
    }
}
