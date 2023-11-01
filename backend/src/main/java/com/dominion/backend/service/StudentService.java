package com.dominion.backend.service;

import com.dominion.backend.dtos.LoginDto;
import com.dominion.backend.dtos.StudentDto;
import com.dominion.backend.model.Student;
import org.springframework.http.ResponseEntity;

public interface StudentService {
    public ResponseEntity<Student> createAccount(StudentDto studentDto);

    public Student login(LoginDto loginDto);

    public void updateStudentDetails(StudentDto studentDto, String matricNo);

}

