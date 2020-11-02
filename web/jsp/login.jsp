<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<html>
<head>
    <meta charset="utf-8">
    <title>登录</title>
</head>
<style type="text/css">
    html{background-color: aliceblue}
    form{
        width: 600px;border: 1px #000000 solid;margin: 40px auto;padding: 10px;
    }
    #aaa{
        width: 600px;height:25px;margin: 0 auto;text-align: center;font-size: 25px;color: olive;
    }
    #bbb{
        height: 200px;
    }
</style>
<body >
<%
    String name = "";
    //从cookie中获取名字name
    Cookie[] cookies = request.getCookies();
    System.out.println("cookies: " + Arrays.toString(cookies));
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("name".equals(cookie.getName())) {
                name = cookie.getValue();
                System.out.println("name=" + name);
            }
        }
    }
%>
<div id="aaa">
    ${requestScope.info}
</div>
<form action="${pageContext.request.contextPath}/userServlet?type=login" method="post" >
    <fieldset id="bbb">
        <legend>咸二鱼用户信息</legend>
        <p style="font-size: 15px; margin-top: 10px">用户名:<input type="text" name="username" value="<%=name%>" style="width: 190px; height: 30px"/><br/></p>
        <p></p>
        <p style="font-size: 15px; margin-top: 10px">密 &nbsp&nbsp&nbsp码:<input type="password" name="password" style="width: 190px; height: 30px"/><br/></p>
        <input style="margin-left: 0;margin-top: 10px;font-size: 15px"type="submit" value="登录"/>
        <input style="margin-right: 0;font-size: 15px" type="reset" value="重置" />
    </fieldset>
</form>
</body>
</html>