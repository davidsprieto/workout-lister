package com.codeup.workoutlister.controllers;

import com.codeup.workoutlister.dao.DaoFactory;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

// Displays all the workouts submitted
@WebServlet(name = "WorkoutsIndexServlet", urlPatterns = "/workouts")
public class WorkoutsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("workouts", DaoFactory.getWorkoutsDao().all());
        request.getRequestDispatcher("/WEB-INF/workouts/index.jsp").forward(request, response);
    }
}