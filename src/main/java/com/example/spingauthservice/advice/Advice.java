package com.example.spingauthservice.advice;

import com.example.spingauthservice.exception.InvalidCredentials;
import com.example.spingauthservice.exception.UnauthorizedUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice("com.example.spingauthservice")
public class Advice {

    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> onConstraintValidationException(
            ConstraintViolationException e) {
        return new ResponseEntity<>(
                String.format("ERROR: %s", e.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> icHandler(InvalidCredentials e) {
        return new ResponseEntity<>(
                String.format("ERROR: %s", e.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> uuHandler(UnauthorizedUser e) {
        return new ResponseEntity<>(
                String.format("ERROR: %s", e.getMessage()),
                HttpStatus.UNAUTHORIZED);
    }
}

