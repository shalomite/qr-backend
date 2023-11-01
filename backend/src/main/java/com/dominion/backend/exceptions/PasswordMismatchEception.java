package com.dominion.backend.exceptions;

import org.springframework.http.HttpStatus;

public class PasswordMismatchEception extends UserException{
    public PasswordMismatchEception(String message, HttpStatus conflict) {
        super("pasword incorrect", HttpStatus.CONFLICT);
    }
}
