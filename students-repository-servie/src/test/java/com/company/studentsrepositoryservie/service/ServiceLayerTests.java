package com.company.studentsrepositoryservie.service;

import com.company.studentsrepositoryservie.dao.CourseRepository;
import com.company.studentsrepositoryservie.dao.StudentRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ServiceLayerTests {

    @Mock
    StudentRepository studentRepo;

    @Mock
    CourseRepository courseRepository;

    ServiceLayer service;

    @Before
    public void setUp() {

    }

}
