<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body style="text-align: center;">

<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Display Search Workouts</h1>

    <c:forEach var="workout" items="${workouts}">

        <c:url var="update" value="/workouts/update">
            <c:param name="workoutId" value="${workout.id}"/>
        </c:url>

        <c:url var="delete" value="/workouts/delete">
            <c:param name="workoutId" value="${workout.id}"/>
        </c:url>

        <div class="col-md-6">
            <h2>${workout.title}</h2>
            <p>Date Posted: ${workout.dateMade}</p>
            <p>Description: ${workout.description}</p>
            <a href="${update}" class="btn btn-sm btn-primary">Update Workout</a>
            <form action="${delete}" method="post">
                <input type="submit" value="delete" class="btn btn-sm btn-primary" onclick="if (!(confirm('Are you sure you want to delete this workout?'))) return false;">
            </form>
        </div>

    </c:forEach>
</div>

<jsp:include page="/WEB-INF/partials/links.jsp"/>

</body>
</html>