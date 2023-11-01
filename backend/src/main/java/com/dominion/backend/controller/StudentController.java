package com.dominion.backend.controller;

import com.dominion.backend.dtos.LoginDto;
import com.dominion.backend.dtos.StudentDto;
import com.dominion.backend.model.Student;
import com.dominion.backend.service.StudentService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/register")
    public ResponseEntity<Student> createAccount(@RequestBody StudentDto studentDto){
    ResponseEntity<Student> createdStudent = studentService.createAccount(studentDto);
    return createdStudent;
    }

    @PostMapping("/login")
    public ResponseEntity<Student> login(@RequestBody LoginDto loginDto){
        Student studentLoggedIn = studentService.login(loginDto);
        if (studentLoggedIn != null) {
            return new ResponseEntity<>(studentLoggedIn, HttpStatus.OK);
        }else {
            //return invalid details exception
            return new ResponseEntity<>(studentLoggedIn, HttpStatus.UNAUTHORIZED);
        }
    }

}
