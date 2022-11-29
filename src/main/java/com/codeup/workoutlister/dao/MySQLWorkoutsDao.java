package com.codeup.workoutlister.dao;

import com.codeup.workoutlister.models.Workout;
import com.codeup.workoutlister.util.PreventDataLeak;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLWorkoutsDao implements Workouts {
    private final Connection CONNECTION;
    private PreparedStatement stmt;
    private ResultSet rs;


    public MySQLWorkoutsDao(Config config) {
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
    public List<Workout> all() {
        try {
            String query = "SELECT * FROM workouts";
            stmt = CONNECTION.prepareStatement(query);
            rs = stmt.executeQuery();
            return createWorkoutsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all workouts.", e);
        } finally {
            PreventDataLeak.close(stmt);
        }
    }

    @Override
    public Long insert(Workout workout) {
        try {
            String query = "INSERT INTO workouts(user_id, title, description, dateMade) VALUES (?, ?, ?, ?)";
            stmt = CONNECTION.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, workout.getUserId());
            stmt.setString(2, workout.getTitle());
            stmt.setString(3, workout.getDescription());
            stmt.setString(4, workout.getDateMade());
            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new workout.", e);
        } finally {
            PreventDataLeak.close(stmt);
        }
    }

    @Override
    public Workout getWorkoutById(int id) {
        try {
            String query = "SELECT * FROM workouts WHERE id = ?";
            stmt = CONNECTION.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            rs.next();
            String dateMade = rs.getString("dateMade");
            String title = rs.getString("title");
            String description = rs.getString("description");
            return new Workout(id, dateMade, title, description);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving workout by id.", e);
        } finally {
            PreventDataLeak.close(stmt);
        }
    }

    @Override
    public void updateWorkout(Workout workout) {
        try {
            String query = "UPDATE workouts SET user_id = ?, title = ?, description = ?, dateMade = ? WHERE id = ?";
            stmt = CONNECTION.prepareStatement(query);
            stmt.setLong(1, workout.getUserId());
            stmt.setString(2, workout.getTitle());
            stmt.setString(3, workout.getDescription());
            stmt.setString(4, workout.getDateMade());
            stmt.setLong(5, workout.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating workout.", e);
        } finally {
            PreventDataLeak.close(stmt);
        }
    }

    @Override
    public void deleteWorkoutById(int id) {
        try {
            String query = "DELETE FROM workouts WHERE id = ?";
            stmt = CONNECTION.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting workout.", e);
        } finally {
            PreventDataLeak.close(stmt);
        }
    }

    @Override
    public List<Workout> getWorkoutsByTitle(String title) {
        try {
            if (title != null && title.trim().length() > 0) {
                String query = "SELECT * FROM workouts where lower(title) like ? or lower(title) like ?";
                stmt = CONNECTION.prepareStatement(query);
                String titleLike = "%" + title.toLowerCase() + "%";
                stmt.setString(1, titleLike);
                stmt.setString(2, titleLike);
            } else {
                String query = "SELECT * FROM workouts ORDER BY title";
                stmt = CONNECTION.prepareStatement(query);
            }
            rs = stmt.executeQuery();
            return createWorkoutsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving workouts by title", e);
        } finally {
            PreventDataLeak.close(stmt);
        }
    }

    @Override
    public List<Workout> getWorkoutsByUserId(long id) {
        try {
            String query = "SELECT * FROM workouts WHERE user_id = ?";
            stmt = CONNECTION.prepareStatement(query);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            return createWorkoutsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving workouts by user id", e);
        } finally {
            PreventDataLeak.close(stmt);
        }
    }

    private Workout extractWorkout(ResultSet rs) throws SQLException {
        return new Workout(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("dateMade")
        );
    }

    private List<Workout> createWorkoutsFromResults(ResultSet rs) throws SQLException {
        List<Workout> workouts = new ArrayList<>();
        while (rs.next()) {
            workouts.add(extractWorkout(rs));
        }
        return workouts;
    }
}