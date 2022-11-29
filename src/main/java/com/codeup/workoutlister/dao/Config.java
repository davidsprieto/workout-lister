package com.codeup.workoutlister.dao;

import javax.annotation.Resource;

@Resource(name = "jdbc/workoutlister_db")
public class Config {

    public String getUrl() {
        return "jdbc:mysql://localhost:3306/workoutlister_db?allowPublicKeyRetrieval=true&useSSL=true";
    }

    public String getUsername() {
        return "root";
    }

    public String getPassword() {
        return "codeup";
    }

}