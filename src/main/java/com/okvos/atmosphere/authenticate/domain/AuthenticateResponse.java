package com.okvos.atmosphere.authenticate.domain;

public class AuthenticateResponse {
    private Integer user_id;
    private String username;

    public String getUsername() {
        return username;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
