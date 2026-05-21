package com.example.myapplication.model;

public class ExamResult {
    private final String examDate;
    private final String courseName;
    private final String result;

    public ExamResult(String examDate, String courseName, String result) {
        this.examDate = examDate;
        this.courseName = courseName;
        this.result = result;
    }

    public String getExamDate() {
        return examDate;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getResult() {
        return result;
    }
}