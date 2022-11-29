package com.codeup.workoutlister.models;

public class Workout {
    private long id;
    private long userId;
    private String title;
    private String description;
    private String dateMade;

    public Workout() {}

    public Workout(int id, String dateMade, String title, String description) {
        this.id = id;
        this.dateMade = dateMade;
        this.title = title;
        this.description = description;
    }

    public Workout(long id, long userId, String title, String description, String dateMade) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.dateMade = dateMade;
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

}