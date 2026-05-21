package com.example.myapplication.model;

public class StudentSummary {
    private final String gpa;
    private final String completedEcts;
    private final String attendanceRate;

    public StudentSummary(String gpa, String completedEcts, String attendanceRate) {
        this.gpa = gpa;
        this.completedEcts = completedEcts;
        this.attendanceRate = attendanceRate;
    }

    public String getGpa() {
        return gpa;
    }

    public String getCompletedEcts() {
        return completedEcts;
    }

    public String getAttendanceRate() {
        return attendanceRate;
    }
}