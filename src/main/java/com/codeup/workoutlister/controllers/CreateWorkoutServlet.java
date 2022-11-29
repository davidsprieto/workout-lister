package com.codeup.workoutlister.controllers;

import com.codeup.workoutlister.dao.DaoFactory;
import com.codeup.workoutlister.models.Workout;
import com.codeup.workoutlister.models.User;
import jakarta.servlet.annotation.WebServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// Displays the create workout page
@WebServlet(name = "CreateWorkoutServlet", urlPatterns = "/workouts/create")
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
        Workout workout = new Workout(
                user.getId(),
                request.getParameter("date"),
                request.getParameter("title"),
                request.getParameter("description")
        );
        DaoFactory.getWorkoutsDao().insert(workout);
        response.sendRedirect("/workouts");
    }
}
