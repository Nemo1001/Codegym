package com.codegym.model;

public class User {
    private String email;
    private String password;

    public User(String user, String password) {
        this.email = user;
        this.password = password;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String user) {
        this.email = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
