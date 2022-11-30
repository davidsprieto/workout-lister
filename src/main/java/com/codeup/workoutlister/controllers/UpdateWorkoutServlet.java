package com.codeup.workoutlister.controllers;

import com.codeup.workoutlister.dao.DaoFactory;
import com.codeup.workoutlister.models.Workout;
import com.codeup.workoutlister.models.User;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "UpdateWorkoutServlet", value = "/workouts/update")
public class UpdateWorkoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        } else {
            int workoutId = Integer.parseInt(request.getParameter("workoutId"));
            Workout workout = DaoFactory.getWorkoutsDao().getWorkoutById(workoutId);
            request.setAttribute("workout", workout);
        }
        request.getRequestDispatcher("/WEB-INF/workouts/update-workout.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        long workoutId = Long.parseLong(request.getParameter("workoutId"));

        Workout workout = new Workout(
                workoutId,
                user.getId(),
                request.getParameter("title"),
                request.getParameter("description"),
                request.getParameter("date")
        );
        DaoFactory.getWorkoutsDao().updateWorkout(workout);
        response.sendRedirect("/workouts");
    }

}