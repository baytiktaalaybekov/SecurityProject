package com.example.securityproject.dto.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import peaksoft.enums.StudyFormat;

@Getter
@Setter
public class StudentRequest {
    @NotEmpty(message = "fill in the field")
    private String firstName;
    @NotEmpty(message = "fill in the field")
    private String lastName;
    @Pattern(regexp = "\\+996\\d{9}",message = "Wrong format")
    private String phoneNumber;
    @NotEmpty(message = "fill in the field")
    private String email;
    @Enumerated(EnumType.STRING)
    private StudyFormat studyFormat;


    public StudentRequest(String firstName, String lastName, String phoneNumber, String email, StudyFormat studyFormat) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.studyFormat = studyFormat;
    }
















}
