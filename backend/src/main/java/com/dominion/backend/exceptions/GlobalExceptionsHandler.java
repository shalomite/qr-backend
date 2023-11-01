package com.dominion.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionsHandler {
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> handlesAccessDeniedException(AccessDeniedException accessDeniedException){
        return new ResponseEntity<>(accessDeniedException.getMessage(), HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handlesIllegalArgumentException(IllegalArgumentException illegalArgumentException){
        return new ResponseEntity<>(illegalArgumentException.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(CommonsException.class)
    public ResponseEntity<?> handlesCommonsException(CommonsException commonsException){
        return new ResponseEntity<>(commonsException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PasswordMismatchEception.class)
    public ResponseEntity<?> handlesPasswordMismatchedException(PasswordMismatchEception passwordMismatchEception){
        return new ResponseEntity<>(passwordMismatchEception.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<?> handlesUserAlreadyExistsException(UserAlreadyExistsException userAlreadyExistsException){
        System.out.println(userAlreadyExistsException.getMessage() + "..................................");
        return new ResponseEntity<>(userAlreadyExistsException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity<?> handlesUserException(UserException userException){
        return new ResponseEntity<>(userException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handlesUserException(UserNotFoundException userNotFoundException){
        return new ResponseEntity<>(userNotFoundException.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
