package com.example.securityproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor

public class InstructorResponse {

    private Long id;

    private String first_name;

    private String last_name;

    private String phone_number;

    private String specialization;
}
