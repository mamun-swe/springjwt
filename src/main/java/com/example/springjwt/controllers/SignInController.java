package com.example.springjwt.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springjwt.dtos.SignInDto;
import com.example.springjwt.exceptions.Response;
import com.example.springjwt.models.Users;
import com.example.springjwt.services.SignInService;
import com.example.springjwt.utility.Slug;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/signin")
public class SignInController {

    @Autowired
    private SignInService signInService;

    @PostMapping()
    ResponseEntity<Object> signIn(@Valid @RequestBody SignInDto body) {
        try {

            String userName = Slug.makeSlug(body.getName());

            /** Check unique email */
            Optional<Users> isEmailExist = this.signInService.findByEmail(body.getEmail());
            if (isEmailExist.isPresent()) {
                Map<String, String> errors = new HashMap<>();
                errors.put("email", "Email address already taken.");
                return Response.Error(HttpStatus.CONFLICT, "Email exist.", errors);
            }

            /** Check unique username */
            Optional<Users> isUsernameExist = this.signInService.findByUserName(userName);
            if (isUsernameExist.isPresent()) {
                Map<String, String> errors = new HashMap<>();
                errors.put("name", "Name already taken.");
                return Response.Error(HttpStatus.CONFLICT, "Name exist.", errors);
            }

            this.signInService.createUser(body);

            System.out.println(isEmailExist);
            return Response.Success(HttpStatus.OK, "Sign in response.");
        } catch (Exception e) {
            return Response.InternalServerError();
        }
    }

}
