package com.example.myapplication.model;

public class AttendanceRecord {
    private final String courseName;
    private final String missedDays;
    private final int dayCount;

    public AttendanceRecord(String courseName, String missedDays, int dayCount) {
        this.courseName = courseName;
        this.missedDays = missedDays;
        this.dayCount = dayCount;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getMissedDays() {
        return missedDays;
    }

    public int getDayCount() {
        return dayCount;
    }
}