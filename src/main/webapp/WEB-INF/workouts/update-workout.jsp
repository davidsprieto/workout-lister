<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Update Workout" />
    </jsp:include>
</head>
<body style="text-align: center;">

<div class="container">
    <h1>Update Workout</h1>
    <form action="/workouts/update" method="post">
        <div class="form-group">
            <label for="date">Date (MM/DD/YYYY):</label>
            <input id="date" name="date" class="form-control text-center" type="text" value="${workout.dateMade}">
        </div>
        <div class="form-group">
            <label for="title">Title:</label>
            <input id="title" name="title" class="form-control text-center" type="text" value="${workout.title}">
        </div>
        <div class="form-group">
            <label for="description">Description:</label>
            <textarea id="description" name="description" class="form-control text-center">${workout.description}</textarea>
        </div>
        <input type="hidden" name="workoutId" value="${workout.id}"/>

        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>

<jsp:include page="/WEB-INF/partials/links.jsp"/>

</body>
</html>