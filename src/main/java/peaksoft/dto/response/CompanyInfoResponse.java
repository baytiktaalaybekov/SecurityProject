package com.example.securityproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CompanyInfoResponse {

    private Long id;
    private String name;
    private String country;
    private String address;
    private String phone_number;
    private List<String> course_name;
    private List<String> group_name;
    private List<String> instructorName;
    private int studentCount;


}
