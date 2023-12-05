package com.example.springjwt.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.springjwt.dtos.ResetDto;
import com.example.springjwt.exceptions.Response;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/reset")
public class ResetController {

    @PostMapping()
    ResponseEntity<Object> reset(@Valid @RequestBody ResetDto resetDto) {
        try {
            System.out.println(resetDto.getEmail());
            return Response.Success(HttpStatus.OK, "Reset response.");
        } catch (Exception e) {
            return Response.InternalServerError();
        }
    }
}
