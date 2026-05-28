package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.backend.entity.Student;
import com.example.backend.repository.StudentRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository repo;

    @GetMapping
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return repo.save(student);
    }
}
