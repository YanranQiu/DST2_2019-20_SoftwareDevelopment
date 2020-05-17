<%--
  Created by IntelliJ IDEA.
  User: cuijiajun
  Date: 2020/4/7
  Time: 3:20 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <meta name="description" content="Medguide Knowledgebase">
    <meta name="author" content="DST2 group cuijiajun">
    <meta name="generator" content="">
    <title>Mediguide</title>

    <!-- Bootstrap -->
    <link href="<%=request.getContextPath()%>/static/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="<%=request.getContextPath()%>/static/jquery/jquery-3.4.1.js"></script>
    <script src="<%=request.getContextPath()%>/static/bootstrap/js/bootstrap.js"></script>
    <!-- Custom styles for this template -->

<%--<style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>--%>
</head>
<body style="outline: none">
<%--<jsp:include page="head.jsp" />--%>

<div style="font-size: 1.5rem;">
    <jsp:include page="nav.jsp"/>
    <jsp:include page="header.jsp"/>
    <c:if test="${requestScope.user != null}">
        <div id="myAlert" class="alert alert-warning">
            <a href="${pageContext.request.contextPath}" class="close" data-dismiss="alert">&times;</a>
            You are <strong>not allowed</strong> to view dosing guideline, please <a href="${pageContext.request.contextPath}/signin">sign in</a> or <a href="${pageContext.request.contextPath}/signup">sign up</a> first.
        </div>
    </c:if>
    <main class="container" role="main" style="margin-bottom: 400px;padding: 50px">
        <div style="color: #3b6d69">
            <h2>You can search with Drug ID or Dosing guideline ID HERE</h2>
        </div>
        <div style="padding-top: 80px; padding-left: 50%">
            <jsp:include page="search.jsp"/>
        </div>
        <c:if test="${nomatch =='nomatch'}">
            <div id="myAlert" class="alert alert-warning" style="margin-top: 80px">
                No such ID in the knowledgebase, please search again.
                <a href="${pageContext.request.contextPath}" style="float:right; color: #9d9d9d" data-dismiss="alert">x</a>
            </div>
        </c:if>

        <div class="searchannovar" style="padding-top: 80px;color: #5f805e">
            <h2>You can search with Annovar output file HERE</h2>
            <div style="padding-top: 45px; padding-left: 50%">
                <a href="${pageContext.request.contextPath}/jsp/annova.jsp" style="font-size: xx-large; color: #5f805e">
                    <span class="glyphicon glyphicon-folder-open" aria-hidden="true"></span>
                </a>
            </div>
        </div>
    </main>
    <jsp:include page="tail.jsp"/>
</div>

</body>
</html>
