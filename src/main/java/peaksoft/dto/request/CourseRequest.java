package com.example.securityproject.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDate;
@Data
public class CourseRequest {
   @NotEmpty(message = "fill in the field")
   private String course_name;

   private LocalDate date_of_start;
   @NotEmpty(message = "fill in the field")
   private String description;
}
