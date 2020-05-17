<%--
  Created by IntelliJ IDEA.
  User: cuijiajun
  Date: 2020/4/7
  Time: 4:31 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>druglabels</title>
    <!-- Bootstrap -->
    <link href="<%=request.getContextPath()%>/static/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="<%=request.getContextPath()%>/static/jquery/jquery-3.4.1.js"></script>
    <script src="<%=request.getContextPath()%>/static/bootstrap/js/bootstrap.js"></script>

</head>
<body style="outline: none">
<div style="font-size: 1.5rem;">
    <jsp:include page="nav.jsp"/>
    <jsp:include page="header.jsp"/>

    <main role="main" class="container" style="margin-bottom: 400px;padding: 50px">
        <div>
            <h2>Drug Labels</h2>
        </div>
        <div class="table-responsive">
            <table class="table table-striped table-hover table-bordered">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Source</th>
                    <th>Dosing Information</th>
                    <th>Summary Markdown</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${drugLabels}" var="item">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.source}</td>
                        <td>${item.dosingInformation}</td>
                        <td>${item.summaryMarkdown}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </main>
    <jsp:include page="tail.jsp"/>
</div>
</body>
</html>
