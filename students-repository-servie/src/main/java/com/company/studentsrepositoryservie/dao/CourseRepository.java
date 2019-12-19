package com.company.studentsrepositoryservie.dao;


import com.company.studentsrepositoryservie.model.Course;
import com.company.studentsrepositoryservie.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    public List<Course> findCoursesByStudentId(int studentId);

}
