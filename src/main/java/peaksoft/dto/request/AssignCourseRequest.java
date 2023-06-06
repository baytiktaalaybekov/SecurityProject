package com.example.securityproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AssignCourseRequest {

    private Long instructorId;

    private Long courseId;


}
