package com.example.springjwt.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SignInDto {
    @NotBlank(message = "The name is required.")
    @NotEmpty(message = "The name is required.")
    @NotNull(message = "The name is required.")
    private String name;

    @NotBlank(message = "The email is required.")
    @NotEmpty(message = "The email is required.")
    @NotNull(message = "The email is required.")
    @Email(message = "The address is not valid.")
    private String email;

    @NotBlank(message = "The password is required.")
    @NotEmpty(message = "The password is required.")
    @NotNull(message = "The password is required.")
    private String password;

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }
}
