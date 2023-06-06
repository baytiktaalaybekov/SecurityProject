package com.example.securityproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AssignGroupToCourseRequest {

    private Long groupId;

    private Long courseId;


}
