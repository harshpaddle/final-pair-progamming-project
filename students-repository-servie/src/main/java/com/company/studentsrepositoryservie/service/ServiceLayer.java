package com.company.studentsrepositoryservie.service;

import com.company.studentsrepositoryservie.dao.CourseRepository;
import com.company.studentsrepositoryservie.dao.StudentRepository;
import com.company.studentsrepositoryservie.exception.NotFoundException;
import com.company.studentsrepositoryservie.model.Course;
import com.company.studentsrepositoryservie.model.Student;
import com.company.studentsrepositoryservie.viewmodel.StudentViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceLayer {

    private StudentRepository studentRepo;
    private CourseRepository courseRepo;

    @Autowired
    ServiceLayer(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepo = studentRepository;
        this.courseRepo = courseRepository;
    }

    public StudentViewModel saveStudent(StudentViewModel studentViewModel) {
        Student student = new Student();
        student.setFirstName(studentViewModel.getFirstName());
        student.setLastName(studentViewModel.getLastName());

        student = studentRepo.save(student);

        List<Course> courseList = studentViewModel.getCourses();
        if (courseList.size() != 0) {
            for (Course course : courseList) {
                course.setStudentId(student.getStudentId());
                courseRepo.save(course);
            }
        }
        return buildStudentViewModel(student);
    }


    public StudentViewModel findStudent(int id) {
        if (studentRepo.findById(id) == null) {
            throw new NotFoundException("no student in db with that student id");
        }
        return buildStudentViewModel(studentRepo.findById(id).orElse(null));
    }



//    public List<Course> getCoursesByStudentId(int id) {
//
//    }

    public StudentViewModel buildStudentViewModel(Student student) {
        List<Course> courseList = courseRepo.findCoursesByStudentId(student.getStudentId());
        StudentViewModel studentViewModel = new StudentViewModel();
        studentViewModel.setFirstName(student.getFirstName());
        studentViewModel.setLastName(student.getLastName());
        studentViewModel.setCourses(courseList);

        return studentViewModel;
    }

}
