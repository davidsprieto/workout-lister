<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a New Workout"/>
    </jsp:include>
</head>
<body style="text-align: center;">

<jsp:include page="/WEB-INF/partials/navbar-logged-in.jsp"/>

<div class="container">
    <h1>Create a new Workout:</h1>
    <form id="create-workout-form" class="form" action="/workouts/create" method="post">
        <div class="form-group">
            <label for="date">Date (MM/DD/YYYY):</label>
            <input id="date" name="date" class="form-control text-center" type="text">
            <div id="date-error" class="form-text"></div>
        </div>
        <div class="form-group">
            <label for="title">Title:</label>
            <input id="title" name="title" class="form-control text-center" type="text">
            <div id="title-error" class="form-text"></div>
        </div>
        <div class="form-group">Category:</div>
        <div class="form-check form-check-inline">
            <label class="form-check-label" for="upper">Upper</label>
            <input class="form-check-input" name="category" type="checkbox" id="upper" value="upper">
        </div>
        <div class="form-check form-check-inline">
            <label class="form-check-label" for="lower">Lower</label>
            <input class="form-check-input" name="category" type="checkbox" id="lower" value="lower">
        </div>
        <div class="form-check form-check-inline">
            <label class="form-check-label" for="core">Core</label>
            <input class="form-check-input" name="category" type="checkbox" id="core" value="core">
        </div>
        <br/>
        <div class="form-check form-check-inline">
            <label class="form-check-label" for="push">Push</label>
            <input class="form-check-input" name="category" type="checkbox" id="push" value="push">
        </div>
        <div class="form-check form-check-inline">
            <label class="form-check-label" for="pull">Pull</label>
            <input class="form-check-input" name="category" type="checkbox" id="pull" value="pull">
        </div>
        <div class="form-check form-check-inline">
            <label class="form-check-label" for="cardio">Cardio</label>
            <input class="form-check-input" name="category" type="checkbox" id="cardio" value="cardio">
        </div>
        <br/>
        <div class="form-check form-check-inline">
            <label class="form-check-label" for="conditioning">Conditioning</label>
            <input class="form-check-input" name="category" type="checkbox" id="conditioning" value="conditioning">
        </div>
        <div class="form-check form-check-inline">
            <label class="form-check-label" for="crossfit">Crossfit</label>
            <input class="form-check-input" name="category" type="checkbox" id="crossfit" value="crossfit">
        </div>
        <div class="form-check form-check-inline">
            <label class="form-check-label" for="HIIT">HIIT</label>
            <input class="form-check-input" name="category" type="checkbox" id="HIIT" value="HIIT">
        </div>
        <div class="form-check form-check-inline">
            <label class="form-check-label" for="HIIB">HIIB</label>
            <input class="form-check-input" name="category" type="checkbox" id="HIIB" value="HIIB">
        </div>
        <div class="form-check form-check-inline">
            <label class="form-check-label" for="bodybuilding">Bodybuilding</label>
            <input class="form-check-input" name="category" type="checkbox" id="bodybuilding" value="bodybuilding">
        </div>
        <div class="form-check form-check-inline">
            <label class="form-check-label" for="olympic">Olympic</label>
            <input class="form-check-input" name="category" type="checkbox" id="olympic" value="olympic">
        </div>
        <div class="form-check form-check-inline">
            <label class="form-check-label" for="strength">Strength</label>
            <input class="form-check-input" name="category" type="checkbox" id="strength" value="strength">
        </div>
        <div class="form-check form-check-inline">
            <label class="form-check-label" for="functional">Functional</label>
            <input class="form-check-input" name="category" type="checkbox" id="functional" value="functional">
        </div>
        <div class="form-group">
            <label for="description">Description:</label>
            <textarea id="description" name="description" class="form-control text-center" rows="4" cols="50"></textarea>
            <div id="description-error" class="form-text"></div>
        </div>
        <input id="submit-btn" type="submit" class="btn btn-block btn-primary">
    </form>
</div>

<jsp:include page="/WEB-INF/partials/links.jsp"/>

<jsp:include page="/static/js/workout-form-validation.jsp"/>
</body>
</html>