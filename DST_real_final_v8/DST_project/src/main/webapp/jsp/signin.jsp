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
    <title>sign in</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath()%>/static/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="<%=request.getContextPath()%>/static/jquery/jquery-3.4.1.js"></script>
    <script src="<%=request.getContextPath()%>/static/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath()%>/static/css/signin.css" rel="stylesheet">
</head>
<body class="text-center" style="background-color:floralwhite;">
    <form method="post" class="form-signin" action="${pageContext.request.contextPath}/signin">
        <h1 class="h3 mb-3 font-weight-normal" style="font-size: x-large">Please sign in</h1>
        <div class="form-group has-success has-feedback">
            <label class="control-label" for="InputUsername" style="font-size: large">Username</label>
            <input type="username" class="form-control" id="InputUsername" name="username" placeholder="Username" aria-describedby="inputSuccessStatus" required autofocus>
            <span id="inputSuccessStatus" class="sr-only">(success)</span>
        </div>
        <div class="form-group has-success has-feedback">
            <label class="control-label" for="InputPassword" style="font-size: large">Password</label>
            <input type="password" class="form-control" id="InputPassword" name="password" placeholder="Password" aria-describedby="inputSuccess2Status" required>
            <span id="inputSuccess2Status" class="sr-only">(success)</span>
        </div>
        <div class="checkbox mb-3">
            <label style="color: red">
                <c:if test="${error != null}">
                    ${error}
                </c:if>
            </label>
        </div>
        <button type="submit" class="btn btn-success">Sign in</button>
    </form>
</body>
</html>