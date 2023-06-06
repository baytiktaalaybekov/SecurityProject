package com.example.securityproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class CourseResponse {

    private Long id;

    private String course_name;

    private LocalDate date_of_start;

    private String description;
}
