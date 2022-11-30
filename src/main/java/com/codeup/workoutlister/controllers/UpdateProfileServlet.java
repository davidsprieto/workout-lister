package com.codeup.workoutlister.controllers;

import com.codeup.workoutlister.dao.DaoFactory;
import com.codeup.workoutlister.models.User;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

// Displays the update profile page
@WebServlet(name = "UpdateProfileServlet", value = "/profile/update")
public class UpdateProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        } else {
            long userId = Integer.parseInt(request.getParameter("userId"));
            User user = DaoFactory.getUsersDao().getUserById(userId);
            request.setAttribute("user", user);
        }
        request.getRequestDispatcher("/WEB-INF/update-profile.jsp").forward(request, response);
    }

    // Receives the form data submitted when the user updates their account information
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        long userId = Long.parseLong(request.getParameter("userId"));
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirmPassword");

        // validate input
        boolean usernameHasErrors = username.isEmpty() || DaoFactory.getUsersDao().validateUsername(username, userId);
        boolean emailHasErrors = email.isEmpty() || DaoFactory.getUsersDao().validateEmail(email, userId);
        boolean passwordHasErrors = password.isEmpty() || (!password.equals(passwordConfirmation));

        if (!usernameHasErrors) {
            session.setAttribute("usernameHasErrors", false);
        }
        if (!emailHasErrors) {
            session.setAttribute("emailHasErrors", false);
        }
        if (!passwordHasErrors) {
            session.setAttribute("passwordHasErrors", false);
        }

        if (usernameHasErrors) {
            session.setAttribute("usernameHasErrors", true);
            response.sendRedirect("/profile");
        } else if (emailHasErrors) {
            session.setAttribute("emailHasErrors", true);
            response.sendRedirect("/profile");
        } else if (passwordHasErrors) {
            session.setAttribute("passwordHasErrors", true);
            response.sendRedirect("/profile");
        } else {
            session.setAttribute("usernameHasErrors", false);
            session.setAttribute("emailHasErrors", false);
            session.setAttribute("passwordHasErrors", false);
            User user = new User(
                    userId,
                    username,
                    email,
                    password
            );
            DaoFactory.getUsersDao().updateUser(user);
            response.sendRedirect("/profile");
        }
    }
}