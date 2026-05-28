package com.example.backend.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.backend.model.Submission;
import com.example.backend.repository.SubmissionRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/submissions")
public class SubmissionController {

    @Autowired
    private SubmissionRepository repo;

    // UPLOAD PDF
    @PostMapping("/upload")
    public Submission uploadSubmission(
            @RequestParam("studentName") String studentName,
            @RequestParam("rollNo") String rollNo,
            @RequestParam("subjectName") String subjectName,
            @RequestParam("caType") String caType,
            @RequestParam("file") MultipartFile file
    ) throws IOException {

        String uploadDir = System.getProperty("user.dir") + "/uploads/";

        File dir = new File(uploadDir);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        String fileName =
                System.currentTimeMillis() + "_" +
                file.getOriginalFilename();

        file.transferTo(new File(uploadDir + fileName));

        Submission s = new Submission();

        s.setStudentName(studentName);
        s.setRollNo(rollNo);
        s.setSubjectName(subjectName);
        s.setCaType(caType);
        s.setPdfName(fileName);
        s.setStatus("Pending");

        return repo.save(s);
    }

    // GET ALL
    @GetMapping
    public List<Submission> getAll() {

        return repo.findAll();
    }

    // FILTER SUBJECT
    @GetMapping("/subject/{subjectName}")
    public List<Submission> getBySubject(
            @PathVariable String subjectName
    ) {

        return repo.findBySubjectName(subjectName);
    }

    // UPDATE MARKS
    @PutMapping("/marks/{id}")
    public Submission updateMarks(
            @PathVariable Long id,
            @RequestParam Integer marks
    ) {

        Submission s =
                repo.findById(id).orElseThrow();

        s.setMarks(marks);
        s.setStatus("Evaluated");

        return repo.save(s);
    }

    // STUDENT SUBMISSIONS
    @GetMapping("/student/{rollNo}")
    public List<Submission> getStudentSubmissions(
            @PathVariable String rollNo
    ) {

        return repo.findByRollNo(rollNo);
    }

    // MARKSHEET
    @GetMapping("/marksheet")
    public List<Submission> marksheet() {

        return repo.findByStatus("Evaluated");
    }
}