package com.dominion.backend.exceptions;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistsException extends UserException{
    public UserAlreadyExistsException(String message, HttpStatus badRequest) {
        super(message, HttpStatus.CONFLICT);
    }
}
