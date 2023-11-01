package com.dominion.backend.service.Impl;

import com.dominion.backend.dtos.LoginDto;
import com.dominion.backend.dtos.StudentDto;
import com.dominion.backend.exceptions.PasswordMismatchEception;
import com.dominion.backend.exceptions.UserAlreadyExistsException;
import com.dominion.backend.exceptions.UserException;
import com.dominion.backend.model.Student;
import com.dominion.backend.repository.StudentRepository;
import com.dominion.backend.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    private static Student getStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setMiddleName(studentDto.getMiddleName());
        student.setLastName(studentDto.getLastName());
        student.setBirthDate(studentDto.getBirthDate());
        student.setCourse(studentDto.getCourse());
        student.setGraduationYear(studentDto.getGraduationYear());
        student.setMatricNo(studentDto.getMatricNo());
        student.setPassword(studentDto.getPassword());
        student.setPicture(studentDto.getPicture());
        return student;
    }

    @Override
    public ResponseEntity<Student> createAccount(StudentDto studentDto) throws UserException {

        Student student = getStudent(studentDto);
        //check if student already exists using matric number

        Optional<Student> studentOptional = Optional.ofNullable(studentRepository.findByMatricNo(studentDto.getMatricNo()));
            if (studentOptional.isPresent()) {
                studentRepository.save(student);
                return new ResponseEntity<>(student, HttpStatus.CREATED);
            } else {
                throw new UserAlreadyExistsException("Matric Number Already Exists", HttpStatus.BAD_REQUEST);
            }

    }




    @Override
    public Student login(LoginDto loginDto) throws PasswordMismatchEception {
        Student student = new Student();
        Student studentLogin = studentRepository.findByMatricNo(loginDto.getMatricNo());
        if(studentLogin != null && studentLogin.getPassword().equals(loginDto.getPassword())){
            return student;
        }else{
            throw new PasswordMismatchEception("Incorrect Password", HttpStatus.CONFLICT);//throw login details mismatched exception
        }
    }

    @Override
    public void updateStudentDetails(StudentDto studentDto, String matricNo) {
        Student student = getStudent(studentDto);
        //check if matric number already exists in the database;
        Optional<Student> studentOptional = Optional.ofNullable(studentRepository.findByMatricNo(matricNo));

        if(studentOptional.isPresent()){
            Student studentToBeUpdated = studentOptional.get();

            studentToBeUpdated.setFirstName(studentDto.getFirstName());
            studentToBeUpdated.setMiddleName(studentDto.getMiddleName());
            studentToBeUpdated.setLastName(studentDto.getLastName());
            studentToBeUpdated.setBirthDate(studentDto.getBirthDate());
            studentToBeUpdated.setCourse(studentDto.getCourse());
            studentToBeUpdated.setGraduationYear(studentDto.getGraduationYear());
            studentToBeUpdated.setMatricNo(studentDto.getMatricNo());
            studentToBeUpdated.setPassword(studentDto.getPassword());
            studentToBeUpdated.setPicture(studentDto.getPicture());

            studentRepository.save(student);
        }
    }



}
