package com.krishna.fullstackbackend.exception;

public class StudentNotFoundExeption extends RuntimeException {
    public StudentNotFoundExeption(String message) {
        super(message);
    }
}
