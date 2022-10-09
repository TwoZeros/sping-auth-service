package com.example.spingauthservice.service;

import com.example.spingauthservice.model.Authorities;
import com.example.spingauthservice.exception.InvalidCredentials;
import com.example.spingauthservice.exception.UnauthorizedUser;
import com.example.spingauthservice.model.User;
import com.example.spingauthservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationService {
    private final UserRepository userRepository;

    public AuthorizationService(UserRepository repository) {
        this.userRepository = repository;
    }

    public List<Authorities> getAuthorities(User user) {

        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user.getUser(), user.getPassword());
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user.getUser());
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
