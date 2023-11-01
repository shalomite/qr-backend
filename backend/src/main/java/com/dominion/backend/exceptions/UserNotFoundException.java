package com.dominion.backend.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends UserException{
    public UserNotFoundException() {
        super("user not found", HttpStatus.NOT_FOUND);
    }
}
