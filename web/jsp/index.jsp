<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.*" %>
<html>
<head>
    <title>咸二鱼-用户信息</title>
    <link type="text/css" href="bootstrap.css" rel="stylesheet">
</head>
<body>
<table class="table table-hover">
    <tr>
        <td>用户ID</td>
        <td>密码</td>
        <td>手机号</td>
        <td>注册时间</td>
        <td>成功卖货次数</td>
        <td>昵称</td>
        <td>姓名</td>
    </tr>
    <tr>
        <td>1</td>
        <td>aaa</td>
        <td>12012541255</td>
        <td>2020-10-27 17:21:41</td>
        <td>0</td>
        <td>propose</td>
        <td>daming</td>
    </tr>
    <tr>
        <td>2</td>
        <td>bbb</td>
        <td>15214523655</td>
        <td>2020-10-27 17:27:49</td>
        <td>0</td>
        <td>kk</td>
        <td>lingling</td>
    </tr>

    <%--    <c:forEach var="f" items="${userlist}">--%>
    <%--        ${f}--%>
    <%--    </c:forEach>--%>
</table>
</body>
</html>