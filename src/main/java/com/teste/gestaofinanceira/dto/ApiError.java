package com.teste.gestaofinanceira.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ApiError {
    private LocalDateTime timestamp;

    private String message;
}
