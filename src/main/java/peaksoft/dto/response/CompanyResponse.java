package com.example.securityproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class CompanyResponse {

    private Long id;

    private String name;

    private String country;

    private String address;

    private String phone_number;
}
