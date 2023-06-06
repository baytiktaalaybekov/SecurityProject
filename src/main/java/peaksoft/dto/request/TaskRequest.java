package com.example.securityproject.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class TaskRequest {
    @NotEmpty(message = "fill in the field")
    private String task_name;
    @NotEmpty(message = "fill in the field")
    private String taskText;

    private LocalDate dead_line;
}
