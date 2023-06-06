package com.example.securityproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AssignStudentRequest {

    private Long studentId;

    private Long groupId;
}
