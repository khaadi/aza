package com.example.neoquiz.exception;

public class EmptyFileException extends RuntimeException{
    public EmptyFileException(String message) {
        super(message);
    }
}
