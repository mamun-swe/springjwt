package com.example.springjwt.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springjwt.models.Users;
import com.example.springjwt.repositories.UserRepository;

@Service
public class SignInService {
    @Autowired
    private UserRepository userRepository;

    /** getting a specific record by id */
    public Optional<Users> findById(Long id) {
        return this.userRepository.findById(id);
    }

    /** getting a specific record by username */
    public Optional<Users> findByUserName(String username) {
        return this.userRepository.findOneByUsername(username);
    }

    /** getting a specific record by email */
    public Optional<Users> findByEmail(String email) {
        return this.userRepository.findOneByEmail(email);
    }
}
