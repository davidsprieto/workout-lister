<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!"/>
    </jsp:include>
</head>
<body style="text-align: center;">

<jsp:include page="partials/navbar-logged-in.jsp"/>

<div class="container">
    <h1>Update your information:</h1>
    <form action="/profile/update" method="post">
        <div class="form-group">
            <label for="username">Username:</label>
            <input id="username" name="username" class="form-control text-center" type="text" value="${user.username}">
            <c:if test="${usernameHasErrors}">
                <div>An account with that username already exists</div>
            </c:if>
            <div id="usernameError" class="form-text"></div>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input id="email" name="email" class="form-control text-center" type="text" value="${user.email}">
            <c:if test="${emailHasErrors}">
                <div>An account with that email already exists</div>
            </c:if>
            <div id="emailError" class="form-text"></div>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input id="password" name="password" class="form-control text-center" type="password">
            <c:if test="${passwordHasErrors}">
                <div>Passwords don't match</div>
            </c:if>
            <div id="passwordError" class="form-text"></div>
        </div>
        <div class="form-group">
            <label for="confirmPassword">Confirm Password:</label>
            <input id="confirmPassword" name="confirmPassword" class="form-control text-center" type="password">
            <c:if test="${passwordHasErrors}">
                <div>Passwords don't match</div>
            </c:if>
            <div id="confirmPasswordError" class="form-text"></div>
        </div>
        <br/>
        <input type="hidden" name="userId" value="${sessionScope.user.id}"/>

        <input id="submit-btn" type="submit" class="btn btn-primary btn-block">
    </form>
</div>

<jsp:include page="/WEB-INF/partials/links.jsp"/>

<jsp:include page="/static/js/user-form-validation.jsp"/>
</body>
</html>
