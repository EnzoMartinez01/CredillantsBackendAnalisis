package com.credillants.credillants.Entity;

public class JWTResponse {
	String Token;

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public JWTResponse(String token){
        this.Token = token;
    }

    public JWTResponse(){

    }
}
