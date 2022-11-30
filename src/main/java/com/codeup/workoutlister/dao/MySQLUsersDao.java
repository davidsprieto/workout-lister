package com.codeup.workoutlister.dao;

import com.codeup.workoutlister.models.User;
import com.codeup.workoutlister.util.PreventDataLeak;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLUsersDao implements Users {
    private final Connection CONNECTION;
    private PreparedStatement stmt;
    private ResultSet rs;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            CONNECTION = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }


    @Override
    public User findUserByUsername(String username) {
        try {
            String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
            stmt = CONNECTION.prepareStatement(query);
            stmt.setString(1, username);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        } finally {
            PreventDataLeak.close(stmt);
        }
    }

    @Override
    public boolean validateUsername(String username) {
        boolean usernameUsed = false;
        String query = "SELECT * FROM users WHERE username = ?";
        try {
            stmt = CONNECTION.prepareStatement(query);
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("username").equals(username)) {
                    usernameUsed = true;
                }
            }
            return usernameUsed;
        } catch(SQLException e) {
            throw new RuntimeException("Error retrieving username", e);
        } finally {
            PreventDataLeak.close(stmt);
        }
    }

    @Override
    public boolean validateEmail(String email) {
        boolean emailUsed = false;
        String query = "SELECT * FROM users WHERE email = ?";
        try {
            stmt = CONNECTION.prepareStatement(query);
            stmt.setString(1, email);
            rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("email").equals(email)) {
                    emailUsed = true;
                }
            }
            return emailUsed;
        } catch(SQLException e) {
            throw new RuntimeException("Error retrieving email", e);
        } finally {
            PreventDataLeak.close(stmt);
        }
    }

    @Override
    public boolean validateUsername(String username, long id) {
        boolean usernameUsed = false;
        String query = "SELECT * FROM users WHERE id != ?";
        try {
            stmt = CONNECTION.prepareStatement(query);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("username").equals(username)) {
                    usernameUsed = true;
                }
            }
            return usernameUsed;
        } catch(SQLException e) {
            throw new RuntimeException("Error retrieving username", e);
        } finally {
            PreventDataLeak.close(stmt);
        }
    }

    @Override
    public boolean validateEmail(String email, long id) {
        boolean emailUsed = false;
        String query = "SELECT * FROM users WHERE id != ?";
        try {
            stmt = CONNECTION.prepareStatement(query);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("email").equals(email)) {
                    emailUsed = true;
                }
            }
            return emailUsed;
        } catch(SQLException e) {
            throw new RuntimeException("Error retrieving email", e);
        } finally {
            PreventDataLeak.close(stmt);
        }
    }

    @Override
    public User getUserById(long id) {
        try {
            String query = "SELECT * FROM users WHERE id = ?";
            stmt = CONNECTION.prepareStatement(query);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            rs.next();
            String username = rs.getString("username");
            String email = rs.getString("email");
            String password = rs.getString("password");
            return new User(id, username, email, password);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving user by id.", e);
        } finally {
            PreventDataLeak.close(stmt);
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            String query = "UPDATE users SET id = ?, username = ?, email = ? WHERE id = ?";
            stmt = CONNECTION.prepareStatement(query);
            stmt.setLong(1, user.getId());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getEmail());
            stmt.setLong(4, user.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating user.", e);
        } finally {
            PreventDataLeak.close(stmt);
        }
    }

    @Override
    public Long insert(User user) {
        String query = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
        try {
            stmt = CONNECTION.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        } finally {
            PreventDataLeak.close(stmt);
        }
    }

    private User extractUser(ResultSet rs) throws SQLException {
        if (!rs.next()) {
            return null;
        }
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
        );
    }

}