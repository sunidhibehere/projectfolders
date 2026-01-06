package com.dao;

import com.example.hibernatespringproblem.Course;

public interface CourseDAO {
    void save(Course course);
    Course findById(int id);
}
