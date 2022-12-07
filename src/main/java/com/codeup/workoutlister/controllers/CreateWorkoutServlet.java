package com.codeup.workoutlister.controllers;

import com.codeup.workoutlister.dao.DaoFactory;
import com.codeup.workoutlister.models.Workout;
import com.codeup.workoutlister.models.User;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Displays the create workout page
@WebServlet(name = "CreateWorkoutServlet", value = "/workouts/create")
public class CreateWorkoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/workouts/create.jsp")
                .forward(request, response);
    }

    // Receives the form data submitted when the user posts a workout
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        // Receives categories from form as an array
        String[] formCategories = request.getParameterValues("category");
        // Manipulate array of categories into an ArrayList of categories
        List<String> listCategories = new ArrayList<>(Arrays.asList(formCategories));
        // Manipulate ArrayList of categories to a string of categories separated by a comma
        String categoryStr = String.join(", ", listCategories);

        // Create a new workout from form data to be inserted into MySQL
        Workout workout = new Workout(
                user.getId(),
                request.getParameter("date"),
                request.getParameter("title"),
                request.getParameter("description"),
                categoryStr
        );
        DaoFactory.getWorkoutsDao().insert(workout);
        response.sendRedirect("/workouts");
    }
}
