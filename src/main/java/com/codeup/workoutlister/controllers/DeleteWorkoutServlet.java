package com.codeup.workoutlister.controllers;

import com.codeup.workoutlister.dao.DaoFactory;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

// Handles the data submitted when a user deletes a workout
@WebServlet(name = "DeleteWorkoutServlet", value = "/workouts/delete")
public class DeleteWorkoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int workoutId = Integer.parseInt(request.getParameter("workoutId"));
        DaoFactory.getWorkoutsDao().deleteWorkoutById(workoutId);
        response.sendRedirect("/workouts");
    }
}
