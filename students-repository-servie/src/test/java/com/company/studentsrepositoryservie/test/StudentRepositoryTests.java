package com.company.studentsrepositoryservie.test;


import com.company.studentsrepositoryservie.dao.StudentRepository;
import com.company.studentsrepositoryservie.model.Student;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTests {

    @Autowired
    StudentRepository studentRepo;

    private Student student;

    @Before
    public void setUp() {
        studentRepo.findAll().forEach(student1 -> studentRepo.deleteById(student1.getStudentId()));
        student = new Student();
        student.setFirstName("harsh");
        student.setLastName("patel");
    }

    @Test
    public void shouldAddGetAndDeleteStudent() {
        student = studentRepo.save(student);
        Student studentFromDb = studentRepo.findById(student.getStudentId()).orElse(null);
        assertEquals(student, studentFromDb);

//        delete student from db
        studentRepo.deleteById(student.getStudentId());

        assertNull(studentRepo.findById(student.getStudentId()).orElse(null));

    }

    @Test
    public void shouldGetAllStudents() {
        student = studentRepo.save(student);
        List<Student> students = new ArrayList<>(Collections.singletonList(student));

        assertEquals(students, studentRepo.findAll());
    }

    @Test
    public void shouldUpdateStudent() {
        student = studentRepo.save(student);
        student.setFirstName("soumya");
        student = studentRepo.save(student);

        assertEquals(student, studentRepo.findById(student.getStudentId()).orElse(null));
    }


}
