package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.StudentDAO;
import com.example.hibernatespringproblem.Student;

@Service
public class StudentService {

    @Autowired
    private StudentDAO studentDAO;

    public void registerStudent(Student student) {
        studentDAO.save(student);
    }

    public void deleteStudent(int id) {
        studentDAO.delete(id);
    }
}
