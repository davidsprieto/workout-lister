<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body style="text-align: center;">

<jsp:include page="/WEB-INF/partials/navbar-logged-in.jsp" />

<div class="container">
    <h1>Welcome, ${sessionScope.user.username}!</h1>

    <c:url var="updateProfile" value="/profile/update">
        <c:param name="userId" value="${sessionScope.user.id}"/>
    </c:url>

    <p><a href="${updateProfile}" class="btn btn-sm btn-primary">Update Account</a></p>
</div>

<c:forEach var="workout" items="${workouts}">

    <c:url var="update" value="/workouts/update">
        <c:param name="workoutId" value="${workout.id}"/>
    </c:url>

    <c:url var="delete" value="/workouts/update">
        <c:param name="workoutId" value="${workout.id}"/>
    </c:url>

    <div class="card col-md-12">
        <h2>${workout.title}</h2>
        <p>Date Posted: ${workout.dateMade}</p>
        <p>Description: ${workout.description}</p>
        <!-- Button trigger modal -->
        <p><button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">View Details</button></p>
        <p><a href="${update}" class="btn btn-sm btn-primary">Update Workout</a></p>
        <br/>
        <form action="${delete}" method="post">
            <input type="submit" value="delete" class="btn btn-sm btn-primary" onclick="if (!(confirm('Are you sure you want to delete this workout?'))) return false;">
        </form>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 style="margin-left: 45%" class="modal-title fs-5" id="staticBackdropLabel">${workout.title}</h1>
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


<jsp:include page="/WEB-INF/partials/links.jsp"/>

</body>
</html>