package com.example.catchjeon_back.Exception;

public class DuplicationEmailException extends RuntimeException {
    public DuplicationEmailException(String message) {
        super(message);
    }
}
