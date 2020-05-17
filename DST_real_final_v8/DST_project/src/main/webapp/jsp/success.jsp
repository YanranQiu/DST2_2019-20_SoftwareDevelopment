<%--
  Created by IntelliJ IDEA.
  User: cuijiajun
  Date: 2020/4/16
  Time: 9:13 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
    <!-- Bootstrap -->
    <link href="<%=request.getContextPath()%>/static/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="<%=request.getContextPath()%>/static/jquery/jquery-3.4.1.js"></script>
    <script src="<%=request.getContextPath()%>/static/bootstrap/js/bootstrap.js"></script>
</head>
<body style="font-size: 1.5rem;">
<jsp:include page="nav.jsp"/>
<jsp:include page="header.jsp"/>

<div id="myAlert" class="alert alert-success" style="margin-bottom: 400px;">
    <a href="<%=request.getContextPath()%>" class="close" data-dismiss="alert">&times;</a>
    <strong>Success</strong> to sign up for our Medguide, now you can view dosing guideline!
</div>
<jsp:include page="tail.jsp"/>
</body>
</html>
