package com.example.springjwt.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ResetDto {
    @NotBlank(message = "The email is required.")
    @NotEmpty(message = "The email is required.")
    @NotNull(message = "The email is required.")
    @Email(message = "The address is not valid.")
    private String email;

    public String getEmail() {
        return this.email;
    }
}
