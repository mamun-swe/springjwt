package com.example.springjwt.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springjwt.dtos.SignInDto;
import com.example.springjwt.exceptions.Response;
import com.example.springjwt.helpers.helpers;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/signin")
public class SignInController {

    @Autowired
    private helpers helpers;

    @PostMapping()
    ResponseEntity<Object> signIn(@Valid @RequestBody SignInDto signInDto) {
        try {

            String username = this.helpers.customUserName(signInDto.getName());
            System.out.println(username);
            return Response.Success(HttpStatus.OK, "Sign in response.");
        } catch (Exception e) {
            return Response.InternalServerError();
        }
    }

}
