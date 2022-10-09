package com.example.spingauthservice.model;

import java.util.List;

public class User {
private String login;
private String password;
List<Authorities> authoritiesList;

    public User(String login, String password, List<Authorities> authoritiesList) {
        this.login = login;
        this.password = password;
        this.authoritiesList = authoritiesList;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
