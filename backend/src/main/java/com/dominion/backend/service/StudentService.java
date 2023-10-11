package com.dominion.backend.service;

import com.dominion.backend.model.Student;

import java.util.Optional;

public interface StudentService {
    public String createAccount(Student student);

    public Student login(String matricNo, String password);

    public void updateStudentDetails(Student student, Long id);

}

