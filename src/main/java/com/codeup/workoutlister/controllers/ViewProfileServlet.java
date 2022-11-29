package com.codeup.workoutlister.controllers;

import com.codeup.workoutlister.dao.DaoFactory;
import com.codeup.workoutlister.models.User;
import jakarta.servlet.annotation.WebServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// Displays the profile page
@WebServlet(name = "ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        User user = (User) session.getAttribute("user");
        long id = user.getId();
        request.setAttribute("workouts", DaoFactory.getWorkoutsDao().getWorkoutsByUserId(id));

        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }
}