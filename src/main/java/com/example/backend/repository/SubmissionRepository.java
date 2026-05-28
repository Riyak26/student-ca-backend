package com.example.backend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backend.model.Submission;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
    List<Submission> findBySubjectName(String subjectName);
    List<Submission> findByStatus(String status);
    List<Submission> findByRollNo(String rollNo);
}