package com.codeup.workoutlister.dao;

import com.codeup.workoutlister.models.Workout;

import java.util.List;

public interface Workouts {
    // get a list of all the workouts
    List<Workout> all();
    // insert a new workout and return the new workout's id
    Long insert(Workout workout);
    // get a workout by id
    Workout getWorkoutById(int id);
    // update a workout
    void updateWorkout(Workout workout);
    // delete a workout
    void deleteWorkoutById(int id);
    // search for workout
    List<Workout> getWorkoutsByTitle(String title);
    // get list of user's workouts by user id
    List<Workout> getWorkoutsByUserId(long id);
}