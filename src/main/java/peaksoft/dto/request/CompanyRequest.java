package com.example.securityproject.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class CompanyRequest {
    @NotEmpty(message = "fill in the field")
    private String name;
    @NotEmpty(message = "fill in the field")
    private String country;
    @NotEmpty(message = "fill in the field")
    private String address;
    @Pattern(regexp = "\\+996\\d{9}",message = "Wrong format")
    private String phone_number;
}
