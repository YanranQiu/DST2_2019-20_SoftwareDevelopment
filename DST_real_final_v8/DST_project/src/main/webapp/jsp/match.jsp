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
    <title>match result</title>
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
            <h2>Drug ID: ${drugsearch[1].drug_id}</h2>
            <br>
        </div>
        <div class="table-responsive">
            <table class="table table-striped table-hover table-bordered">
                <thead>
                <tr>
                    <th>Dosing Guideline ID</th>
                    <th>Drug ID</th>
                    <th>Drug Name</th>
                    <th>Dosing Guideline Name</th>
                    <th>Dosing Guideline Recommendation</th>
                    <th>Drug Biomarker</th>
                    <th>Drug Label.alternate Drug Available</th>
                    <th>Dosing Guideline Source</th>
                    <th>Drug Label Source</th>
                    <th>Drug Label.prescribing Markdown</th>
                    <th>Dosing Guideline.Summary Markdown</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${drugsearch}" var="item">
                    <tr>
                        <td>${item.dosing_guideline_id}</td>
                        <td>${item.drug_id}</td>
                        <td>${item.drug_name}</td>
                        <td>${item.dosing_guideline_name}</td>
                        <td>${item.dosing_guideline_recommendation}</td>
                        <td>${item.drug_biomarker}</td>
                        <td>${item.drug_label_alternate_drug_available}</td>
                        <td>${item.dosing_guideline_source}</td>
                        <td>${item.drug_label_source}</td>
                        <td>${item.drug_label_prescribing_markdown}</td>
                        <td>${item.dosing_guideline_summary_markdown}</td>
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
