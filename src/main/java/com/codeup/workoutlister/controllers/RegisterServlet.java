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

// Displays the login page
@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        HttpSession session = request.getSession();
        session.invalidate();
    }

    // Receives the form data submitted when the user signs up
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirmPassword");

        // validate input
        boolean usernameHasErrors = username.isEmpty() || DaoFactory.getUsersDao().validateUsername(username);
        boolean emailHasErrors = email.isEmpty() || DaoFactory.getUsersDao().validateEmail(email);
        boolean passwordHasErrors = password.isEmpty() || (!password.equals(passwordConfirmation));

        if (usernameHasErrors) {
            session.setAttribute("usernameHasErrors", true);
            response.sendRedirect("/register");
        } else if (emailHasErrors) {
            session.setAttribute("emailHasErrors", true);
            response.sendRedirect("/register");
        } else if (passwordHasErrors) {
            session.setAttribute("passwordHasErrors", true);
            response.sendRedirect("/register");
        } else {
            session.invalidate();
            User user = new User(username, email, password);
            DaoFactory.getUsersDao().insert(user);
            response.sendRedirect("/login");
        }

    }
}