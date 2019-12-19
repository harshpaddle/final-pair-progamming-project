package com.company.studentservice.controller;

import com.company.studentservice.model.StudentViewModel;
import com.company.studentservice.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentServiceController {

    @Autowired
    ServiceLayer service;

    @PostMapping("/students")
    public StudentViewModel saveStudent(@RequestBody StudentViewModel studentViewModel) {
        return service.saveStudent(studentViewModel);
    }

    @GetMapping("/students/{studentID")
    public StudentViewModel getStudent(@PathVariable("studentID") int id) {
        return service.getStudent(id);
    }
}
