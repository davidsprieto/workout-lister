package com.codeup.workoutlister.controllers;

import com.codeup.workoutlister.dao.DaoFactory;
import com.codeup.workoutlister.models.Workout;
import com.codeup.workoutlister.models.User;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "UpdateWorkoutServlet", value = "/workouts/update")
public class UpdateWorkoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        } else {
            long workoutId = Long.parseLong(request.getParameter("workoutId"));
            Workout workout = DaoFactory.getWorkoutsDao().getWorkoutById(workoutId);
            request.setAttribute("workout", workout);
        }
        request.getRequestDispatcher("/WEB-INF/workouts/update-workout.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        long workoutId = Long.parseLong(request.getParameter("workoutId"));
        System.out.println("Post: " + workoutId);

        // Receives categories from form as an array
        String[] formCategories = request.getParameterValues("category");
        // Manipulate array of categories into an ArrayList of categories
        List<String> listCategories = new ArrayList<>(Arrays.asList(formCategories));
        // Manipulate ArrayList of categories to a string of categories separated by a comma
        String categoryStr = String.join(", ", listCategories);

        Workout workout = new Workout(
                workoutId,
                user.getId(),
                request.getParameter("title"),
                request.getParameter("description"),
                request.getParameter("date"),
                categoryStr
        );
        workout.display();
        DaoFactory.getWorkoutsDao().updateWorkout(workout);
        response.sendRedirect("/workouts");
    }

}