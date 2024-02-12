package com.krishna.fullstackbackend.exception;

public class StudentAlreadyExistsExeption extends RuntimeException {
    public StudentAlreadyExistsExeption(String message) {
        super(message);
    }
}
