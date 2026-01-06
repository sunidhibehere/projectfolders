package com.daoimplementation;

import org.springframework.stereotype.Repository;

import com.dao.CourseDAO;
import com.example.hibernatespringproblem.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseDAOImpl implements CourseDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Course course) {
        entityManager.persist(course);
    }

    public Course findById(int id) {
        return entityManager.find(Course.class, id);
    }

}
