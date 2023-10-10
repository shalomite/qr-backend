package com.dominion.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@Table
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(nullable = false)
@NotBlank
private String firstName;
@Column
private String middleName;
@Column(nullable = false)
@NotBlank
private String lastName;
@Column(nullable = false)
@NotBlank
private String birthDate;
@Column(nullable = false)
@NotBlank
private String matricNo;
@Column(nullable = false)
@NotBlank
private String course;
@Column(nullable = false)
@NotBlank
private Integer graduationYear;
@Column
private Byte picture;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", matricNo='" + matricNo + '\'' +
                ", course='" + course + '\'' +
                ", graduationYear=" + graduationYear +
                ", picture=" + picture +
                '}';
    }
}
