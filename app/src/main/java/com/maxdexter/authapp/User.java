package com.maxdexter.authapp;

import java.io.Serializable;

public class User implements Serializable {
    private String mLogin;
    private String mPassword;
    private boolean isLogged;

    public User(String login, String password) {
        mLogin = login;
        mPassword = password;
    }

    public void setHasSuccessLogin(boolean isLogged){
        this.isLogged = isLogged;
    }

    public String getLogin() {
        return mLogin;
    }

    public void setLogin(String login) {
        mLogin = login;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }
}
