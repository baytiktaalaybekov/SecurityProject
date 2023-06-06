package com.example.securityproject.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GroupRequest {
    @NotEmpty(message = "fill in the field")
    private String group_name;
    @NotEmpty(message = "fill in the field")
    private String image_Link;
    @NotEmpty(message = "fill in the field")
    private String description;

}
