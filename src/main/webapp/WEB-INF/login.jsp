<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Please Log In" />
  </jsp:include>
</head>
<body style="text-align: center;">

<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
  <h1>Log In</h1>
  <div>
    <p>Don't have an account? <a href="/register">Sign-up</a></p>
  </div>
  <form action="/login" method="POST">
    <div class="form-group">
      <label for="username">Username:</label>
      <input id="username" name="username" class="form-control text-center" type="text">
    </div>
    <div class="form-group">
      <label for="password">Password:</label>
      <input id="password" name="password" class="form-control text-center" type="password">
    </div>
    <input type="hidden" name="URI" value="${param.URI}" />
    <br/>
    <input type="submit" class="btn btn-primary btn-block" value="Log In">
  </form>
</div>

<jsp:include page="/WEB-INF/partials/links.jsp"/>

</body>
</html>