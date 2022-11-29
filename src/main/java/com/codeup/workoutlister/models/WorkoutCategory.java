package com.codeup.workoutlister.models;

public class WorkoutCategory {
    private long workoutId;
    private long categoryId;

    public WorkoutCategory() {}

    public WorkoutCategory(long workoutId, long categoryId) {
        this.workoutId = workoutId;
        this.categoryId = categoryId;
    }

    public long getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(long workoutId) {
        this.workoutId = workoutId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
}