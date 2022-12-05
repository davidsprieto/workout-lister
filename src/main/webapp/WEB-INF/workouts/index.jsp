<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body style="text-align: center;">

<jsp:include page="/WEB-INF/partials/navbar-logged-in.jsp" />

<div class="container">
    <h1>Here are all the workouts!</h1>

    <form action="/workouts/search" method="GET">
        <label for="workoutSearch">Search Workouts by Title:</label>
        <input id="workoutSearch" type="text" name="workoutSearch"/>

        <input type="submit" value="Search" class="search-workout-button"/>
    </form>

    <%-- Retrieving all the workouts posted to the database, loop through and display them on the page --%>
    <c:forEach var="workout" items="${workouts}">

        <%-- Creating variable "update" with a value of /workouts/update which calls the servlet while passing the workout id to the backend to be used for database query --%>
        <c:url var="update" value="/workouts/update">
            <c:param name="workoutId" value="${workout.id}"/>
        </c:url>

        <%-- Creating variable "delete" with a value of /workouts/delete which calls the servlet while passing the workout id to the backend to be used for database query --%>
        <c:url var="delete" value="/workouts/delete">
            <c:param name="workoutId" value="${workout.id}"/>
        </c:url>

        <div class="card col-md-12">
            <h2>${workout.title}</h2>
            <p>Date Posted: ${workout.dateMade}</p>
            <p>Description: ${workout.description}</p>
            <!-- Button trigger modal -->
            <p><button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">View Details</button></p>
            <c:if test="${workout.getUserId() == sessionScope.user.id}">
                <p><a href="${update}" class="btn btn-sm btn-primary">Update Workout</a></p>
                <br/>
                <form action="${delete}" method="post">
                    <input type="submit" value="delete" class="btn btn-sm btn-primary" onclick="if (!(confirm('Are you sure you want to delete this workout?'))) return false;">
                </form>
            </c:if>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 style="margin-left: 50%" class="modal-title fs-5" id="staticBackdropLabel">${workout.title}</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <p>Date Posted: ${workout.dateMade}</p>
                    <div class="modal-body">
                            ${workout.description}
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>

    </c:forEach>
</div>

<jsp:include page="/WEB-INF/partials/links.jsp"/>

</body>
</html>