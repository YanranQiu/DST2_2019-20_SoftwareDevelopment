<%--
  Created by IntelliJ IDEA.
  User: cuijiajun
  Date: 2020/4/22
  Time: 5:34 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>view</title>
    <!-- Bootstrap -->
    <link href="<%=request.getContextPath()%>/static/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="<%=request.getContextPath()%>/static/jquery/jquery-3.4.1.js"></script>
    <script src="<%=request.getContextPath()%>/static/bootstrap/js/bootstrap.js"></script>
</head>
<body style="font-size: 1.5rem;">
<jsp:include page="nav.jsp"/>
<jsp:include page="header.jsp"/>
<main role="main" class="container" style="margin-bottom: 400px;padding: 50px">
    <c:if test="${filter !=null}">
        <div id="myAlert" class="alert alert-success" style="margin-bottom: 400px;">
            <a href="<%=request.getContextPath()%>" class="close" data-dismiss="alert">&times;</a>
            <strong>Success</strong> to upload Annovar output file, now you can <a href="<%=request.getContextPath()%>/annovarresult">view the result here!</a>
        </div>
    </c:if>
    <c:if test="${filter ==null}">
        <div id="myAlert" class="alert alert-warning" style="margin-top: 80px">
            Try again! Wrong file format, one .tsv/.txt file should be upload.
            <a href="<%=request.getContextPath()%>" style="float:right; color: #9d9d9d" data-dismiss="alert">x</a>
        </div>
    </c:if>
</main>
<jsp:include page="tail.jsp"/>
</body>
</html>
