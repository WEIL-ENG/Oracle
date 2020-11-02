<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息修改</title>
</head>
<body>
<h3>用户信息修改</h3>
<form action="${pageContext.request.contextPath}/userServlet?type=edit" method="post">
    <input type="hidden" name="USERID" value="${requestScope.userinfo.USERID}"/>
    <input type="hidden" name="REGTIME" value="${requestScope.userinfo.REGTIME}"/>
    <input type="hidden" name="SELLITIMES" value="${requestScope.userinfo.SELLITIMES}"/>
    <table>
        <tr>
            <td>昵称：</td>
            <td><input type="text" name="NICKNAME" value="${requestScope.userinfo.NICKNAME}"/></td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td><input type="text" name="NAME" value="${requestScope.userinfo.NAME}"/></td>
        </tr>
        <tr>
            <td>手机号：</td>
            <td><input type="text" name="PHONE" value="${requestScope.userinfo.PHONE}"/></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="text" name="PASSWORD" value="${requestScope.userinfo.PASSWORD}"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="保存"/></td>
        </tr>
    </table>
</form>
</body>
</html>