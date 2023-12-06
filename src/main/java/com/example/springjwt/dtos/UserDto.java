package com.example.springjwt.dtos;

public class UserDto extends SignInDto {
    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }
}
