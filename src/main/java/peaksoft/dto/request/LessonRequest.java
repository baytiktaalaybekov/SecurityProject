package com.example.securityproject.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LessonRequest {
    @NotEmpty(message = "fill in the field")
    private String lesson_name;
    @NotEmpty(message = "fill in the field")
    private String description;

}
