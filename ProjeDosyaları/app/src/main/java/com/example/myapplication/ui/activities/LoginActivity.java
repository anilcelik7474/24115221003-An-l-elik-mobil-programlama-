package com.example.myapplication.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.clients.StudentClient;
import com.example.myapplication.model.Student;
import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity {

    private StudentClient studentClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        studentClient = new StudentClient();

        EditText studentNumberInput = findViewById(R.id.studentNumberInput);
        EditText passwordInput = findViewById(R.id.passwordInput);
        MaterialButton loginButton = findViewById(R.id.loginButton);

        Student demoStudent = studentClient.getDemoStudent();
        studentNumberInput.setText(demoStudent.getStudentNumber());
        passwordInput.setText(demoStudent.getPassword());

        loginButton.setOnClickListener(view -> attemptLogin(studentNumberInput, passwordInput));
    }

    private void attemptLogin(EditText studentNumberInput, EditText passwordInput) {
        String studentNumber = studentNumberInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        if (TextUtils.isEmpty(studentNumber) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, R.string.missing_credentials, Toast.LENGTH_SHORT).show();
            return;
        }

        Student student = studentClient.login(studentNumber, password);
        if (student == null) {
            Toast.makeText(this, R.string.invalid_login, Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, StudentHomeActivity.class);
        intent.putExtra(StudentHomeActivity.EXTRA_FULL_NAME, student.getFullName());
        intent.putExtra(StudentHomeActivity.EXTRA_STUDENT_NUMBER, student.getStudentNumber());
        startActivity(intent);
        finish();
    }
}