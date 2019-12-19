package com.company.studentservice.service;

import com.company.studentservice.model.StudentViewModel;
import com.company.studentservice.util.feign.StudentFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceLayer {

    @Autowired
    StudentFeignClient studentFeignClient;

    public StudentViewModel saveStudent(StudentViewModel studentViewModel) {
        return studentFeignClient.saveStudent(studentViewModel);
    }

    public StudentViewModel getStudent(int id) {
        return studentFeignClient.getStudent(id);
    }

}
