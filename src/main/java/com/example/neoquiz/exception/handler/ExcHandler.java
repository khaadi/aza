package com.example.neoquiz.exception.handler;

import com.example.neoquiz.exception.EmptyFileException;
import com.example.neoquiz.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExcHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse NotFoundException(NotFoundException e) {
        return new ExceptionResponse(HttpStatus.NOT_FOUND, e.getClass().getName(), e.getMessage());
    }

    @ExceptionHandler(EmptyFileException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse EmptyFileException(EmptyFileException e) {
        return new ExceptionResponse(HttpStatus.NOT_FOUND, e.getClass().getName(), e.getMessage());
    }
}
