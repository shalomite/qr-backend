package com.dominion.backend.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {
    private String firstName;
    private String middleName;
    private String lastName;
    private String birthDate;
    private String password;
    private String matricNo;
    private String course;
    private String graduationYear;
    private Byte picture;


}
