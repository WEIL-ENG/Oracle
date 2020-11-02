<%@ page import="java.util.List" %>
<%@ page import="Operation.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>用户列表</title>
</head>
<body>
<script type="text/javascript">
    function del(id) {
        var flag = confirm("确定要删除吗？");
        if (flag) {
            window.location = "/Oracle10/userServlet?type=delete&userid=" + id
        }
    }
</script>
<%--${requestScope.info}<br/>--%>
<h2 align="center" color="blue">用户表</h2>
<table border="1" align="center" bgcolor="#ffffff" width="100%" heigth="100%">
    <tr>
        <td align="center">用户ID</td>
        <td align="center">昵称</td>
        <td align="center">姓名</td>
        <td align="center">密码</td>
        <td align="center">手机号</td>
        <td align="center">注册时间</td>
        <td align="center">成功卖货次数</td>
    </tr>
    <c:forEach var="user" items="${requestScope.list}">
        <tr align="center">
            <td>${user.USERID}</td>
            <td>${user.NICKNAME}</td>
            <td>${user.NAME}</td>
            <td>${user.PASSWORD}</td>
            <td>${user.PHONE}</td>
            <td>${user.REGTIME}</td>
            <td>${user.SELLITIMES}</td>
            <td>
                <a href="javascript:del(${user.USERID})">删除</a>
                <a href="${pageContext.request.contextPath}/userServlet?type=querybyid&USERID=${user.USERID}">修改</a>
            </td>
        </tr>
    </c:forEach>
    <a href="${pageContext.request.contextPath}/jsp/add_user.jsp">添加用户</a>
</table>
</body>
</html>

