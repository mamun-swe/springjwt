package com.example.springjwt.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springjwt.dtos.SignUpDto;
import com.example.springjwt.exceptions.Response;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/signup")
public class SignUpController {

    @PostMapping()
    ResponseEntity<Object> signUp(@Valid @RequestBody SignUpDto signUpDto) {
        try {
            System.out.println(signUpDto.getEmail());
            return Response.Success(HttpStatus.OK, "Sign up response.");
        } catch (Exception e) {
            return Response.InternalServerError();
        }
    }

}
