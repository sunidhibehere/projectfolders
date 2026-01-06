package com.dao;

import java.util.List;
import com.example.hibernatespringproblem.Student;

public interface StudentDAO {
    void save(Student student);
    Student findById(int id);
    List<Student> findAll();
    void delete(int id);
}
