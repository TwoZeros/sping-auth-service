package com.example.spingauthservice.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class User {
    @NotNull
    @NotBlank(message = "поле user не должно быть пустым")
    @Size(min = 2, max=64, message ="Недопустимая длина поля user")
    private String user;
    @NotNull
    @NotBlank(message = "поле password не должно быть пустым")
    @Size(min = 2, max=64, message ="Недопустимая длина поля password")
    private String password;
    List<Authorities> authoritiesList;
    public User() {
    }
    public User(String user, String password, List<Authorities> authoritiesList) {
        this.user = user;
        this.password = password;
        this.authoritiesList = authoritiesList;
    }

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Authorities> getAuthoritiesList() {
        return authoritiesList;
    }

    public void setAuthoritiesList(List<Authorities> authoritiesList) {
        this.authoritiesList = authoritiesList;
    }
}
