package com.dominion.backend.service.Impl;

import com.dominion.backend.model.Student;
import com.dominion.backend.repository.StudentRepository;
import com.dominion.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public String createAccount(Student student) {
        String message = "Account successfully created";
        studentRepository.save(student);
        return message;
    }

    @Override
    public Student login(String matricNo, String password) {
        Student studentLogin = studentRepository.findByMatric(matricNo);
        if(studentLogin == null && studentLogin.getPassword().equals(password)){
            return studentLogin;
        }else{
            return null;//throw login details mismatched exception
        }


    }

    @Override
    public void updateStudentDetails(Student student, Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()){
            Student studentToBeUpdated = studentOptional.get();
            studentToBeUpdated.setFirstName(studentToBeUpdated.getFirstName());
            studentToBeUpdated.setMiddleName(studentToBeUpdated.getMiddleName());
            studentToBeUpdated.setLastName(studentToBeUpdated.getLastName());
            studentToBeUpdated.setBirthDate(studentToBeUpdated.getBirthDate());
            studentToBeUpdated.setCourse(studentToBeUpdated.getCourse());
            studentToBeUpdated.setGraduationYear(studentToBeUpdated.getGraduationYear());
            studentToBeUpdated.setMatricNo(studentToBeUpdated.getMatricNo());
            studentToBeUpdated.setPassword(studentToBeUpdated.getPassword());
            studentToBeUpdated.setPicture(studentToBeUpdated.getPicture());
            studentRepository.save(studentToBeUpdated);
        }
    }
}
