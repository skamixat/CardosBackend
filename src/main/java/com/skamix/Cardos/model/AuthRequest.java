package com.skamix.Cardos.model;

public class AuthRequest {
    private String login;
    private String password;

    public AuthRequest() {}

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
}