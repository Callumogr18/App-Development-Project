package com.example.project.service.exceptions;
public class BadDataException extends RuntimeException {
    public BadDataException(String message) {
        super(message);
    }
}