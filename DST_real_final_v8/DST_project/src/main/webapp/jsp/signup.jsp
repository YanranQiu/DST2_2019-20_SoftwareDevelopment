<%--
  Created by IntelliJ IDEA.
  User: hello
  Date: 2019-12-3
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="generator" content="">
    <title>sign up</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath()%>/static/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="<%=request.getContextPath()%>/static/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath()%>/static/css/signin.css" rel="stylesheet">
</head>
<body class="text-center" style="background-color:floralwhite;">
<form class="form-signin" method="post" action="${pageContext.request.contextPath}/signup">
    <h1 class="h3 mb-3 font-weight-normal" style="font-size: x-large">Please sign up</h1>
    <div class="form-group">
        <label for="inputEmail" class="sr-only" style="font-size: large">Email</label>
        <input type="text" id="inputEmail" class="form-control" name="email" placeholder="Email" required autofocus>
    </div>
    <div class="form-group">
        <label for="inputUsername" class="sr-only" style="font-size: large">Username</label>
        <input type="text" id="inputUsername" class="form-control" name="username" placeholder="Username" required>
    </div>
    <div class="form-group">
        <label for="inputPassword" class="sr-only" style="font-size: large">Password</label>
        <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Password" required>
    </div>
    <div class="checkbox mb-3">
        <label style="color: red">
            <c:if test="${error != null}">
                ${error}
            </c:if>
        </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
</form>
</body>
</html>