<%--
  Created by IntelliJ IDEA.
  User: cuijiajun
  Date: 2020/4/24
  Time: 10:08 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="<%=request.getContextPath()%>/static/bootstrap/css/bootstrap.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/static/jquery/jquery-3.4.1.js"></script>
<script src="<%=request.getContextPath()%>/static/bootstrap/js/bootstrap.js"></script>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <meta name="description" content="Medguide Knowledgebase">
    <meta name="author" content="DST2 group cuijiajun">
    <meta name="generator" content="">
    <title>contactus</title>
    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath()%>/static/css/contact.css" rel="stylesheet">
</head>
<body class="smart-green">
<form action="<%=request.getContextPath()%>/contact" method="post" class="STYLE-NAME" style="margin-top: 50%">
    <h1>Contact Form
        <span>Please fill all the texts in the fields.</span>
    </h1>
    <label>
        <span>Your Name :</span>
        <input id="name" type="text" name="name" placeholder="Your Full Name" />
    </label>
    <label>
        <span>Your Email :</span>
        <input id="email" type="email" name="email" placeholder="Valid Email Address" />
    </label>
    <label>
        <span>Message :</span>
        <textarea id="message" name="message" placeholder="Your Message to Us"></textarea>
    </label>
    <label>
        <span>&nbsp;</span>
        <button type="submit" class="button">Send</button>
    </label>
</form>
</body>
</html>
