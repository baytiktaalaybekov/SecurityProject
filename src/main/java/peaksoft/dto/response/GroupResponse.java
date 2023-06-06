package com.example.securityproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GroupResponse {

    private Long id;

    private String group_name;

    private String image_Link;

    private String description;

}
