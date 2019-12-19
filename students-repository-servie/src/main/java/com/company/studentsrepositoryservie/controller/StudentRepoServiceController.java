package com.company.studentsrepositoryservie.controller;

import com.company.studentsrepositoryservie.service.ServiceLayer;
import com.company.studentsrepositoryservie.viewmodel.StudentViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentRepoServiceController {

    @Autowired
    ServiceLayer service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentViewModel saveStudent(@RequestBody StudentViewModel studentViewModel) {
        return service.saveStudent(studentViewModel);
    }

    @GetMapping("/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentViewModel getStudent(@PathVariable("student-id") int studentId) {
        return service.findStudent(studentId);
    }


}
