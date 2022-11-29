package com.codeup.workoutlister.dao;

import com.codeup.workoutlister.models.User;

public interface Users {
    // Find user by username
    User findUserByUsername(String username);
    // Insert new user into database
    Long insert(User user);
    // Check to make sure username isn't used
    boolean validateUsername(String username);
    // Check to make sure email isn't used
    boolean validateEmail(String email);
    // Get user profile information by id
    User getUserById(int id);
    // Update user profile information
    void updateUser(User user);
}