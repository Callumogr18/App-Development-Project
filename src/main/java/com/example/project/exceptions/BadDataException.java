package com.example.project.exceptions;
public class BadDataException extends RuntimeException {
    public BadDataException(String message) {
        super(message);
    }
}