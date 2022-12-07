DROP DATABASE IF EXISTS workoutlister_db;

CREATE DATABASE IF NOT EXISTS workoutlister_db;

USE workoutlister_db;

CREATE TABLE users
(
    id       INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    email    VARCHAR(255) NOT NULL,
    password VARCHAR(100) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (username),
    UNIQUE (email)
);

CREATE TABLE workouts
(
    id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id     INT UNSIGNED NOT NULL,
    title       VARCHAR(50)  NOT NULL,
    description VARCHAR(500)         NOT NULL,
    dateMade    VARCHAR(50)  NOT NULL,
    categoryStr    VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE categories
(
    id       INT UNSIGNED NOT NULL AUTO_INCREMENT,
    category VARCHAR(100) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (category)
);

CREATE TABLE workoutCategories
(
    workout_id  INT UNSIGNED NOT NULL,
    category_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (workout_id) REFERENCES workouts (id),
    FOREIGN KEY (category_id) REFERENCES categories (id)
);

INSERT INTO categories (category)
VALUES ('upper'),
       ('lower'),
       ('push'),
       ('pull'),
       ('core'),
       ('cardio'),
       ('conditioning'),
       ('crossfit'),
       ('HIIT'),
       ('HIIB'),
       ('bodybuilding'),
       ('olympic'),
       ('strength'),
       ('functional');