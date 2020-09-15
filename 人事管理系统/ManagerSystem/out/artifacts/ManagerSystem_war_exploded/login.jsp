<%--
  Created by IntelliJ IDEA.
  User: 38198
  Date: 2020/8/27
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" type="text/css" href="css/Public.css">
    <link rel="stylesheet" type="text/css" href="css/Login.css">
</head>
<body>
<div id="box">
    <div id="h1">
        <h1>人事管理系统</h1>
    </div>
    <hr />

    <div id="login_body">
        <form action="/HrServlet" method="post">
            <input type="text" name="username"/><br />
            <input type="password" name="pwd"/><br />
            <input type="submit" value="登录"/><!-- <input type="submit" value="注册"/> -->
        </form>
    </div>
</div>
</body>
</html>
