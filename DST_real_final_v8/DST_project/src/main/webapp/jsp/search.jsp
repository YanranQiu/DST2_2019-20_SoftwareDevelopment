<%--
  Created by IntelliJ IDEA.
  User: cuijiajun
  Date: 2020/4/14
  Time: 5:03 下午
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
    <title>searchbox</title>
    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath()%>/static/css/search.css" rel="stylesheet">
</head>
<body style="outline: none">
<%--<jsp:include page="head.jsp" />--%>
<div class="middle">
    <form class="search-box" action="${pageContext.request.contextPath}/match" method="post">
        <input type="text" class="input" name="query">
        <button type="button"class="btn" name="button"></button>
    </form>
</div>
<script type="text/javascript">
    $(".btn").on("click",function () {
        $(".input").toggleClass("inclicked");
        $(".btn").toggleClass("close")
    });
</script>
</body>
</html>
