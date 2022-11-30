package com.codeup.workoutlister.dao;

import com.codeup.workoutlister.models.User;

public interface Users {
    // Find user by username
    User findUserByUsername(String username);
    // Insert new user into database
    Long insert(User user);
    // Check to make sure username isn't used when a user registers
    boolean validateUsername(String username);
    // Check to make sure email isn't used when a user registers
    boolean validateEmail(String email);
    // Check to make sure username isn't used when a user updates their account information
    boolean validateUsername(String username, long id);
    // Check to make sure email isn't used when a user updates their account information
    boolean validateEmail(String email, long id);
    // Get user profile information by id
    User getUserById(long id);
    // Update user profile information
    void updateUser(User user);
    // Check to make sure an account doesn't already exist with the user entered username
}