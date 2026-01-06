package com.example.jdbc;

import java.sql.Date;

public class Project {
	private int projectId;
    private String projectName;
    private Date deadline;

    // Getters & Setters
	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	
	  @Override
	    public String toString() {
	        return "Project{" +
	                "projectId=" + projectId +
	                ", projectName='" + projectName + '\'' +
	                ", deadline=" + deadline +
	                '}';
	    }
}
