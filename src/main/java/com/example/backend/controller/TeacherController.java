package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.backend.model.Teacher;
import com.example.backend.repository.TeacherRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherRepository repo;

    @GetMapping
    public List<Teacher> getAllTeachers() {

        return repo.findAll();
    }

    @PostMapping
    public Teacher addTeacher(
            @RequestBody Teacher teacher) {

        return repo.save(teacher);
    }
}