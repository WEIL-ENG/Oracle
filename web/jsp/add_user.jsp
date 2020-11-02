<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
<h3>添加用户</h3>
<form action="${pageContext.request.contextPath}/userServlet?type=add" method="post">
    <table>
        <tr>
            <td>昵称:</td>
            <td><input type="text" name="NICKNAME"></td>
        </tr>
        <tr>
            <td>真实姓名:</td>
            <td><input type="text" name="NAME"></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" name="PASSWORD"></td>
        </tr>
        <tr>
            <td>手机号:</td>
            <td><input type="text" name="PHONE"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="添加"><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>
</html>
