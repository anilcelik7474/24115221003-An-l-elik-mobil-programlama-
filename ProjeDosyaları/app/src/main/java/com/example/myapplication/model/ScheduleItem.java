package com.example.myapplication.model;

public class ScheduleItem {
    private final String day;
    private final String time;
    private final String courseName;
    private final String classroom;

    public ScheduleItem(String day, String time, String courseName, String classroom) {
        this.day = day;
        this.time = time;
        this.courseName = courseName;
        this.classroom = classroom;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getClassroom() {
        return classroom;
    }
}