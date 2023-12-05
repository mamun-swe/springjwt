package com.example.springjwt.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.springjwt.models.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
    /** Find specific resource by username */
    @Query(value = "SELECT * FROM users as user WHERE user.username=?1", nativeQuery = true)
    Optional<Users> findOneByUsername(String name);

    /** Find specific resource by email */
    @Query(value = "SELECT * FROM users as user WHERE user.email=?1", nativeQuery = true)
    Optional<Users> findOneByEmail(String email);
}
