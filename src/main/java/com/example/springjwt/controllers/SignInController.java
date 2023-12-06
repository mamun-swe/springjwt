package com.example.springjwt.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springjwt.dtos.SignInDto;
import com.example.springjwt.dtos.UserDto;
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

            /** Documents for user creation */
            UserDto documents = new UserDto();
            documents.setUsername(userName);
            documents.setName(body.getName());
            documents.setEmail(body.getEmail());
            documents.setPassword(body.getPassword());

            this.signInService.createUser(documents);

            return Response.Success(HttpStatus.OK, "Account created.");
        } catch (Exception e) {
            return Response.InternalServerError();
        }
    }

}
