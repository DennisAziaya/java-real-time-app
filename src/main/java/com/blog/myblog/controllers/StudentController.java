package com.blog.myblog.controllers;

import com.blog.myblog.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/students")
public class StudentController {

    @GetMapping
    public List<Student>  getAllStudent(){
        return List.of(
            new Student(UUID.randomUUID(), "Dennis", "Aziaya", "aziayadennis@gmail.com", Student.Gender.MALE ),
            new Student(UUID.randomUUID(), "Carol", "Aziaya", "carol@gmail.com", Student.Gender.FEMALE)
        );
    }


}
