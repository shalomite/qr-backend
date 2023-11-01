package com.dominion.backend.security;

import com.dominion.backend.exceptions.UserNotFoundException;
import com.dominion.backend.model.Student;
import com.dominion.backend.repository.StudentRepository;
import com.dominion.backend.utils.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@JsonComponent
public class CustomUserDetailsService implements UserDetailsService {
    private final StudentRepository studentRepository;

    @Autowired
    public CustomUserDetailsService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String matricNo) throws UsernameNotFoundException {
        Student student = studentRepository.findByMatricNo(matricNo);

        if (student == null){
            throw new UserNotFoundException();
        }

        return new CustomUser(student.getSerialNo(), student.getMatricNo(), student.getPassword(), student.getRole());
    }
}
