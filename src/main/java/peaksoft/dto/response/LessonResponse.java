package com.example.securityproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LessonResponse {

    private Long id;

    private String lesson_name;

    private String description;


}
