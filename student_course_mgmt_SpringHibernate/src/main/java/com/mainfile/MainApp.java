package com.mainfile;

import com.example.hibernatespringproblem.Course;
import com.example.hibernatespringproblem.Student;
import com.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        StudentService service = context.getBean(StudentService.class);

        Course spring = new Course();
        spring.setTitle("Spring");
        spring.setCredits(5);

        Student s = new Student();
        s.setName("Alice");
        s.setEmail("alice@gmail.com");
        s.setEnrollmentDate("2025-01-01");

        s.getCourses().add(spring);
        spring.getStudents().add(s);

        service.registerStudent(s);

        // Cascade removes enrollments
        service.deleteStudent(1);
    }
}
