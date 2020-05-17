
<%--
  Created by IntelliJ IDEA.
  User: cuijiajun
  Date: 2020/4/16
  Time: 3:15 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>annovar search</title>
    <!-- Bootstrap -->
    <link href="<%=request.getContextPath()%>/static/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="<%=request.getContextPath()%>/static/jquery/jquery-3.4.1.js"></script>
    <script src="<%=request.getContextPath()%>/static/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/jquery/file.js"></script>

<style>
    .a-upload{
        padding: 4px 10px;
        /*height: 34px;*/
        line-height: 28px;
        position: relative;
        cursor: pointer;
        color: #fff;
        background-color: #5f805e;
        border-color: #5f805e;
        border-radius: 4px;
        overflow: hidden;
        display: inline-block;
        *display: inline;
        *zoom: 1;
    }
    .a-upload input{
        position: absolute;
        font-size: 100px;
        right: 0;
        top: 0;
        opacity: 0;
        filter: alpha(opacity=0);
        cursor: pointer
    }
    .a-upload:hover{
        color: #FFFFFF;
        background: #5f805e;
        border-color: #5f805e;
        text-decoration: none;
    }
</style>
</head>
<body>
<div style="font-size: 1.5rem;">
    <jsp:include page="nav.jsp"/>
    <jsp:include page="header.jsp"/>
    <div style="margin-bottom: 400px;padding-left: 40px; padding-top: 80px">
    <div class="help-block">
        <h4>please upload your Annovar output file here</h4>
    </div>
        <form enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/file">
            <a href="#" id="upload" class="a-upload mr10">
        <input type="file" name="file" id="">upload your file
            </a>
            <div class="showFileName"></div>
            <br>
                <button id="uploadBtn" type="submit" class="btn" style="background: #5f805e; color: #FFFFFF">
                    upload
                </button>
        </form>
    </div>
    <jsp:include page="tail.jsp"/>
</div>

</body>
</html>
