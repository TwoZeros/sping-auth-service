package com.example.spingauthservice.repository;

import com.example.spingauthservice.exception.InvalidCredentials;
import com.example.spingauthservice.model.Authorities;
import com.example.spingauthservice.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private final  ConcurrentHashMap<String, User> userConcurrentHashMap;

    public UserRepository() {
        this.userConcurrentHashMap = new ConcurrentHashMap<>() ;
        userConcurrentHashMap.put("kirill", new User("kirill","123", List.of(Authorities.READ)));
        userConcurrentHashMap.put("ivan", new User("ivan","123", List.of(Authorities.READ,Authorities.WRITE)));
        userConcurrentHashMap.put("petya", new User("petya","123", List.of()));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        if(userConcurrentHashMap.containsKey(user)
               && userConcurrentHashMap.get(user).getPassword().equals(password)
        ) {
           User userDb = userConcurrentHashMap.get(user);
           return userDb.getAuthoritiesList();
        } else {
            throw new InvalidCredentials("User name or password not vilid");
        }
    }
}
