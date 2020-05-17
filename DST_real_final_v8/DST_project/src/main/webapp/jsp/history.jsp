<%--
  Created by IntelliJ IDEA.
  User: cuijiajun
  Date: 2020/4/7
  Time: 4:30 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>history result</title>
    <!-- Bootstrap -->
    <link href="<%=request.getContextPath()%>/static/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="<%=request.getContextPath()%>/static/jquery/jquery-3.4.1.js"></script>
    <script src="<%=request.getContextPath()%>/static/bootstrap/js/bootstrap.js"></script>
</head>
<body>
<div style="font-size: 1.5rem;">
    <jsp:include page="nav.jsp"/>
    <jsp:include page="header.jsp"/>
    <main role="main" class="container" style="margin-bottom: 400px;padding: 50px">
        <div>
            <h2>User: ${sessionScope.username}</h2>
            <h2>Search History: ${counthistory}</h2>
            <br>
        </div>
        <div class="table-responsive">
            <table class="table table-striped table-hover table-bordered">
                <thead>
                <tr>
                    <th>Username</th>
                    <th>ID</th>
                    <th>Drug ID</th>
                    <th>Drug Name</th>
                    <th>Summary</th>
                    <th>prescribing</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${history}" var="item">
                    <tr>
                        <td>${item.user_name}</td>
                        <td>${item.id}</td>
                        <td>${item.drug_id}</td>
                        <td>${item.drug_name}</td>
                        <td>${item.summary}</td>
                        <td>${item.prescribing}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div style="float: right">
            <a type="button" class="btn btn-danger" href="${pageContext.request.contextPath}/delete">Delete history</a>
        </div>
    </main>
    <jsp:include page="tail.jsp"/>
</div>
</body>
</html>
