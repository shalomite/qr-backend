package com.dominion.backend.model;

import com.dominion.backend.model.enums.Role;
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
private Long serialNo;
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
@Column
@NotBlank
private String password;
@Column(nullable = false)
@NotBlank
private String matricNo;
@Column(nullable = false)
@NotBlank
private String course;
@Column(nullable = false)
@NotBlank
private String graduationYear;
@Column
private Byte picture;
@Column
private Role role;

    @Override
    public String toString() {
        return "Student{" +
                "serialNo=" + serialNo +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", password='" + password + '\'' +
                ", matricNo='" + matricNo + '\'' +
                ", course='" + course + '\'' +
                ", graduationYear='" + graduationYear + '\'' +
                ", picture=" + picture +
                ", role=" + role +
                '}';
    }
}
