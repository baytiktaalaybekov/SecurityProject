package com.example.securityproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class InstructorDetailsResponse {

    private Long id;

    private String first_name;

    private String last_name;

    private String specialization;

    private String group_name;

    private Long student_count;

}
