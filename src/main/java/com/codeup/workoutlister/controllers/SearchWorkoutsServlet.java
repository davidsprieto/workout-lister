package com.codeup.workoutlister.controllers;


import com.codeup.workoutlister.dao.DaoFactory;
import com.codeup.workoutlister.models.Workout;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// Displays the specific workouts searched by the user
@WebServlet(name = "SearchWorkoutsServlet", urlPatterns = "/workouts/search")
public class SearchWorkoutsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String workoutSearch = request.getParameter("workoutSearch");
        List<Workout> workouts = DaoFactory.getWorkoutsDao().getWorkoutsByTitle(workoutSearch);
        request.setAttribute("workouts", workouts);
        request.getRequestDispatcher("/WEB-INF/workouts/search.jsp").forward(request, response);
    }

}