package com.example.myapplication.clients;

import com.example.myapplication.model.Student;

public class StudentClient {
    private static final Student DEMO_STUDENT = new Student("Anıl Çelik", "2024001", "ruhi123");

    public Student login(String studentNumber, String password) {
        if (DEMO_STUDENT.getStudentNumber().equals(studentNumber)
                && DEMO_STUDENT.getPassword().equals(password)) {
            return DEMO_STUDENT;
        }
        return null;
    }

    public Student getDemoStudent() {
        return DEMO_STUDENT;
    }
}