package com.codeup.workoutlister.models;

public class Workout {
    private long id;
    private long userId;
    private String username;
    private String title;
    private String description;
    private String dateMade;
    private String categoryStr;
    private long categoryId;

    public Workout() {}

    public Workout(long id, long userId, String title, String description, String username, String dateMade, String categoryStr, long categoryId) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.title = title;
        this.description = description;
        this.dateMade = dateMade;
        this.categoryStr = categoryStr;
        this.categoryId = categoryId;
    }

    public Workout(long id, long userId, String title, String description, String dateMade, String categoryStr) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.dateMade = dateMade;
        this.categoryStr = categoryStr;
    }

    public Workout(long userId, String dateMade, String title, String description, String categoryStr) {
        this.userId = userId;
        this.dateMade = dateMade;
        this.title = title;
        this.description = description;
        this.categoryStr = categoryStr;
    }

    public Workout(long userId, String dateMade, String title, String description) {
        this.userId = userId;
        this.dateMade = dateMade;
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateMade() {
        return dateMade;
    }

    public void setDateMade(String dateMade) {
        this.dateMade = dateMade;
    }

    public String getCategoryStr() {
        return categoryStr;
    }

    public void setCategoryStr(String categoryStr) {
        this.categoryStr = categoryStr;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public void display() {
        System.out.println("Workout Id: " + this.id);
        System.out.println("User Id: " + this.userId);
        System.out.println("Title: " + this.title);
        System.out.println("Description: " + this.description);
        System.out.println("Date made: " + this.dateMade);
        System.out.println("Categories: " + this.categoryStr);
    }
}