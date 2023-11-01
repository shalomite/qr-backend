package com.dominion.backend.repository;

import com.dominion.backend.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public Student findByMatricNo(String matricNo);
}
