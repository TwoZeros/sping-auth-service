package com.example.spingauthservice.controller;

import com.example.spingauthservice.exception.InvalidCredentials;
import com.example.spingauthservice.exception.UnauthorizedUser;
import com.example.spingauthservice.model.Authorities;
import com.example.spingauthservice.model.User;
import com.example.spingauthservice.model.UserDto;
import com.example.spingauthservice.service.AuthorizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid @UserDto User user) {
        return service.getAuthorities(user);
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> icHandler(InvalidCredentials e) {
        return new ResponseEntity<>(
                String.format("ERROR: %s",e.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> uuHandler(UnauthorizedUser e) {
        return new ResponseEntity<>(
                String.format("ERROR: %s",e.getMessage()),
                HttpStatus.UNAUTHORIZED);
    }
}
