package com.daoimplementation;


import com.dao.StudentDAO;
import com.example.hibernatespringproblem.Student;

import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class StudentDAOImpl implements StudentDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Student student) {
        entityManager.persist(student);
    }

    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    public List<Student> findAll() {
        return entityManager
                .createQuery("FROM Student", Student.class)
                .getResultList();
    }

    public void delete(int id) {
        Student student = findById(id);
        if (student != null) {
            entityManager.remove(student);
        }
    }
}
