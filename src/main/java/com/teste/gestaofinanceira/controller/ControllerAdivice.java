package com.teste.gestaofinanceira.controller;

import com.teste.gestaofinanceira.dto.ApiError;
import com.teste.gestaofinanceira.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ControllerAdivice {
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleRegraNegocioException(BusinessException exception){

        return new ApiError(LocalDateTime.now(), exception.getMessage());
    }
}
