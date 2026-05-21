package com.example.myapplication.model;

public class CourseResult {
    private final String courseName;
    private final int midtermScore;
    private final int finalScore;
    private final int ects;
    private final String absence;
    private final String status;

    public CourseResult(String courseName, int midtermScore, int finalScore, int ects, String absence, String status) {
        this.courseName = courseName;
        this.midtermScore = midtermScore;
        this.finalScore = finalScore;
        this.ects = ects;
        this.absence = absence;
        this.status = status;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getMidtermScore() {
        return midtermScore;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public int getEcts() {
        return ects;
    }

    public String getAbsence() {
        return absence;
    }

    public String getStatus() {
        return status;
    }
}