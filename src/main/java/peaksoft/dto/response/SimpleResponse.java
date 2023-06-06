package com.example.securityproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Builder
@Getter @Setter
@AllArgsConstructor
public class SimpleResponse {

    private HttpStatus status;

    private String message;
}
