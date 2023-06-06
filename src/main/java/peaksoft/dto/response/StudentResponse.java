package com.example.securityproject.dto.response;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import peaksoft.enums.StudyFormat;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class StudentResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String email;

    @Enumerated(EnumType.STRING)
    private StudyFormat studyFormat;

    private Boolean isBlocked;



}
