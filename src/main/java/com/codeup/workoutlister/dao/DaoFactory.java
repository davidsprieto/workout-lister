package com.codeup.workoutlister.dao;

public class DaoFactory {
    private static Workouts workoutsDao;
    private static Users usersDao;
    private static final Config CONFIG = new Config();

    public static Workouts getWorkoutsDao() {
        if (workoutsDao == null) {
            workoutsDao = new MySQLWorkoutsDao(CONFIG);
        }
        return workoutsDao;
    }

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(CONFIG);
        }
        return usersDao;
    }
}