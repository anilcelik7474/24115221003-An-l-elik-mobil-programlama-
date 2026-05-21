package com.example.myapplication.model;

public class Student {
    private final String fullName;
    private final String studentNumber;
    private final String password;

    public Student(String fullName, String studentNumber, String password) {
        this.fullName = fullName;
        this.studentNumber = studentNumber;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getPassword() {
        return password;
    }
}