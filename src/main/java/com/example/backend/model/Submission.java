package com.example.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "submissions")
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentName;
    private String rollNo;
    private String subjectName;
    private String caType;
    private String pdfName;

    private Integer marks;
    private String status;

    public Submission() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getRollNo() { return rollNo; }
    public void setRollNo(String rollNo) { this.rollNo = rollNo; }

    public String getSubjectName() { return subjectName; }
    public void setSubjectName(String subjectName) { this.subjectName = subjectName; }

    public String getCaType() { return caType; }
    public void setCaType(String caType) { this.caType = caType; }

    public String getPdfName() { return pdfName; }
    public void setPdfName(String pdfName) { this.pdfName = pdfName; }

    public Integer getMarks() { return marks; }
    public void setMarks(Integer marks) { this.marks = marks; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}