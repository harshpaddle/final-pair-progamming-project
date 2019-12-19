package com.company.studentsrepositoryservie.test;

import com.company.studentsrepositoryservie.dao.CourseRepository;
import com.company.studentsrepositoryservie.dao.StudentRepository;
import com.company.studentsrepositoryservie.model.Course;
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
public class CourseRepositoryTests {

    @Autowired
    CourseRepository courseRepo;

    @Autowired
    StudentRepository studentRepo;

    private Student student;

    private Course course;

    @Before
    public void setUp() {
        studentRepo.findAll().forEach(student1 -> studentRepo.deleteById(student1.getStudentId()));
        courseRepo.findAll().forEach(course1 -> courseRepo.deleteById(course1.getStudentId()));

        student = new Student();
        student.setFirstName("harsh");
        student.setLastName("patel");

        course = new Course();
        course.setName("biology");
        course.setScore(80);
    }

    @Test
    public void shouldAddGetAndDeleteCourse() {
        student = studentRepo.save(student);
        course.setStudentId(student.getStudentId());
        course = courseRepo.save(course);

        assertEquals(course, courseRepo.findById(course.getId()).orElse(null));

        courseRepo.deleteById(course.getId());

        assertNull(courseRepo.findById(course.getId()).orElse(null));
    }

    @Test
    public void shouldGetAllCoursesByStudent() {
        student = studentRepo.save(student);
        course.setStudentId(student.getStudentId());
        course = courseRepo.save(course);

        List<Course> studentCourses = new ArrayList<>(Collections.singletonList(course));

        assertEquals(studentCourses, courseRepo.findCoursesByStudentId(student.getStudentId()));
    }

    @Test
    public void shouldGetAllCourses() {
        student = studentRepo.save(student);
        course.setStudentId(student.getStudentId());
        course = courseRepo.save(course);

        List<Course> studentCourses = new ArrayList<>(Collections.singletonList(course));

        assertEquals(studentCourses, courseRepo.findAll());
    }
}
