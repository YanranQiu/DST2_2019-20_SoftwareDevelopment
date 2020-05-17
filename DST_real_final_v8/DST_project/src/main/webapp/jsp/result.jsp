<%--
  Created by IntelliJ IDEA.
  User: cuijiajun
  Date: 2020/4/22
  Time: 5:36 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>results</title>
    <!-- Bootstrap -->
    <link href="<%=request.getContextPath()%>/static/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="<%=request.getContextPath()%>/static/jquery/jquery-3.4.1.js"></script>
    <script src="<%=request.getContextPath()%>/static/bootstrap/js/bootstrap.js"></script>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body style="font-size: 1.5rem;">
<jsp:include page="nav.jsp"/>
<jsp:include page="header.jsp"/>
<main role="main" class="container" style="margin-bottom: 400px;padding: 50px">
    <c:if test="${annovar ==null}">
        <div id="myAlert" class="alert alert-warning" style="margin-top: 80px">
            Sorry, there is no drug in the database for genes provided.
            <a href="<%=request.getContextPath()%>" style="float:right; color: #9d9d9d" data-dismiss="alert">x</a>
        </div>
    </c:if>
    <div>
        <h2>Annovar Annotation</h2>
    </div>
    <div class="table-responsive">
        <table class="table table-striped table-hover table-bordered">
            <thead>
            <tr>
                <th>Annovar file</th>
                <th>Genes</th>
                <th>Drug ID</th>
                <th>Drug Name</th>
                <th>Dosing guideline</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${allinfo}" var="item">
                <tr>
                    <td>${item[4]}</td>
                    <td>${item[0]}</td>
                    <td>${item[1]}</td>
                    <td>${item[2]}</td>
                    <td>${item[3]}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</main>
<jsp:include page="tail.jsp"/>

</body>
</html>
