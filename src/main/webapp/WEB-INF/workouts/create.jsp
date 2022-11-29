<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a New Workout" />
    </jsp:include>
</head>
<body style="text-align: center;">

<jsp:include page="/WEB-INF/partials/navbar-logged-in.jsp" />

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
        <div class="form-group">
            <label for="description">Description:</label>
            <textarea id="description" name="description" class="form-control text-center"></textarea>
            <div id="description-error" class="form-text"></div>
        </div>
        <input id="submit-btn" type="submit" class="btn btn-block btn-primary">
    </form>
</div>

<jsp:include page="/WEB-INF/partials/links.jsp"/>

<jsp:include page="/static/js/workout-form-validation.jsp"/>
</body>
</html>