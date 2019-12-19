package com.company.studentservice.util.feign;

import com.company.studentservice.model.StudentViewModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("student-repository-service")
public interface StudentFeignClient {

    @PostMapping("/students")
    public StudentViewModel saveStudent(@RequestBody StudentViewModel studentViewModel);

    @GetMapping("/students/{student-id}")
    public StudentViewModel getStudent(@PathVariable("student-id") int id);
}
